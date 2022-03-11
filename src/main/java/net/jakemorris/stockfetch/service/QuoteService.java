package net.jakemorris.stockfetch.service;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.dao.QuoteDao;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.QuoteAggregate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteDao quoteDao;

    public Quote getQuote(String symbol) {
        return quoteDao.getQuote(symbol);
    }

    public List<Quote> getQuotes() throws SQLException {
        return quoteDao.getQuotes();
    }

    public void addQuote(Quote q) throws SQLException {
        quoteDao.addQuote(q);
    }

    public void removeQuote(String symbol) throws SQLException {
        quoteDao.removeQuote(symbol);
    }

    public void generateSampleQuotes() {
        quoteDao.generateSampleQuotes();
    }

    public List<QuoteAggregate> getQuotesByMarketCap() {
        return quoteDao.getQuotesByMarketCap();
    }

public List<Quote> getQuotesByPositiveChange() { return quoteDao.getQuotesByPositiveChange(); }

    public void dropTables() {
        quoteDao.dropTables();
    }
}
