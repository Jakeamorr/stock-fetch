package net.jakemorris.stockfetch.util;

import net.jakemorris.stockfetch.model.Exchange;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.Symbol;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
    private static SessionFactory sf;

    public static Session getSession() {
        if (sf == null) {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(standardRegistry);
            sources.addAnnotatedClass(Quote.class);
            sources.addAnnotatedClass(Symbol.class);
            sources.addAnnotatedClass(Exchange.class);
            Metadata metadata = sources.buildMetadata();

            sf = metadata.buildSessionFactory();
        }

        return sf.openSession();
    }
}
