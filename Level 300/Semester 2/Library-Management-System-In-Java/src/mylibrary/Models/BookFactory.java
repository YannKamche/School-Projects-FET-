/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary.Models;

import java.util.HashMap;

/**
 *
 * @author Alaa-Ballout
 */
public class BookFactory {
    private static final HashMap books= new HashMap();
    
    public static Book getBook( String category){
        Book book = (Book) books.get(category);
        if(book == null){
        book = new Book(category);
        books.put(category,book);
        
        
        }
        
        return book;
    }
}
