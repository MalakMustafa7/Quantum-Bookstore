 package org.example.model;

import java.math.BigDecimal;

public abstract class Book {
    private String title;
    private String ISBN;
    private String authorName;
    private int year;
    private BigDecimal price;
    public Book(String title, String ISBN,String authorName, int year, BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO)<=0) throw new IllegalArgumentException("Price must be positive");
        if(title.isEmpty()) throw new IllegalArgumentException("Book must have title");
        this.title = title;
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }
    public String getAuthorName() {
        return authorName;
    }

     
    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public boolean isOutdated(int currentyear,int maxAge){
        return (currentyear-this.year)>maxAge;
    }
    public abstract boolean isAvailableForSale();
    public abstract BigDecimal processPurchase(int quantity,String email,String address);
     
    
    
}
