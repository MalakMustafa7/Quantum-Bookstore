package org.example.service;

import java.math.BigDecimal;
import org.example.exception.NotForPurchaseException;
import org.example.model.Book;

public class BookInventoryService {
    private BookInventory bookinventory;

    public BookInventoryService(BookInventory bookinventory) {
        this.bookinventory = bookinventory;
    }
    public BigDecimal buyBook(String isbn,int quantity,String email,String Address){
      Book book= bookinventory.getBookByISBN(isbn);
      if(!book.isAvailableForSale()){
          throw new NotForPurchaseException("Book "+book.getTitle()+"is not available for purchase.");
      }
      return book.processPurchase(quantity, email, Address);
    }
}
