package net.jakemorris.stockfetch.dao;

import net.jakemorris.stockfetch.model.Exchange;
import net.jakemorris.stockfetch.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExchangeDao {

    public List<Exchange> getExchanges() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Exchange> exchanges = session.createQuery("FROM Exchange").list();
        session.close();
        return exchanges;
    }
}
