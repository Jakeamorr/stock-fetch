package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Exchange;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.QuoteAggregate;
import net.jakemorris.stockfetch.model.Symbol;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class QuoteDao {

    public Quote getQuote(String symbol) {
        Session session = HibernateUtil.getSession();
        String sql = "SELECT * FROM quote WHERE symbol = :symbol";
        Quote q = (Quote) session.createSQLQuery(sql).addEntity(Quote.class).setParameter("symbol", symbol).uniqueResult();
        // Quote q = session.createQuery("FROM Quote WHERE symbol = :symbol", Quote.class).setParameter("symbol", symbol).uniqueResult();
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
        String sql = "SELECT * FROM quote WHERE symbol = :symbol";
        Quote q = (Quote) session.createSQLQuery(sql).addEntity(Quote.class).setParameter("symbol", symbol).uniqueResult();
        if (q == null) throw new SQLException("This symbol does not exist in the list");

        // Check to make sure that if the quote is the last quote associated with the exchange, that the exchange is removed too
        Exchange e = q.getExchange();
        if (e.getQuotes().size() == 1) {
            session.delete(e);
        } else {
            e.getQuotes().remove(q);
        }
        session.delete(q);

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

    public void dropTables() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        session.createSQLQuery("DELETE FROM quote").executeUpdate();
        session.createSQLQuery("DELETE FROM symbol").executeUpdate();
        session.createSQLQuery("DELETE FROM exchange").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void generateSampleQuotes() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.getTransaction().setTimeout(20);

        Exchange e1 = new Exchange("NYSE", "New York Stock Exchange", "NYSE", "equities");
        Exchange e2 = new Exchange("NASDAQ", "National Association of Securities Dealers Automated Quotation System", "NASDAQ", "equities");

        Quote q1 = new Quote(101.5F, 110.3F, 120F, 95F, 100F, 0.55F, 3141, 41152353214L, 150F, 80F, 20.5, "USD", e2);
        Symbol s1 = new Symbol("AAPL", "Apple Inc");
        q1.setSymbol(s1);
        session.persist(q1);

        Quote q2 = new Quote(101.5F, 110.3F, 120F, 95F, 100F, 0.55F, 3141, 11152352142L, 150F, 80F, 20.5, "USD", e2);
        Symbol s2 = new Symbol("TSLA", "Tesla Inc");
        q2.setSymbol(s2);
        session.persist(q2);

        Quote q3 = new Quote(101.5F, 110.3F, 120F, 95F, 100F, 0.55F, 3141, 21152351423L, 150F, 80F, 20.5, "USD", e1);
        Symbol s3 = new Symbol("IBM", "International Business Machines");
        q3.setSymbol(s3);
        session.persist(q3);

        Quote q4 = new Quote(101.5F, 110.3F, 120F, 95F, 100F, 0.55F, 3141, 31152352143L, 150F, 80F, 20.5, "USD", e1);
        Symbol s4 = new Symbol("WMT", "Walmart Inc");
        q4.setSymbol(s4);
        session.persist(q4);

        session.close();
    }

    public List<QuoteAggregate> getQuotesByMarketCap() {
        Session session = HibernateUtil.getSession();
        String sql = "select e.name, max(marketCap) from quote q join exchange e on q.exchange_id = e.exchange_id  group by e.name;";
        session.beginTransaction();
        List<QuoteAggregate> aggregates = session.createSQLQuery(sql).list();
        session.close();
        return aggregates;
    }
}
