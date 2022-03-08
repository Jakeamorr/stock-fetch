package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class QuoteDao {

    public Quote getQuote(String symbol) {
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
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(q);
        transaction.commit();
        session.close();
    }
}
