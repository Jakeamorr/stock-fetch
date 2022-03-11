package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Symbol;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymbolDao {

    public void addSymbols(List<Symbol> list) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        for (Symbol s : list) {
            session.persist(s);
        }
        transaction.commit();
        session.close();
    }

    public List<Symbol> getSymbols() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Symbol> symbols = session.createQuery("FROM symbol").list();
        session.close();
        return symbols;
    }

    public boolean getSymbol(String symbol) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Symbol s = session.createQuery("FROM Symbol WHERE symbol = :symbol", Symbol.class).setParameter("symbol", symbol).uniqueResult();
        session.close();
        return s != null;
    }

    public void removeSymbol(String symbol) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Symbol WHERE symbol = :symbol").setParameter("symbol", symbol).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
