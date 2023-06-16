
package mylibrary.Models;

public class Client {
    
    String clientName;
    String email;
    String phone;
    static private  Client client;
    
   public String getClientName(){
        return clientName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
   public void setClientName(String clientName){
        this.clientName=clientName;
    }
   
   public void getEmail(String email){
        this.email =email;
    }
   
    public void getPhone(String phone){
         this.phone=phone;
    }
      public static Client getUser(String name,String phone,String email){
    
        if(client == null){
            client= new Client();
        }
        
        client.clientName = name;
        
        client.phone = phone;
        client.email = email;
        
        
        return client;
    }
}
