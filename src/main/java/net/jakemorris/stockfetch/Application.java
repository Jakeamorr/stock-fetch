package net.jakemorris.stockfetch;

import net.jakemorris.stockfetch.service.QuoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static QuoteService quoteService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static void getBeanNames(ApplicationContext apc) {
        String[] names = apc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
