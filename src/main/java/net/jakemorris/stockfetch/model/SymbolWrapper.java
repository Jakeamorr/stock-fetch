package net.jakemorris.stockfetch.model;


import net.jakemorris.collections.List;

public class SymbolWrapper {
    private List<Symbol> symbols;

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}
