package net.jakemorris.stockfetch.dao;

import net.jakemorris.collections.ArrayList;
import net.jakemorris.collections.List;
import net.jakemorris.stockfetch.model.Symbol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SymbolDaoTest {
//    List<Symbol> mockList;
//    Symbol mockSymbol;
//    SymbolDao mockDao;
//    ResultSet mockResultSet;

    @BeforeAll
    public static void setup() {
        List<Symbol> mockList = new ArrayList<>(1);
        Symbol mockSymbol = new Symbol("TSLA", "Tesla");
        SymbolDao mockDao = Mockito.mock(SymbolDao.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
    }

    @Test
    public void addSymbols(List<Symbol> list) throws SQLException {
        // Mockito.when(mockdao.addSymbols(testList));
    }

    @Test
    public void findSymbol(String symbol) throws SQLException {
        Symbol testSymbol = new Symbol("TSLA", "Tesla");
        SymbolDao mockDao = Mockito.mock(SymbolDao.class);

        assertTrue(mockDao.findSymbol("TSLA"));

        // Mockito.when(mockDao.findSymbol("TSLA")).thenReturn(true);
        // assertEquals(mockDao.findSymbol(testSymbol.getSymbol()), true);
    }
}