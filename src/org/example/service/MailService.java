package org.example.service;

import org.example.model.EBook;

public class MailService {
    public void shipEBook(EBook ebook,String email){
        System.out.println("Shipping EBook "+ebook.getTitle()+"with fileType "+ebook.getFiletype()+"to "+email);
    }
}
