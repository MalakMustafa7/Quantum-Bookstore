 package org.example.exception;
public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn) {
        super("Book with this ISBN "+isbn+"is not found");
    }
    
}
