
package mylibrary.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    ResultSet resultat = null;
    Statement instruction ;
    static private Database database;
    
    private Database(){
    
	try{
            String url="jdbc:mysql://127.0.0.1:3306/librarydb";
            String user="root";
 	    Connection conn = DriverManager.getConnection(url, user,"Slade2023");
            instruction = conn.createStatement();
            System.out.println("Connected");
        }
        
  	catch (SQLException ex) {
            System.out.println(ex );
	}
    }
    
    public ResultSet SelectFun(String Query) throws SQLException{
    
        resultat = instruction.executeQuery(Query);	
        return resultat;
    }

    public void InsertFun(String Query) throws SQLException{
    
        instruction.executeUpdate(Query);
    }

    public static Database getDatabaseConnection(){
    
        if(database == null){
            database= new Database();
        }
    
        return database;
    }
    
}


