package net.jakemorris.stockfetch.controller;

import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class QuoteController {
    QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("quote/{symbol}")
    public Quote getQuote(@PathVariable String symbol) throws SQLException {return quoteService.getQuote(symbol);}
}
