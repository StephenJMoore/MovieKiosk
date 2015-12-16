/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;
import java.util.ArrayList;
//@author Stephen
abstract class Transaction {
    int id;
    Account acct;
    ArrayList<Media> mediaList = new ArrayList<>();

    Transaction()
    {
        this.id = -1;
        this.acct = new Account();
    }
    Transaction(ArrayList<Media> list, Account a, int counter)
    {
        this.acct = a;
        for(Media m: list)
            this.mediaList.add(m);
        this.id = counter;
    }
    Transaction(Transaction t)
    {
        this.acct = t.acct;
        this.id = t.id;
        for(Media m: t.mediaList)
            this.mediaList.add(m);
    }
    
        int getID()
    {
            return this.id;
    }
    void setID(int i)
    {
        this.id = i;
    }
    Account getAcct()
    {
            return this.acct;
    }
    void setAcct(Account a)
    {
        this.acct = a;
    }
    void addMedia(Media m)
    {
        this.mediaList.add(m);
    }
    StringBuilder display()
    {
        StringBuilder disp = new StringBuilder();
       for(Media m: this.mediaList)
       {
           disp.append(m.getTitle() + "\n");
       }
      disp.append('\n');
      
      return disp;
    } 

    ArrayList<Media> getMediaList()
    {
        return this.mediaList;
    }
    
}
