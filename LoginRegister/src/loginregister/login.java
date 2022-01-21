package loginregister;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class login {
    public static void login() throws Exception{
         String DBusername = "";
         String DBpassword = "";
         String generatedPassword = null;
        
         Scanner sc = new Scanner (System.in);
         System.out.println("Enter username: ");
         String name=sc.next() ;
         System.out.print("Enter Password: ");
         String password = sc.next();
         
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
         
         Connection con=database.connect() ;
         Statement stmt = con.createStatement();
         String query="SELECT * FROM user WHERE username=? and password=?";
         PreparedStatement myStmt=con.prepareStatement(query) ;
         myStmt.setString(1,name) ;
         myStmt.setString(2,generatedPassword) ;
         ResultSet rs = myStmt.executeQuery();
          while (rs.next()) {
        DBusername = rs.getString("username");
        DBpassword = rs.getString("password");
    }
          if(name.equals(DBusername) && generatedPassword.equals(DBpassword)){
              System.out.println("Successfully logged!!!");
          }else{
              System.out.println("Invalid username or password!!!");
          }
         
    }
}
