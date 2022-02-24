package net.jakemorris.stockfetch.dao;

import net.jakemorris.collections.ArrayList;
import net.jakemorris.collections.List;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.util.ConnectionUtil;

import java.sql.*;

public class QuoteDao {
    private final Connection conn;

    public QuoteDao() {
        this.conn = ConnectionUtil.getConnection();
    }

    public Quote getQuote(String symbol) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("Select * From quote where symbol = ?");
        statement.setString(1, symbol);
        ResultSet rs = statement.executeQuery();
        Quote quote = null;
        while(rs.next()){
            quote = new Quote(
                    rs.getString("symbol"),
                    rs.getString("companyName"),
                    rs.getString("calculationPrice"),
                    rs.getFloat("open"),
                    rs.getFloat("close"),
                    rs.getFloat("high"),
                    rs.getFloat("low"),
                    rs.getFloat("latestPrice"),
                    rs.getLong("latestVolume"),
                    rs.getFloat("delayedPrice"),
                    rs.getFloat("oddLotDelayedPrice"),
                    rs.getFloat("extendedPrice"),
                    rs.getFloat("extendedChange"),
                    rs.getFloat("extendedChangePercent"),
                    rs.getFloat("previousClose"),
                    rs.getInt("previousVolume"),
                    rs.getFloat("change"),
                    rs.getFloat("changePercent"),
                    rs.getInt("volume"),
                    rs.getString("avgTotalVolume"),
                    rs.getLong("marketCap"),
                    rs.getFloat("peRatio"),
                    rs.getFloat("week52High"),
                    rs.getFloat("week52Low"),
                    rs.getDouble("ytdChange"),
                    rs.getLong("lastTradeTime"),
                    rs.getString("currency")
            );
        }
        rs.close();
        return quote;
    }

    public List<Quote> getQuotes() throws SQLException {
        PreparedStatement statement = conn.prepareStatement("Select * From quote");
        ResultSet rs = statement.executeQuery();
        List<Quote> quotes = new ArrayList<>(1);
        while(rs.next()){
            Quote quote = new Quote(
                rs.getString("symbol"),
                rs.getString("companyName"),
                rs.getString("calculationPrice"),
                rs.getFloat("open"),
                rs.getFloat("close"),
                rs.getFloat("high"),
                rs.getFloat("low"),
                rs.getFloat("latestPrice"),
                rs.getLong("latestVolume"),
                rs.getFloat("delayedPrice"),
                rs.getFloat("oddLotDelayedPrice"),
                rs.getFloat("extendedPrice"),
                rs.getFloat("extendedChange"),
                rs.getFloat("extendedChangePercent"),
                rs.getFloat("previousClose"),
                rs.getInt("previousVolume"),
                rs.getFloat("change"),
                rs.getFloat("changePercent"),
                rs.getInt("volume"),
                rs.getString("avgTotalVolume"),
                rs.getLong("marketCap"),
                rs.getFloat("peRatio"),
                rs.getFloat("week52High"),
                rs.getFloat("week52Low"),
                rs.getDouble("ytdChange"),
                rs.getLong("lastTradeTime"),
                rs.getString("currency")
            );
            quotes.add(quote);
        }
        rs.close();
        return quotes;
    }

    public void removeQuote(String symbol) throws SQLException {
        PreparedStatement statement = this.conn.prepareStatement("DELETE FROM quote WHERE symbol = ?");
        statement.setString(1, symbol);
        statement.executeUpdate();
    }


    public void addQuote(Quote q) throws SQLException {
        // Check if quote already exists, if so remove and add new quote
        Quote quote = getQuote(q.getSymbol());
        if (quote != null) {
            removeQuote(q.getSymbol());
        }

        PreparedStatement statement = this.conn.prepareStatement("INSERT INTO quote VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        int parameterIndex = 0;

        statement.setString(++parameterIndex, q.getSymbol());
        statement.setString(++parameterIndex, q.getCompanyName());
        statement.setString(++parameterIndex, q.getCalculationPrice());

        if (q.getIexOpen() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getIexOpen());
        }

        if (q.getIexClose() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getIexClose());
        }

        if (q.getHigh() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getHigh());
        }

        if (q.getLow() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getLow());
        }

        if (q.getLatestPrice() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getLatestPrice());
        }

        if (q.getLatestVolume() == null) {
            statement.setNull(++parameterIndex, Types.BIGINT);
        } else {
            statement.setLong(++parameterIndex, q.getLatestVolume());
        }

        if (q.getDelayedPrice() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getDelayedPrice());
        }

        if (q.getOddLotDelayedPrice() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getOddLotDelayedPrice());
        }

        if (q.getExtendedPrice() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getExtendedPrice());
        }

        if (q.getExtendedChange() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getExtendedChange());
        }

        if (q.getExtendedChangePercent() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getExtendedChangePercent());
        }

        if (q.getPreviousClose() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getPreviousClose());
        }

        if (q.getPreviousVolume() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getPreviousVolume());
        }

        if (q.getChange() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getChange());
        }

        if (q.getChangePercent() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getChangePercent());
        }

        if (q.getIexVolume() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getIexVolume());
        }

        statement.setString(++parameterIndex, q.getAvgTotalVolume());

        if (q.getMarketCap() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getMarketCap());
        }

        if (q.getPeRatio() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getPeRatio());
        }

        if (q.getWeek52High() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getWeek52High());
        }

        if (q.getWeek52Low() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setFloat(++parameterIndex, q.getWeek52Low());
        }

        if (q.getYtdChange() == null) {
            statement.setNull(++parameterIndex, Types.FLOAT);
        } else {
            statement.setDouble(++parameterIndex, q.getYtdChange());
        }

        if (q.getLastTradeTime() == null) {
            statement.setNull(++parameterIndex, Types.BIGINT);
        } else {
            statement.setFloat(++parameterIndex, q.getLastTradeTime());
        }

        statement.setString(++parameterIndex, q.getCurrency());

        statement.executeUpdate();
    }
}

