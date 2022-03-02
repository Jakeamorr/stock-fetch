package net.jakemorris.stockfetch.util;

import net.jakemorris.stockfetch.model.Quote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sf;

    public static Session getSession() {
        if (sf == null) {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(standardRegistry);
            sources.addAnnotatedClass(Quote.class);
            Metadata metadata = sources.buildMetadata();

            sf = metadata.buildSessionFactory();
        }

        return sf.openSession();
    }
}
