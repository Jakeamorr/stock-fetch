package net.jakemorris.stockfetch.controller;

import lombok.RequiredArgsConstructor;
import net.jakemorris.stockfetch.model.Symbol;
import net.jakemorris.stockfetch.service.SymbolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("symbols")
@RequiredArgsConstructor
public class SymbolController {
    private final SymbolService symbolService;

    @GetMapping()
    public List<Symbol> getSymbols() { return symbolService.getSymbols(); }

    @PostMapping()
    public void addSymbols(@RequestBody List<Symbol> symbols) { symbolService.addSymbols(symbols); }

    @DeleteMapping("{symbol}")
    public void removeSymbol(@PathVariable String symbol) {
        symbolService.removeSymbol(symbol);
    }
}
