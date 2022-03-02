package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.util.ConnectionUtil;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;

public class QuoteDao {
    private final Connection conn;

    public QuoteDao() {
        this.conn = ConnectionUtil.getConnection();
    }

    public Quote getQuote(String symbol) throws SQLException {
        Session session = HibernateUtil.getSession();
        Quote q = session.createQuery("FROM Quote WHERE symbol = :symbol", Quote.class).setParameter("symbol", symbol).uniqueResult();
        session.close();
        return q;
    }

    public List<Quote> getQuotes() throws SQLException {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Quote> quotes = session.createQuery("FROM Quote").list();
        session.close();
        return quotes;
    }

    public void removeQuote(String symbol) throws SQLException {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Quote WHERE symbol = :symbol").setParameter("symbol", symbol).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    public void addQuote(Quote q) throws SQLException {
        // TODO: move to service layer
        Quote existingQuote = getQuote(q.getSymbol());
        if (existingQuote != null) {
            removeQuote(q.getSymbol());
        }

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(q);
        transaction.commit();
        session.close();
    }
}
