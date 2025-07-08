package org.example.service;

import org.example.model.PaperBook;

public class ShippingService {
    public void shipBook(PaperBook book,String address){
        System.out.println("Shipping PaperBook: "+book.getTitle()+"To "+address);
    }

     
}
