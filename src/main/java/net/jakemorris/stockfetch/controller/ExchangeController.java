package net.jakemorris.stockfetch.controller;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.model.Exchange;
import net.jakemorris.stockfetch.service.ExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping()
    public List<Exchange> getExchanges() {
        return exchangeService.getExchanges();
    }
}
