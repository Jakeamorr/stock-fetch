package net.jakemorris.stockfetch.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.jakemorris.stockfetch.dao.QuoteDao;
import net.jakemorris.stockfetch.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@NoArgsConstructor
public class QuoteService {
    private QuoteDao quoteDao;

    @Autowired
    public QuoteService(QuoteDao quoteDao) { this.quoteDao = quoteDao;}

    public Quote getQuote(String symbol) throws SQLException {
        return quoteDao.getQuote(symbol);
    }
}
