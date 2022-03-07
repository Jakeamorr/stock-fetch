package net.jakemorris.stockfetch;

import net.jakemorris.stockfetch.dao.QuoteDao;
import net.jakemorris.stockfetch.dao.SymbolDao;
import net.jakemorris.stockfetch.exception.APIConnectionException;
import net.jakemorris.stockfetch.exception.InvalidQuoteException;
import net.jakemorris.stockfetch.model.Quote;
import net.jakemorris.stockfetch.model.Symbol;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Api api = new Api();
        printWelcomeMessage();
        startUserInteractionLoop(api);
    }

    public static void printWelcomeMessage() {
        /*
         _________   __                   __    ___________       __            __
        /    _____/_/  |_  ____    ____  |  | __\_   _____/____ _/  |_   ____  |  |__
         \_____  \ \   __\/  _ \ _/ ___\ |  |/ / |    __)_/ __ \\   __\_/ ___\ |  |  \
         _____/   \ |  | (  |_| )\  \___ |    <  |   \   \  ___/ |  |  \  \___ |   Y  \
        /_________/ |__|  \____/  \_____||__|__\ \___/    \_____>|__|   \_____||___|__/
         */
        System.out.println("         _________   __                   __    ___________       __            __");
        System.out.println("        /    _____/_/  |_  ____    ____  |  | __\\_   _____/____ _/  |_   ____  |  |__");
        System.out.println("         \\_____  \\ \\   __\\/  _ \\ _/ ___\\ |  |/ / |    __)_/ __ \\\\   __\\_/ ___\\ |  |  \\");
        System.out.println("         _____/   \\ |  | (  |_| )\\  \\___ |    <  |   \\   \\  ___/ |  |  \\  \\___ |   Y  \\");
        System.out.println("        /_________/ |__|  \\____/  \\_____||__|__\\ \\___/    \\_____>|__|   \\_____||___|__/");
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println(String.format("%17s", "1) Get a quote"));
        System.out.println(String.format("%20s", "2) View my stocks"));
        System.out.println(String.format("%18s", "3) Remove stock"));
        System.out.println(String.format("%10s", "4) Exit"));
        System.out.println();
    }

    public static void startUserInteractionLoop(Api api) {
        boolean running = true;
        Scanner scan  = new Scanner(System.in);

        while(running) {
            displayMenu();
            System.out.print(">> ");
            String option = scan.next();
            scan.nextLine();

            switch(option) {
                case "1":
                    boolean gettingQuote = true;
                    // Loop to get the symbol to quote
                    while(gettingQuote) {
                        System.out.println();
                        System.out.println("Enter a symbol, or type MENU to see other options");
                        System.out.print(">> ");
                        // If multiple symbols are entered, grab the first one and ignore the others
                        String symbol = scan.nextLine().split(" ")[0].toUpperCase(Locale.ROOT);
                        if (symbol.equals("MENU")) break;
                        try {
                            Quote q = api.getQuote(symbol);
                            System.out.println(q);
                            boolean addingQuote = true;
                            // Loop to check whether to add quote to saved quotes list
                            while(addingQuote) {
                                System.out.print("Would you like to save this quote? (y/n) ");
                                String add = scan.nextLine().split(" ")[0].toUpperCase(Locale.ROOT);
                                if (add.equals("Y")) {
                                    QuoteDao quoteDao = new QuoteDao();
                                    quoteDao.addQuote(q);
                                    addingQuote = false;
                                }
                                if(add.equals("N")) {
                                    addingQuote = false;
                                }
                            }
                        } catch (InvalidQuoteException | SQLException | APIConnectionException e) {
                            System.out.println();
                            System.out.println("Warning: " + e.getMessage());
                            log.error(e);
                        }
                    }
                    break;

                case "2":
                    QuoteDao quoteDao = new QuoteDao();
                    try {
                        List<Quote> quotes = quoteDao.getQuotes();
                        boolean selectingSymbol = true;
                        while(selectingSymbol) {
                            System.out.println();
                            System.out.println("My Symbols:  ");
                            int i = 0;
                            for (Quote q : quotes) {
                                System.out.println((i + 1) + ") " + q.getSymbol());
                                i++;
                            }
                            System.out.println();
                            System.out.println("Select a symbol to view, or type MENU to see other options");
                            System.out.print(">> ");
                            String indexStr = scan.next().toUpperCase(Locale.ROOT);
                            if(indexStr.equals("MENU")) break;
                            try {
                                int index = Integer.parseInt(indexStr);
                                if (index >= 0 && index <= i && i > 0) {
                                    Quote selectedQuote = quoteDao.getQuote(quotes.get(index - 1).getSymbol());
                                    System.out.println(selectedQuote);
                                }
                            } catch(NumberFormatException e) {
                                System.out.println("Not a valid index.");
                                log.error(e);
                            }
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                        log.error(e);
                    }
                    break;
                case "3":
                    quoteDao = new QuoteDao();
                    try {
                        boolean selectingSymbol = true;
                        while(selectingSymbol) {
                            List<Quote> quotes = quoteDao.getQuotes();
                            System.out.println();
                            System.out.println("My Symbols:  ");
                            int i = 1;
                            for (Quote q : quotes) {
                                System.out.println(i + ") " + q.getSymbol());
                                i++;
                            }
                            System.out.println();
                            System.out.println("Select a symbol to view, or type MENU to see other options");
                            System.out.print(">> ");
                            String indexStr = scan.next().toUpperCase(Locale.ROOT);
                            if(indexStr.equals("MENU")) break;
                            try {
                                int index = Integer.parseInt(indexStr);
                                if (index >=0 && index <= i) {
                                    quoteDao.removeQuote(quotes.get(index - 1).getSymbol());
                                }
                            } catch(NumberFormatException e) {
                                System.out.println("Not a valid index.");
                            }
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                        log.error(e);
                    }
                    break;

                case "4":
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

    // This will fetch the list of all symbols that are supported for intraday trading and add them to the DB
    // Expensive operation so do not call unless needed
    public void getAllSymbols(Api api) throws SQLException {
        SymbolDao symbolDao = new SymbolDao();
        List<Symbol> symbols = api.getAllSymbols();
        symbolDao.addSymbols(symbols);
    }
}
