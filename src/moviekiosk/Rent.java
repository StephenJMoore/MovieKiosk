/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;

//@author Stephen

import java.util.ArrayList;

class Rent extends Transaction {
    Rent()
    {
        super();
    }
    Rent(ArrayList<Media> list, Account a, int counter)
    {
        super(list, a, counter);
    } 
    @Override
   void display()
   {
       System.out.println("Movies Rented:");
       super.display();
   }
}
