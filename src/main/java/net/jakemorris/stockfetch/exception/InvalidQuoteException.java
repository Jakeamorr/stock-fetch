package net.jakemorris.stockfetch.exception;

public class InvalidQuoteException extends Exception {
    public InvalidQuoteException(String msg) {
        super(msg);
    }
}
