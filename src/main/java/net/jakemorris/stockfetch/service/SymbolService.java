package net.jakemorris.stockfetch.service;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.dao.SymbolDao;
import net.jakemorris.stockfetch.model.Symbol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymbolService {
    private final SymbolDao symbolDao;

    public List<Symbol> getSymbols() {
        return symbolDao.getSymbols();
    }

    public void addSymbols(List<Symbol> symbols) {
        symbolDao.addSymbols(symbols);
    }

    public void removeSymbol(String symbol) {
        symbolDao.removeSymbol(symbol);
    }
}
