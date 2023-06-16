
package mylibrary.Models;

public class User {
    
    static private String  name;
    static private String username;
    static private String password; 
    static private String phone;
    static private String email; 
    static private boolean isSuper;
    
    static private User user;
    
    private User(){
    
        System.out.println("user created");
    }
    
    public String getName(){
        
        return user.name;
    }
    
    public String getUserName(){
        
        return user.username;
    }
    
    public String getPassword(){
        
        return user.password;
    }
    
    public String getPhone(){
        
        return user.phone;
    }
    
    public String getEmail(){
        
        return user.email;
    }
    
    public boolean getIsSuper(){
        
        return user.isSuper;
    }
    
    public static User getUser(String name,String username,String password,String phone,String email,boolean isSuper){
    
        if(user == null){
            user= new User();
        }
        
        user.name = name;
        user.username = username;
        user.password = password;
        user.phone = phone;
        user.email = email;
        user.isSuper = isSuper;
        
        return user;
    }
}
