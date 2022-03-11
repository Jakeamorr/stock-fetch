package net.jakemorris.stockfetch.service;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.dao.ExchangeDao;
import net.jakemorris.stockfetch.model.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeService {
    private final ExchangeDao exchangeDao;

    public List<Exchange> getExchanges() {
        return exchangeDao.getExchanges();
    }
}
