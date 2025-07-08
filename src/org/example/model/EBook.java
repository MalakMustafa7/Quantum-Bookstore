package org.example.model;

import java.math.BigDecimal;
import org.example.service.MailService;

public class EBook extends Book {
    private String filetype;
    MailService mailservice;
    public EBook(String filetype, String title, String ISBN, String authorName, int year, BigDecimal price, MailService mailservice) {
        super(title, ISBN, authorName, year, price);
        this.filetype = filetype;
        this.mailservice=mailservice;
    }

    public String getFiletype() {
        return filetype;
    }
    
    @Override
    public boolean isAvailableForSale() {
        return true;
    }

    @Override
    public BigDecimal processPurchase(int quantity, String email, String address) {
        BigDecimal totalPrice = this.getPrice().multiply(BigDecimal.valueOf(quantity));
        mailservice.shipEBook(this, email);
        return totalPrice;
    }
    
}
