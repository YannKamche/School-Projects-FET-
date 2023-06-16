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
public class Borrow {
 
    String clientPhone;
    int book;
    String borrow_date;
    String return_date;
    static private Borrow borrow;
    
    private Borrow(String clientPhone,int book,String borrow_date,String return_date){
        this.clientPhone=clientPhone;
        this.book=book;
        this.borrow_date=borrow_date;
        this.return_date=return_date;
    }
   public String getClient(){
    return  clientPhone; 
            
    }
    
  public  int getbook(){
    return  book; 
            
    }
    public String getBorrowDate(){
    return  borrow_date; 
            
    }
  public  String getReturnDate(){
    return return_date; 
            
    }
  
    public void setClient(String clientPhone){
      this.clientPhone=clientPhone; 
            
    }
    
   public void setbook(int book){
    this.book=book; 
            
    }
     public void setBorrowDate(String borrow_date){
      this.borrow_date=borrow_date; 
            
    }
    public void setReturnDate(String return_date){
    this.return_date=return_date; 
            
    }
    
   static public Borrow getBrrow(String clientPhone,int book,String borrow_date,String return_date){
         if(borrow == null){
            borrow= new Borrow( clientPhone, book, borrow_date, return_date);
            System.out.println("done");
        }
         borrow.setBorrowDate(borrow_date);
         borrow.setClient(clientPhone);
         borrow.setbook(book);
         borrow.setReturnDate(return_date);
        return borrow;
   }
    
    
}
