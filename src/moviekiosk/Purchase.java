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
   StringBuilder display()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Purchased Movies:  \n");
       sb.append(super.display());
       return sb;
   }

}
