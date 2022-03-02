package net.jakemorris.stockfetch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jakemorris.stockfetch.dao.SymbolDao;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.Symbol;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Api {
    private final String sandboxToken = getConnectionString(Token.DEV);
    private final String liveToken = getConnectionString(Token.PROD);
    private final String apiTokenString = "?token=" + this.sandboxToken;
    private final String prodApiTokenString = "?token=" + this.liveToken;
    private final String sandboxUrl = "https://sandbox.iexapis.com/stable";
    private final String liveApiUrl = "https://cloud.iexapis.com/stable";

    public String getConnectionString(Token token) {
        Properties props = new Properties();
        try {
            props.load(Api.class.getClassLoader().getResourceAsStream("stockfetch.properties"));
            if (token == token.PROD) return props.getProperty("prodToken");
            else return props.getProperty("devToken");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Symbol> getAllSymbols() {
        String pathParams = "/ref-data/symbols";
        String apiEndpoint = this.liveApiUrl + pathParams + this.apiTokenString;
        
        ObjectMapper mapper = new ObjectMapper();

        // The default Apache HttpClient has some issues parsing recent RFC-compliant headers, update cookie spec to handle it
        try(CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build()) {
            HttpGet req = new HttpGet(apiEndpoint);

            try(CloseableHttpResponse res = client.execute(req)) {
                HttpEntity entity = res.getEntity();
                String jsonStr = EntityUtils.toString(entity);
                // List<Symbol> symbols = mapper.readValue(jsonStr, TypeFactory.defaultInstance().constructCollectionType(List.class, Symbol.class));
                List<Symbol> symbols = mapper.readValue(jsonStr, new TypeReference<List<Symbol>>() {});
                return symbols;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Quote getQuote(String symbol) throws InvalidQuoteException, SQLException, APIConnectionException {
        String pathParams = "/stock/" + symbol + "/quote";
        String apiEndpoint = this.sandboxUrl + pathParams + this.apiTokenString;
        // String apiEndpoint = this.liveApiUrl + pathParams + this.prodApiTokenString;

        SymbolDao symbolDao = new SymbolDao();
        boolean validSymbol = symbolDao.findSymbol(symbol);

        if (!validSymbol) {
            throw new InvalidQuoteException("The ticker symbol provided does not match any known stock");
        }

        ObjectMapper mapper = new ObjectMapper();
        // The default Apache HttpClient has some issues parsing recent RFC-compliant headers, update cookie spec to handle it
        try(CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build()) {
            HttpGet req = new HttpGet(apiEndpoint);

            try(CloseableHttpResponse res = client.execute(req)) {
                if(res.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = res.getEntity();
                    String jsonStr = EntityUtils.toString(entity);
                    Quote q = mapper.readValue(jsonStr, Quote.class);
                    return q;
                } else {
                    throw new APIConnectionException("API endpoint is currently unavailable, please try again momentarily");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

