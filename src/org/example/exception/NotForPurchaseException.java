package org.example.exception;
public class NotForPurchaseException extends RuntimeException {

    public NotForPurchaseException(String message) {
        super(message);
    }
    
}
