package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null ;
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root" ,"root") ;
        return con ;
    }
}
