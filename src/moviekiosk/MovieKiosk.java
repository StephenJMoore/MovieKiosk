
package moviekiosk;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Stephen Moore
 */
public class MovieKiosk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
     Kiosk k = new Kiosk();
     String s;
     k.load();
     Scanner sc= new Scanner(System.in);

     Account user = new Account();
        
     
     do{
     System.out.println("Login:");
     s= sc.nextLine();    
     
     user = k.login(s);
     
     }while(user.getID()==-1);
     
    k.menu(user);
    k.save();
    }
}
