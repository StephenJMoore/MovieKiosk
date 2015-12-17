/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.ArrayList;
//@author Stephen
  class FileWR {
  private final static String ACCOUNT_FILE = ".\\accounts.txt";
  private final static String MEDIA_FILE = ".\\catalogLib.txt";
  private final static String TRANSACTION_FILE = ".\\transactions.txt";

  void loadAccount(ArrayList<Account> aList) throws IOException 
   {
       String tString;
       int tInt;
    
       Path path = Paths.get(".\\accounts.txt");
       try (Scanner in =  new Scanner(path))
       {
           while (in.hasNextLine())
           {
               Account temp = new Account();
               temp.setFName(in.nextLine());
               temp.setLName(in.nextLine());
               temp.setEmail(in.nextLine());
               tString=in.nextLine();
               tInt = Integer.parseInt(tString);
               temp.setID(tInt);
               tInt = Integer.parseInt(in.next("\\d{3}"));
               temp.setAreaCode(tInt);
               tInt = Integer.parseInt(in.next("\\d{3}"));
               temp.setPhPrefix(tInt);
               tInt = Integer.parseInt(in.next("\\d{4}"));
               temp.setPhSuffix(tInt);
               tString = in.next("\\d{4}");
               tString = tString.replace("\\s", "");
               tInt = Integer.parseInt(tString);
               temp.setCardNum(tInt);               
               tString = in.next(".{5}");
               temp.setCardExp(tString.trim());
               in.nextLine();
               tString = in.nextLine();
               temp.setStreetAddress(tString);
               tString = in.nextLine();
               temp.setCity(tString);
               tString=in.nextLine();
               tInt = Integer.parseInt(tString);
               temp.setZip(tInt);
               tString=in.nextLine();
               tInt = Integer.parseInt(tString);
               for(int i = 0; i < tInt; ++i)
               {
                   tString = in.nextLine();
                   Media m = new Media(tString);
                   temp.addReservation(m);
               }
               aList.add(temp);
               if(in.hasNext("\\n"))
                   in.nextLine();
           }
           in.close();
       }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
   }
  
    void loadCatalog(Catalog c) throws IOException
  {
    String tString = "";
       int tInt;
       
       Path path = Paths.get(".\\catalogLib.txt");
       try (Scanner in =  new Scanner(path))
       {
           while (in.hasNextLine())
           {
               Media temp = new Media();
               
               tString = in.nextLine();
               tInt = Integer.parseInt(tString);
               temp.setID(tInt);
               tInt = Integer.parseInt(in.nextLine());
               temp.setInv(tInt);
               tString = in.nextLine();
               temp.setTitle(tString);
               tString = in.nextLine();
               temp.setGenre(tString);
               tString = in.nextLine();
               temp.setDesc(tString);
               tString = in.nextLine();
               temp.setRating(tString);
               c.addMedia(temp);                
           }
                  in.close();
       }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
   }

  int loadTransactions(ArrayList<Transaction> tList) throws IOException
  {
    String tString;
       int tInt = 0,
           tID = 0;
       Path path = Paths.get(".\\transactions.txt");
       try (Scanner in =  new Scanner(path))
       {
           while (in.hasNextLine())
           {
               tString = in.nextLine();
               switch (tString) 
               {
                    case "Rent":
                        Rent temp = new Rent();
                        tString = in.nextLine();
                        tID = Integer.parseInt(tString);
                        temp.setID(tID);
                        tString = in.nextLine();
                        Account tAcct = new Account(tString);
                        temp.setAcct(tAcct);
                        tString = in.nextLine();
                        tInt = Integer.parseInt(tString);
                        for(int i = 0; i < tInt; ++i)
                        {
                           tString = in.nextLine();
                           Media tMedia = new Media(tString);
                           temp.addMedia(tMedia);
                        }
                        tList.add(temp);
                       break;
                    case "Reserve":
                        Reserve tempRes = new Reserve();
                        tString = in.nextLine();
                        tID =  Integer.parseInt(tString);
                        tempRes.setID(tID);
                        tString = in.nextLine();
                        Account trAcct = new Account(tString);
                        tempRes.setAcct(trAcct);
                        tString = in.nextLine();
                        tInt = Integer.parseInt(tString);
                        for(int i = 0; i < tInt; ++i)
                        { 
                           tString = in.nextLine();
                           Media tMedia = new Media(tString);                      
                           tempRes.addMedia(tMedia);
                        }
                        tList.add(tempRes);
                        break;

                    case "Return":
                        Return tempRet = new Return();
                        tString = in.nextLine();
                        tID = Integer.parseInt(tString);
                        tempRet.setID(tID);
                        tString = in.nextLine();
                        Account rtAcct = new Account(tString);
                        tempRet.setAcct(rtAcct);
                        tString = in.nextLine();
                        tInt = Integer.parseInt(tString);
                        for(int i = 0; i < tInt; ++i)
                        {
                           tString = in.nextLine();
                           Media tMedia = new Media(tString);                      
                           tempRet.addMedia(tMedia);
                        }
                        tList.add(tempRet);
                        break;
               
                    case "Order":
                        Order tempO = new Order();
                        tString = in.nextLine();
                        tID = Integer.parseInt(tString);
                        tempO.setID(tID);
                        tString = in.nextLine();
                        Account toAcct = new Account(tString);
                        tempO.setAcct(toAcct);
                        tString = in.nextLine();
                        tInt = Integer.parseInt(tString);
                        for(int i = 0; i < tInt; ++i)
                        {
                           tString = in.nextLine();
                           Media tMedia = new Media(tString);
                           tempO.addMedia(tMedia);
                        }
                        tList.add(tempO);
                        break;
                    case "Purchase":
                    
                        Purchase tempPur = new Purchase();
                        tString = in.nextLine();
                        tID = Integer.parseInt(tString);
                        tempPur.setID(tID);
                        tString = in.nextLine();
                        Account tpAcct = new Account(tString);
                        tempPur.setAcct(tpAcct);
                        tString = in.nextLine();
                        tInt = Integer.parseInt(tString);
                        for(int i = 0; i < tInt; ++i)
                        {
                           tString = in.nextLine();
                           Media tMedia = new Media(tString);
                           tempPur.addMedia(tMedia);
                        }
   
                        break;
                   
                    }
      
           }
       
           
        in.close();
       }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
       return tID;
   }
  void saveAccount(ArrayList<Account> aList) throws IOException 
  {
       try (BufferedWriter out =  new BufferedWriter(new FileWriter(ACCOUNT_FILE)))
       {
           String tempString;
           Integer tempInt;
           for(Account a:aList)
           {
            tempString = a.getFname();
            out.write(tempString);
            out.newLine();
            tempString = a.getLname();
            out.write(tempString);
            out.newLine();
            tempString = a.getEmail();
            out.write(tempString);
            out.newLine();
            tempInt = a.getID();
            out.write(tempInt.toString());
            out.newLine();
            tempInt = a.getPhAreaCode();
            out.write(tempInt.toString());
            out.write(" ");
            tempInt = a.getPhPrefix();
            out.write(tempInt.toString());
            out.write(" ");
            tempInt = a.getPhSuffix();
            out.write(tempInt.toString());
            out.newLine();
            tempInt = a.getCardNum();
            out.write(tempInt.toString());
            out.write(" ");
            tempString = a.getCardExp();
            out.write(tempString);
            out.newLine();
            tempString = a.getStreetAddress();
            out.write(tempString);
            out.newLine();
            tempString = a.getCity();
            out.write(tempString);
            out.newLine();
            tempInt = a.getZip();
            out.write(tempInt.toString());
            out.newLine();
            tempInt = a.getReservations().size();
            out.write(tempInt.toString());
            out.newLine();
            for(Media m: a.getReservations())
            {
                out.write(m.getTitle());
                out.newLine();
            }
           }
       }
      
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
  void saveCatalog(Catalog c) throws IOException
  {
    String tString;
    Integer tInt;
    try (BufferedWriter out =  new BufferedWriter(new FileWriter(MEDIA_FILE)))
    {
      
        for(Media m:c.getLibrary())
        {
            tInt = m.getID();
            out.write(tInt.toString());
            out.newLine();
            tInt =  m.getInv();
            out.write(tInt.toString());
            out.newLine();
            tString = m.getTitle();
            out.write(tString);
            out.newLine();
            tString =  m.getGenre();
            out.write(tString);
            out.newLine();
            tString =  m.getDesc();
            out.write(tString);
            out.newLine();
            tString =  m.getRating();
            out.write(tString);
            out.newLine();
        }
        
       
        out.close();
    }   
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
   }
    
  void saveTransactions(ArrayList<Transaction> transactions)
  {
      try (BufferedWriter out =  new BufferedWriter(new FileWriter(TRANSACTION_FILE)))
      {
          Integer tInt;
          String tString;
          for(Transaction t: transactions)
          {
              tString=t.getClass().getSimpleName();
              out.write(tString);
              out.newLine();
              tInt=t.getID();
              out.write(tInt.toString());
              out.newLine();
              tString=t.getAcct().getEmail();
              out.write(tString);
              out.newLine();
              tInt = t.getMediaList().size();
              out.write(tInt.toString());
              out.newLine();
              for(Media m:t.getMediaList())
              {
                  tString = m.getTitle();
                  out.write(tString);
                  out.newLine();
              }
              
          }
      }
      catch(IOException ex)
      {
          ex.printStackTrace();
      }
  }
}
