package loginregister;

import java.util.Scanner;


public class dashboard {
        
    public static void dashboard() throws Exception{
    
        int number ;

        System.out.println("Please choose option: ");
        System.out.println("Press 1 to login!");
        System.out.println("Press 2 for register:");
        Scanner input = new Scanner (System.in);
        number=input.nextInt() ;
        
        if(number==1){
            login.login() ;
        }else if(number==2){
            register.register() ;
        }
}
}