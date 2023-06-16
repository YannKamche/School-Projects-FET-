/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary.Models;

import java.sql.Date;

/**
 *
 * @author Alaa-Ballout
 */
public class Book {
    
    int id ;
    String category;
    String authorName; 
    String title; 
    Date date ;
    int copies;
    String description;
    
    static private Book book;

    private Book(){
        
        System.out.println("book created");
    }
    
    public String getTitle(){
        
        return title;
    }
    
    public String getCategory(){
        
        return category;
    }
    
    public String getAuthor(){
        
        return authorName;
    }
    
    public Date getDate(){
        
        return date;
    }
    
    public int getCopies(){
        
        return copies;
    }
    
    public String getDescription(){
        
        return description;
    }
    
    public void setTitle(String title){
        
        this.title = title;
    }
    
    public void setCategory(String category){
        
        this.category=category;
    }
    
    public void setAuthor(String authorName){
        
        this.authorName=authorName;
    }
    
    public void setDate(Date date){
        
        this.date=date;
    }
    
    public void setCopies(int copies){
        
        this.copies=copies;
    }
    
    public  void setDescription(String description){
        
        this.description=description;
    }
    
  
    public static Book getBook(String title,String authorName,String category,Date date,int copies,String description){
    
        if(book == null){
            book= new Book();
        }
        
        book.title = title;
        book.authorName = authorName;
        book.category = category;
        book.date = date;
        book.copies = copies;
        book.description = description;
        return book;
    }
    
    
    Book(String category){
       this.category=category;
       
    }
   
     
     public String toString(){
     
        return title+"    "+authorName+"    "+category+"    "+copies+"    "+date;
     
     }

    
    
}
