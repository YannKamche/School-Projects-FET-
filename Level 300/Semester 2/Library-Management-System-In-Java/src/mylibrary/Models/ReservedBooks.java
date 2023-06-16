/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary.Models;

/**
 *
 * @author Alaa-Ballout
 */
public class ReservedBooks {
    Book book;
    int copies;
    
    Book getBook(){
    return book;
    }
    int getCopies(){
    return copies;
    }
    void setCopies(int copies){
    this.copies= copies;
    }
    void setBook(Book book){
    this.book= book;
    }
    
}
