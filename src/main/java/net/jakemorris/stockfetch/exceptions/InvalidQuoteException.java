package net.jakemorris.stockfetch.exceptions;

public class InvalidQuoteException extends Exception {
    public InvalidQuoteException(String msg) {
        super(msg);
    }
}
