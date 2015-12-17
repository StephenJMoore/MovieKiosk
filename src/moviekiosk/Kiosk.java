

package moviekiosk;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

//@author Stephen
class Kiosk {
    private ArrayList<Account> acctList = new ArrayList<>();
    private Catalog catalog = new Catalog();
    private int transactionCounter = 0;
    
    void load() throws IOException 
    {
      FileWR f = new FileWR();
      f.loadCatalog(this.catalog);
      f.loadAccount(this.acctList);
      transactionCounter = f.loadTransactions(this.catalog.getHistory());
      this.linkTransactions();
      this.linkReservations();  
    }
    void save() throws IOException
    {
        FileWR f = new FileWR();
        f.saveAccount(this.acctList);
        f.saveCatalog(this.catalog);
        f.saveTransactions(this.catalog.getHistory());
    }
    Account login(String search)
    {
          Account a;
          a = find(search);
          return a;
    }
    void menu(Account user)
    {
        
        System.out.println(welcome(user));
        
        int sentinel;
        Scanner in = new Scanner(System.in);
        String title;
        
        do{
            ArrayList<Media> mediaCart = new ArrayList<>();
            
                System.out.println("1: Rent \n" + "2: Return \n"
                        +"3: Order\n" + "4: Reserve\n" + "5: Purchase\n" 
                        + "6: View history\n"+ "7: Check inventory\n" 
                        + "8: Quit");

                System.out.println("Enter choice:"); 
		sentinel=in.nextInt();
                in.nextLine();
                if(sentinel == 1 || sentinel == 2 || sentinel == 3
			|| sentinel == 4 || sentinel == 5|| sentinel == 7)
		{			
			
                        String cont = "";
                        Media m;
                        do{
                            System.out.println("What movie are you looking for?");
                                title = in.nextLine();
                                m = this.catalog.find(title);
                                if(m.getID()==-1)
                                       System.out.println("Movie not found.");
                                else
                                     mediaCart.add(m);
                                System.out.println("Look for another movie? (Y/N)");
                                cont = in.nextLine();
                                
                        }while(cont.equals("y") || cont.equals("Y") || cont.equals("Yes") || cont.equals("YES"));
                  
			
		}          
                boolean didSucceed = true;       
                if(sentinel == 1)
		{		
			this.rentMedia(user, mediaCart);
                        if(didSucceed)
                            System.out.println("Rental Sucessful! Press Enter to continue.");
                        in.nextLine();
		}

		else if(sentinel == 2)
		{
			
			this.returnMedia(user, mediaCart);
                        if(didSucceed)
                            System.out.println("Return Sucessful! Press Enter to continue.");
                        in.nextLine();
		}

		else if(sentinel == 3)
		{
			this.orderMedia(user, mediaCart);
                        if(didSucceed)
                            System.out.println("Order Sucessful! Press Enter to continue.");
                        in.nextLine();
		}

                else if(sentinel == 4)
		{
			this.reserveMedia(user, mediaCart);
                        if(didSucceed)
                            System.out.println("Reserve Sucessful! Press Enter to continue.");
                        in.nextLine();
		}
		
		else if(sentinel == 5)
		{ 
			this.purchaseMedia(user, mediaCart);
                        if(didSucceed)
                            System.out.println("Purchase Sucessful! Press Enter to continue.");
                        in.nextLine();
		}

		else if(sentinel == 6)
		{
                    this.viewHistory(user);
                    System.out.println("Press Enter to continue.");
                    in.nextLine();
		}

		else if(sentinel == 7)
		{
                    for(Media m: mediaCart)
                        this.checkInv(m);
                    System.out.println("Press Enter to continue.");
                    in.nextLine();
		}

		else if(sentinel == 8)
		{
                    System.out.println("Have a nice day!\n");	
		}
            
        }while(sentinel!=8);
    }
    void viewHistory(Account a)
    {
        for(Transaction t: a.getTransactions())
        {
            System.out.println(t.display());
        }
    }
    String printHistory(Account a)
    {
        StringBuilder sb = new StringBuilder();
        for(Transaction t: a.getTransactions())
            sb.append(t.display());
        String s = new String(sb);
        return s;
    }
    
   Account find(String search)
{

	Account found = new Account();
            for(Account a:this.acctList)
            {
                if(search.trim().equals(a.getEmail().trim()))
                {

                    found = a;
                }
            }
	return found;
}
    void checkInv(Media m)
    {
        System.out.println("There are " + m.getInv() + " copies  of " + m.getTitle()
                + " at this kiosk.");
        if(m.getInv()==0)
            System.out.println("You can reserve this title to get rent a copy asap.");
        
    }


    void rentMedia(Account user, ArrayList<Media> mediaCart)
    {
        Rent r = user.createRent(mediaCart, ++this.transactionCounter);
        boolean inStock = true;
        for(Media m: mediaCart)
        {
            if(m.getInv()< 1)
                inStock = false;
        }
        if(inStock)
            this.catalog.update(r);
        else
            System.out.println("Could not rent, some movies are not in stock.");
    }
    void returnMedia(Account user, ArrayList<Media> mediaCart)
    {
        Return r = user.createReturn(mediaCart, ++this.transactionCounter);
        for(Media m:mediaCart)
        {
            Reserve reservation = catalog.reserve(m);
            if(reservation==null)
            {
                
                this.catalog.update(r);
            }
            else
            {
                reservation.getAcct().addReservation(m);
            }
        }
         
        
        
    }
    void reserveMedia(Account user, ArrayList<Media> mediaCart)
    {
        Reserve r = user.createReserve(mediaCart, ++this.transactionCounter);
        this.catalog.update(r);
        
    }
    void orderMedia(Account user, ArrayList<Media> mediaCart)
    {
        Order o = user.createOrder(mediaCart, ++this.transactionCounter);
        this.catalog.update(o);
    }
    void purchaseMedia(Account user, ArrayList<Media> mediaCart)
    {
        Purchase p = user.createPurchase(mediaCart, ++this.transactionCounter);
        this.catalog.update(p);
    }     
    
    void checkoutReservations(Account user)
    {
        user.createRent(user.getReservations(), ++transactionCounter);
        user.emptyReservations();
    }
    String welcome(Account a)
    {
        return ("Welcome, " + a.getFname() + " to GreenBox Kiosks!");
    }
            
    void linkTransactions()
    {
        for(Account a: acctList)
        {
            this.catalog.linkAccount(a);
        }
    }
    Catalog getCatalog()
    {
        return catalog;
    }
    
    void linkReservations()
    {
        for(Account a:acctList)
        {
            if(!a.getTransactions().isEmpty())
                catalog.linkMedia(a);
        }
        
    }
}
