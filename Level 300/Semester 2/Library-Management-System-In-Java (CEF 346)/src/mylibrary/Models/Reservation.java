
package mylibrary.Models;

import java.sql.Date;

public class Reservation {
    
    String clientPhone; 
    String book_title;
    Date date;
    int reservation_id;
    
    Reservation(String Phone){
    
        this.clientPhone= Phone;
    }

    public Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getReservationId(){
        
        return reservation_id;
    }
    
    public  String getClient(){
    
        return clientPhone;
    }
   
    public  String getBook(){
    
        return book_title;
    }
    
    public Date getDate(){
    
        return date;
    }
    
    public void setReservationId(int reservation_id){
    
        this.reservation_id=reservation_id;
    }
    
    public void setBookTitle(String book){
    
        this.book_title= book;
    }
     
    public void setDate(Date date){
    
        this.date= date;
    }
    
    @Override
    public String toString(){
    
        return  book_title+"\t\t\t\t\t\t"+clientPhone+"\t\t\t\t\t\t\t"+date.toString();
    }
    
}
