package net.jakemorris.stockfetch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Formatter;

@Entity
@Table(name = "quote")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @Id
    @Column(name = "symbol")
    String symbol;

    @Column(name = "companyName")
    String companyName;

    @Column(name = "calculationPrice")
    String calculationPrice;

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

    @Column(name = "latestVolume")
    Long latestVolume;

    @Column(name = "delayedPrice")
    Float delayedPrice;

    @Column(name = "oddLotDelayedPrice")
    Float oddLotDelayedPrice;

    @Column(name = "extendedPrice")
    Float extendedPrice;

    @Column(name = "extendedChange")
    Float extendedChange;

    @Column(name = "extendedChangePercent")
    Float extendedChangePercent;

    @Column(name = "previousClose")
    Float previousClose;

    @Column(name = "previousVolume")
    Integer previousVolume;

    @Column(name = "change")
    Float change;

    @Column(name = "changePercent")
    Float changePercent;

    @Column(name = "volume")
    Integer iexVolume;

    @Column(name = "avgTotalVolume")
    String avgTotalVolume;

    @Column(name = "marketCap")
    Long marketCap;

    @Column(name = "peRatio")
    Float peRatio;

    @Column(name = "week52High")
    Float week52High;

    @Column(name = "week52Low")
    Float week52Low;

    @Column(name = "ytdChange")
    Double ytdChange;

    @Column(name = "lastTradeTime")
    Long lastTradeTime;

    @Column(name = "currency")
    String currency;

    @Override
    public String toString() {
        Formatter f = new Formatter();
        f.format("| %-28s| %-41s|\n", "symbol", symbol);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "companyName", companyName);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "calculationPrice", calculationPrice);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "open", iexOpen);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "close", iexClose);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "high", high);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "low", low);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "latestVolume", latestVolume);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "delayedPrice", delayedPrice);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "oddLotDelayedPrice", oddLotDelayedPrice);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "extendedPrice", extendedPrice);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "extendedChange", extendedChange);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "extendedChangePercent", extendedChangePercent);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "previousClose", previousClose);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "previousVolume", previousVolume);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "change", change);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "changePercent", changePercent);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "volume", iexVolume);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "avgTotalVolume", avgTotalVolume);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "marketCap", marketCap);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "peRatio", peRatio);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "week52High", week52High);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "week52Low", week52Low);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "ytdChange", ytdChange);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "lastTradeTime", lastTradeTime);
        f.format("|%-28s|%-42s|\n", "-----------------------------", "------------------------------------------");
        f.format("| %-28s| %-41s|\n", "currency", currency).toString();
        return " ------------------------------------------------------------------------ \n" +
                f +
                " ------------------------------------------------------------------------ ";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
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

    public Long getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Long latestVolume) {
        this.latestVolume = latestVolume;
    }

    public Float getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(Float delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public Float getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    public void setOddLotDelayedPrice(Float oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    public Float getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(Float extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public Float getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(Float extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Float getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Float extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public Float getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Float previousClose) {
        this.previousClose = previousClose;
    }

    public Integer getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(Integer previousVolume) {
        this.previousVolume = previousVolume;
    }

    public Float getChange() {
        return change;
    }

    public void setChange(Float change) {
        this.change = change;
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

    public String getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(String avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Float getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Float peRatio) {
        this.peRatio = peRatio;
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

    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(Long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
