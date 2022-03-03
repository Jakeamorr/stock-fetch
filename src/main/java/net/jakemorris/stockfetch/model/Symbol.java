package net.jakemorris.stockfetch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "symbol")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbol {
    @Id
    @Column(name = "symbol")
    public String symbol;

    @Column(name = "name")
    public String name;

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
