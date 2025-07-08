package org.example.model;

import java.math.BigDecimal;
import org.example.exception.OutOfStockException;
import org.example.service.ShippingService;

public class PaperBook extends Book {
    private int stock;
    ShippingService shippingservice;
    public PaperBook(int stock, String title, String ISBN, String authorName, int year, BigDecimal price,ShippingService shippingservice) {
        super(title, ISBN, authorName, year, price);
        if (stock < 0) throw new IllegalArgumentException("Quantity cannot be negative"); 
        this.stock = stock;
        this.shippingservice = shippingservice;
    }
    @Override
    public boolean isAvailableForSale() {
         return this.stock>0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void reduceStock(int quantity){
        this.stock -= quantity;
    }
    @Override
    public  BigDecimal processPurchase(int quantity, String email, String address) {
        if(!isAvailableForSale() ||quantity>this.stock ){
            throw new OutOfStockException("This Book Is OutOfStock Now");
        }
        reduceStock(quantity);
        BigDecimal totalPrice = this.getPrice().multiply(BigDecimal.valueOf(quantity));
        shippingservice.shipBook(this,address);
        return totalPrice;
    }
    
}
