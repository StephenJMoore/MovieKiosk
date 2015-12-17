
package moviekiosk;
import java.util.ArrayList;
import java.util.Objects;
//@author Stephen
class Account {

    private int id,
                zipCode,
                phAreaCode, // part of phone # first set of digits
                phPrefix, //  part of phone # second set
                phSuffix, // final segment
                creditCardNum;
    private ArrayList<Transaction>  transactions = new ArrayList<>();
    private ArrayList<Media> reservations = new ArrayList<>();
    private String fName,
                   lName,
                   streetAddress, //number and name
                   city,
                   creditCardExp,
                   email;
    Account()
    {
        this.id = -1;
        this.zipCode=0;
        this.phAreaCode=0;
        this.phPrefix=0;
        this.phSuffix = 0;
        this.creditCardNum=0;
        this.fName = "";
        this.lName = "";
        this.streetAddress = "";
        this.city = "";
        this.creditCardExp = "";
        this.email = "";
    }
    Account(String email)
    {
        this.id = -1;
        this.zipCode=0;
        this.phAreaCode=0;
        this.phPrefix=0;
        this.phSuffix = 0;
        this.creditCardNum=0;
        this.fName = "";
        this.lName = "";
        this.streetAddress = "";
        this.city = "";
        this.creditCardExp = "";
        this.email = email;
    }
    int getID()
    {
        return this.id;
    }
    
    int getZip()
    {
        return this.zipCode;
    }
    int getPhAreaCode()
    {
        return this.phAreaCode;
    }
    int getPhPrefix()
    {
        return this.phPrefix;
    }
    int getPhSuffix()
    {
        return this.phSuffix;
    }
    int getCardNum()
    {
        return this.creditCardNum;
    }
    String getFname()
    {
        return this.fName;
    }
    String getLname()
    {
        return this.lName;
    }
    String getStreetAddress()
    {
        return this.streetAddress;
    }
    String getCity()
    {
        return this.city;
    }
    String getCardExp()
    {
        return this.creditCardExp;
    }
    String getEmail()
    {
        return this.email;
    }
    void getHistory()
    {
        for(Transaction t:this.transactions)
            t.display();

    }
    void setID(int i)
    {
       this.id = i;
    }
    void setEmail(String e)
{
	this.email = e;
}
void setZip(int z)
{
	this.zipCode=z;
}
void setAreaCode(int a)
{
	this.phAreaCode=a;
}
void setPhPrefix(int p)
{
	this.phPrefix=p;
}
void setPhSuffix(int s)
{
	this.phSuffix=s;
}
void setCardNum(int c)
{
	this.creditCardNum=c;
}
void setFName(String f)
{
	this.fName=f;
}
void setLName(String l)
{
	this.lName=l;
}
void setStreetAddress(String s)
{
	this.streetAddress=s;
}
void setCity(String c)
{
	this.city=c;
}
void setCardExp(String e)
{
	this.creditCardExp=e;
}

    void addTransaction(Transaction t)
    {
        this.transactions.add(t); 
        
    }
    ArrayList<Transaction> getTransactions()
    {
        return this.transactions;
    }
    void addReservation(Media m)
    {
        this.reservations.add(m);
    }
    ArrayList<Media> getReservations()
    {
        return this.reservations;
    }
    void emptyReservations()
    {
        this.reservations.clear();
    }
    Rent createRent(ArrayList<Media> m, int c)
    {
        Rent nRent = new Rent(m, this, c);
        this.addTransaction(nRent);
        return nRent;
    }

    Return createReturn(ArrayList<Media> m, int c)
    {
        Return nReturn = new Return(m, this, c);
        this.addTransaction(nReturn);
        return nReturn;
    }
    Reserve createReserve(ArrayList<Media> m, int c)
    {
        Reserve nReserve = new Reserve(m, this, c);
        this.addTransaction(nReserve);
        return nReserve;
    }
    Order createOrder(ArrayList<Media> m, int c)
    {
        Order nOrder = new Order(m, this, c);
        this.addTransaction(nOrder);
        return nOrder;
    }
    Purchase createPurchase(ArrayList<Media> m, int c)
    {
        Purchase nPurchase = new Purchase(m, this, c);
        this.addTransaction(nPurchase);
        return nPurchase;
    }    

    @Override
    public String toString() 
    {
        return this.getEmail();
    }

    @Override
    public boolean equals(Object obj) 
    {
        boolean isEqual = false; 
        if(obj.getClass().getSimpleName().equals("Account"))
        {
            if(this.toString().equals(obj.toString()))
               isEqual = true;
        }
        return isEqual;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.email);
        return hash;
    }
    public boolean equals(Account rhs) 
    {
        boolean isEqual = false;
        if(this.getEmail().equals(rhs.getEmail()))
            isEqual = true;
           
        return isEqual;
    }        
}
