package net.jakemorris.stockfetch;

public class InvalidQuoteException extends Exception {
    InvalidQuoteException(String msg) {
        super(msg);
    }
}
