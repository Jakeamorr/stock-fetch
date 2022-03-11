package net.jakemorris.stockfetch.controller;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.QuoteAggregate;
import net.jakemorris.stockfetch.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping("quote/{symbol}")
    public Quote getQuote(@PathVariable String symbol) {return quoteService.getQuote(symbol);}

    @GetMapping("quotes")
    public List<Quote> getQuotes() throws SQLException {return quoteService.getQuotes();}

    @PostMapping("quote")
    public void addQuote(@RequestBody Quote quote) throws SQLException {
        quoteService.addQuote(quote);
    }

    @GetMapping("quotes/generate")
    public void generateSampleQuotes() { quoteService.generateSampleQuotes(); }

    @DeleteMapping("quote/{symbol}")
    public void removeQuote(@PathVariable String symbol) throws SQLException {
        try {
            quoteService.removeQuote(symbol);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("quotes/marketCap")
    public List<QuoteAggregate> getQuotesByMarketCap() {
        return quoteService.getQuotesByMarketCap();
    }

    @GetMapping("bobbyTables")
    public void dropTables() {
        quoteService.dropTables();
    }
}
