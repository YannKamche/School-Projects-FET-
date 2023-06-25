
package mylibrary.Models;

import java.util.HashMap;


public class ReservationFactory {
    
    private static final HashMap reservations= new HashMap();
    
    public static Reservation getReservation( String clientPhone){
        
        Reservation reservation = (Reservation) reservations.get(clientPhone);
        
        if(reservation == null){
        
            reservation = new Reservation(clientPhone);
            reservations.put(clientPhone,reservation);
        }
        
        return reservation;
    }
    
}
