/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;
import java.util.ArrayList;
//@author Stephen

public class Catalog {
     private ArrayList<Media> mediaLibrary = new ArrayList<>();
     private ArrayList<Transaction> transactionHistory = new ArrayList<>();
    
     void linkAccount(Account a)
     {
         for(Transaction t: transactionHistory)
         {
             if(a.equals(t.getAcct()))
             {
                 t.setAcct(a);
                 a.addTransaction(t);
             }

         }
     }

     void update(Transaction t)
    { 
        this.addTransaction(t);
         switch (t.getClass().getSimpleName()) 
         {
             case "Return":
                 for(Media m:t.mediaList)
                 {
                     int i= m.getInv();
                     m.setInv(++i);
                 }   
                 break;
             case "Rent":
                 for(Media m:t.mediaList)
                 {
                     if(m.getInv()>0)
                     {
                         int i= m.getInv();
                         m.setInv(--i);
                     }
             }   break;
             case "Reserve":
                 for(Media m:t.mediaList)
                 {
                     if(m.getInv()>0)
                     {
                         System.out.println(m.getTitle() +" is in stock. Cannot reserve."
                                 + " Why not rent?");
                         
                 }
             }   break;
         }
    }
    
    
    Media find(String search)
    {
        Media f = new Media();
        
        
	for(Media m:mediaLibrary)
	{
		if((m.getTitle().trim().equals(search.trim())))
		{
                    f = m;
		}
        }
        return f;
    }
    Reserve reserve(Media m)  //checks for unfufilled reservations and satisfies if found.
    {
        Reserve reservation = null;

        for(Transaction t:transactionHistory)
        {
            if(t.getClass().getSimpleName().equals("Reserve"))
            {
                for(Media cart:t.getMediaList())
                {
                    if(cart.getTitle().equals(m.getTitle()))
                    {
                        reservation = (Reserve) t;
                        reservation.addMedia(cart);
                        reservation.setAcct(t.getAcct());
                        reservation.notifyInStock(cart);
                        t.mediaList.remove(cart);  // removes and notifies only what is in stock.
                        if(t.mediaList.isEmpty())
                            transactionHistory.remove(t);
                        return reservation;
                    }
                }
            }
        }
        return reservation;
    }
    
    void linkMedia(Account a)
    {
        for(Media m: a.getReservations())
        {
            m = this.find(m.getTitle());
        }
    }
            
    void addMedia(Media m)
    {
        this.mediaLibrary.add(m);
    }
    
    void addTransaction(Transaction t)
    {
        this.transactionHistory.add(t);
    }
    ArrayList<Media> getLibrary()
    {
        return this.mediaLibrary;
    }
    ArrayList<Transaction> getHistory()
    {
        return this.transactionHistory;
    }
    
}
