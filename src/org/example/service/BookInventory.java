package org.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.example.exception.BookNotFoundException;
import org.example.model.Book;

public class BookInventory {
    Map<String,Book>books;

    public BookInventory() {
        this.books = new HashMap<>();
    }
    
    
    public void addBook(Book book){
        books.put(book.getISBN(), book);
        System.out.println("Book"+book.getTitle()+"added successfully");
    }
    public List<Book> removeOutDatedBooks(int currentyear,int maxAge){
      List<Book>outdatedbooks = new ArrayList();
      Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
      while(it.hasNext()){  
          Book book = it.next().getValue();
          if(book.isOutdated(currentyear, maxAge)){
              outdatedbooks.add(book);
              it.remove();
          }
      }      
        return outdatedbooks;
    }
    public Book getBookByISBN(String isbn){
      Book book= books.get(isbn);
      if(book == null){
          throw new BookNotFoundException(isbn);
      }
      return book;
    }
    public void removeBook(String isbn){
        Book book = getBookByISBN(isbn);
        books.remove(isbn);
        System.out.println("Book removed successfully");
    }
    
}
