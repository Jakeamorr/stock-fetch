package net.jakemorris.stockfetch.dao;

import net.jakemorris.collections.ArrayList;
import net.jakemorris.collections.List;
import net.jakemorris.stockfetch.model.Symbol;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SymbolDaoTest {

    @Test
    public void addSymbols(List<Symbol> list) throws SQLException {
        List<Symbol> testList = new ArrayList<>(1);
        Symbol testSymbol = new Symbol("TSLA", "Tesla");
        SymbolDao mockdao = Mockito.mock(SymbolDao.class);

        List<Symbol> mockReturnList = new ArrayList<>(1);
        Symbol mockSymbol = new Symbol("TSLA", "Tesla");

        // Mockito.when(mockdao.addSymbols(testList));
    }

    @Test
    public void findSymbol(String symbol) throws SQLException {
        Symbol testSymbol = new Symbol("TSLA", "Tesla");
        SymbolDao mockDao = Mockito.mock(SymbolDao.class);

        // Mockito.when(mockDao.findSymbol("TSLA")).thenReturn(true);
        // assertEquals(mockDao.findSymbol(testSymbol.getSymbol()), true);
    }
}