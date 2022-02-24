package net.jakemorris.stockfetch.dao;

import net.jakemorris.collections.List;
import net.jakemorris.stockfetch.model.Symbol;
import net.jakemorris.stockfetch.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SymbolDao {
    private Connection conn;

    public SymbolDao() {
        this.conn = ConnectionUtil.getConnection();
    }

    public void addSymbols(List<Symbol> list) throws SQLException {
        for (Symbol symbol : list) {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO symbol VALUES (?, ?)");
            int parameterIndex = 0;
            statement.setString(++parameterIndex, symbol.getSymbol());
            statement.setString(++parameterIndex, symbol.getName());
            statement.executeUpdate();
        }
    }

    public boolean findSymbol(String symbol) throws SQLException {
        boolean validSymbol;
        PreparedStatement statement = conn.prepareStatement("Select * From symbol Where symbol = ?");
        statement.setString(1, symbol);

        ResultSet rs = statement.executeQuery();
        if(rs.next()) {
            validSymbol = true;
        } else {
            validSymbol = false;
        }
        rs.close();
        return validSymbol;
    }
}
