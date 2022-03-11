package net.jakemorris.stockfetch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Formatter;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    Long quoteId;

    @Column(name = "iexOpen")
    Float iexOpen;

    @Column(name="iexClose")
    Float iexClose;

    @Column(name = "high")
    Float high;

    @Column(name = "low")
    Float low;

    @Column(name = "latestPrice")
    Float latestPrice;

    @Column(name = "changePercent")
    Float changePercent;

    @Column(name = "iexVolume")
    Integer iexVolume;

    @Column(name = "marketCap")
    Long marketCap;

    @Column(name = "week52High")
    Float week52High;

    @Column(name = "week52Low")
    Float week52Low;

    @Column(name = "ytdChange")
    Double ytdChange;

    @Column(name = "currency")
    String currency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol")
    Symbol symbol;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "exchange_id")
    private Exchange exchange;

    public Quote() {}

    public Quote(Float iexOpen, Float iexClose, Float high, Float low, Float latestPrice,
                 Float changePercent, Integer iexVolume, Long marketCap, Float week52High, Float week52Low,
                 Double ytdChange, String currency) {
        this.iexOpen = iexOpen;
        this.iexClose = iexClose;
        this.high = high;
        this.low = low;
        this.latestPrice = latestPrice;
        this.changePercent = changePercent;
        this.iexVolume = iexVolume;
        this.marketCap = marketCap;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.currency = currency;
    }

    public Quote(Float iexOpen, Float iexClose, Float high, Float low, Float latestPrice,
                 Float changePercent, Integer iexVolume, Long marketCap, Float week52High, Float week52Low,
                 Double ytdChange, String currency, Exchange exchange) {
        this.iexOpen = iexOpen;
        this.iexClose = iexClose;
        this.high = high;
        this.low = low;
        this.latestPrice = latestPrice;
        this.changePercent = changePercent;
        this.iexVolume = iexVolume;
        this.marketCap = marketCap;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.currency = currency;
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        // TODO: f.format("| %-28s| %-41s|\n", "symbol", symbol.getSymbol());
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "open", iexOpen);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "close", iexClose);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "high", high);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "low", low);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "changePercent", changePercent);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "volume", iexVolume);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "marketCap", marketCap);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "week52High", week52High);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "week52Low", week52Low);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "ytdChange", ytdChange);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "currency", currency).toString();
        return " ------------------------------------------------------------------------ \n" +
                f +
                " ------------------------------------------------------------------------ ";
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public Float getIexOpen() {
        return iexOpen;
    }

    public void setIexOpen(Float iexOpen) {
        this.iexOpen = iexOpen;
    }

    public Float getIexClose() {
        return iexClose;
    }

    public void setIexClose(Float iexClose) {
        this.iexClose = iexClose;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Float latestPrice) {
        this.latestPrice = latestPrice;
    }


    public Float getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Float changePercent) {
        this.changePercent = changePercent;
    }

    public Integer getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(Integer iexVolume) {
        this.iexVolume = iexVolume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Float getWeek52High() {
        return week52High;
    }

    public void setWeek52High(Float week52High) {
        this.week52High = week52High;
    }

    public Float getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(Float week52Low) {
        this.week52Low = week52Low;
    }

    public Double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(Double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}

