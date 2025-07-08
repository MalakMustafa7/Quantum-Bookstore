package org.example;

import java.math.BigDecimal;
import java.util.List;
import org.example.exception.BookNotFoundException;
import org.example.exception.NotForPurchaseException;
import org.example.exception.OutOfStockException;
import org.example.model.Book;
import org.example.model.EBook;
import org.example.model.PaperBook;
import org.example.model.ShowcaseBook;
import org.example.service.BookInventory;
import org.example.service.BookInventoryService;
import org.example.service.MailService;
import org.example.service.ShippingService;

public class QuantumBookstoreFullTest {

    public static void main(String[] args) {
        ShippingService shippingService = new ShippingService();
        MailService mailService = new MailService();
        
        BookInventory inventory = new BookInventory();
        BookInventoryService bookinventoryservice = new BookInventoryService(inventory);
        
        PaperBook paperBook = new PaperBook(5, "Java Basics", "ISBN001", "John Doe", 2012, new BigDecimal("150.00"), shippingService);
        PaperBook paperBook01 = new PaperBook(5, "C# Basics", "ISBN004", "John Doe", 2022, new BigDecimal("200.00"), shippingService);
        EBook eBook = new EBook("PDF", "Clean Code", "ISBN002", "Robert Martin", 2020, new BigDecimal("100.00"), mailService);
        ShowcaseBook demoBook = new ShowcaseBook("Sample Book", "ISBN003", "Alice Writer", 2015, new BigDecimal("1.00"));

        inventory.addBook(paperBook);
        inventory.addBook(paperBook01);
        inventory.addBook(eBook);
        inventory.addBook(demoBook);
        
         System.out.println("\n## Removing Outdated Books ##");
        List<Book> outdatedBooks = inventory.removeOutDatedBooks(2025, 10);
        for (Book b : outdatedBooks) {
            System.out.println("Removed outdated: " + b.getTitle());
        }
        System.out.println("\n## Buying Paper Book  ##");
        try {
            BigDecimal total = bookinventoryservice.buyBook("ISBN001", 2, "user@example.com", "Cairo, Egypt");
            System.out.println("Total paid for paper book: " + total);
        } catch (OutOfStockException | BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
         System.out.println("\n## Buying Paper Book ##");
        try {
            BigDecimal totalPrice = bookinventoryservice.buyBook("ISBN004", 2, "user@example.com", "Cairo, Egypt");
            System.out.println("Total paid for paper book: " + totalPrice);
        } catch (OutOfStockException | BookNotFoundException e) {
            System.out.println("Error with ISBN003: " + e.getMessage());
        }
        System.out.println("\n ## Buying EBook ##");
        BigDecimal ebookTotal = bookinventoryservice.buyBook("ISBN002", 1, "user@example.com", "N/A");
        System.out.println("Total paid for eBook: " + ebookTotal);

        System.out.println("\n ## Trying to Buy Showcase Book ##");
        try {
            bookinventoryservice.buyBook("ISBN003", 1, "user@example.com", "N/A");
        } catch (NotForPurchaseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n ## Trying to Buy Non-Existing Book ##");
        try {
            bookinventoryservice.buyBook("ISBN999", 1, "user@example.com", "N/A");
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
