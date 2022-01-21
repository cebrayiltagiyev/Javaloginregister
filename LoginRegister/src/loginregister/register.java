package loginregister;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class register {
    public static void register() throws Exception{
       String generatedPassword = null;

        Scanner sc = new Scanner (System.in);
        System.out.println("Enter username:");
        String uname=sc.next() ;
        System.out.println("Enter Password: ");
        String pass=sc.next() ;
        System.out.println("Enter firstname: ");
        String fname=sc.next() ;
        System.out.println("Enter lastname: ");
        String lname=sc.next() ;
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        

        
        
        Connection con=database.connect() ;
        Statement stmt=con.createStatement() ;
        String query ="INSERT INTO user VALUES (default,?,?,?,?)" ;
        
        PreparedStatement myStmt=con.prepareStatement(query) ;
        
        myStmt.setString(1,uname) ;
        myStmt.setString(2,generatedPassword) ;
        myStmt.setString(3,fname) ;
        myStmt.setString(4,lname) ;
        int res=myStmt.executeUpdate() ;
        
        System.out.println("Successfully registered");
         
         
         
        
    }
    
    
}
