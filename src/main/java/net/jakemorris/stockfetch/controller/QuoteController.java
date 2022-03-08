package net.jakemorris.stockfetch.controller;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.service.QuoteService;
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

    @PostMapping("quote/{quote}")
    public void addQuote(@PathVariable Quote quote) throws SQLException {
        quoteService.addQuote(quote);
    }

    @DeleteMapping("quote/{symbol}")
    public void removeQuote(@PathVariable String symbol) throws SQLException {
        quoteService.removeQuote(symbol);
    }
}
