package net.jakemorris.stockfetch.service;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.dao.QuoteDao;
import net.jakemorris.stockfetch.model.Quote;
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
        // If a quote already exists in our list, remove it and add the most up-to-date information
        Quote existingQuote = getQuote(q.getSymbol());
        if (existingQuote != null) {
            removeQuote(q.getSymbol());
        }

        quoteDao.addQuote(q);
    }

    public void removeQuote(String symbol) throws SQLException {
        quoteDao.removeQuote(symbol);
    }
}
