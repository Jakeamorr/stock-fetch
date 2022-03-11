package net.jakemorris.stockfetch.model;

import javax.persistence.*;

@Entity
@Table(name = "symbol")
public class Symbol {

    @Id
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;

    public Symbol() {}

    public Symbol(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public String toString() {
        return "symbol: " + symbol + "\n" +
               "name: " + name + "\n";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
