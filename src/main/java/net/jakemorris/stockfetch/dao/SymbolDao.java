package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Symbol;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SymbolDao {

    public void addSymbols(List<Symbol> list) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        // TODO: need to double check this
        session.persist(list);
        session.close();
    }

    public boolean getSymbol(String symbol) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Symbol s = session.createQuery("FROM Symbol WHERE symbol = :symbol", Symbol.class).setParameter("symbol", symbol).uniqueResult();
        session.close();
        return s != null;
    }
}
