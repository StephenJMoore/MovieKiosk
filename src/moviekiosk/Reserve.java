/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;

//@author Stephen

import java.util.ArrayList;

public class Reserve extends Transaction {
    Reserve()
    {
        super();
    }
    
    Reserve(ArrayList<Media> list, Account a, int counter)
    {
        super(list, a, counter);
    } 
    
    Reserve(Transaction t)
    {
        super(t);
    }
    void notifyInStock(Media m)
    {
        Mailer mail = new Mailer();
        String body = "The movie " + m.getTitle() + " is in stock.";
        
        mail.mail(acct.getEmail(), "Reservation update", body);
        
    }
    
    @Override
   StringBuilder display()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Reserved Movies: \n");
       sb.append(super.display());
       return sb;
   }

}
