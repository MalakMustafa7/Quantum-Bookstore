package org.example.model;

import java.math.BigDecimal;
import org.example.exception.NotForPurchaseException;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String title, String ISBN, String authorName, int year, BigDecimal price) {
        super(title, ISBN, authorName, year, price);
    }

    @Override
    public boolean isAvailableForSale() {
         return false;
    }

    @Override
    public BigDecimal processPurchase(int quantity, String email, String address) {
         throw new NotForPurchaseException("Showcase/Demo book is not for sale");
    }
    
}
