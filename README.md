# MovieKiosk
An application that emulates a movie kiosk, maintaining stock, history, account lists, ect.

File descriptions

1: MovieKiosk.java: The driver class

2: Kiosk.java:  The control class which contains a Catalog, a list of accounts, and handles the input and output.

3: FileWR.java Handles the loading and saving of application data to the relevent txt files.

4: Catalog.java: holds a collection of Media objects and the complete Transaction history.  

5: Media.java:  logical class for media items in the kiosk and contains fields for the title,
    id, inventory, genre, description, and rating.
    
6: Account.java: the user account class contains contact and billing information.
    It is primarily identified by its email address.
    
7: Transaction.java: An abstract class containing an id, the account that created it and a list
     of the media in the transaction
    
8: Purchase.java: user takes permanent possession of media external to the kiosk.

9: Rent.java: user rents media from the kiosk

10: Reserve.java: reserving media that is not present.

11: Return.java: returning rented items.

12: Order.java: orders media that is not present at the kiosk.

13: KioskGui.java: creates the gui interface.  Contains menu jPanels for login, transactions,
    history, inventory, and the main menu.

13: accounts.txt: data file for user accounts

14: catalogLib.txt: data file for the Media objects 

15: transactions.txt: data file for recording transactions and their types 
