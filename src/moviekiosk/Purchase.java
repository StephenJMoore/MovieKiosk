/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;

//@author Stephen

import java.util.ArrayList;

public class Purchase extends Transaction {

    Purchase()
    {
        super();
    }
    Purchase(ArrayList<Media> list, Account a, int counter)
    {
        super(list, a, counter);
    } 
    @Override
   void display()
   {
       System.out.println("Purchased Movies:");
       super.display();
   }

}