/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;

//@author Stephen
class Media {
    private int id,
                inv;
                
    private String title,
                   genre,
                   desc,
                   rating;
    
    Media()
    {
            this.id =-1;
            this.inv = -1;
            this.title = "";
            this.genre = " ";
            this.desc = " ";
            this.rating = " ";
    }

    Media(String title)
            {
            this.id =-1;
            this.inv = -1;
            this.title = title;
            this.genre = " ";
            this.desc = " ";
            this.rating = " ";
    }
    int getID()
    {
            return id;
    }

    void setID(int i)
    {
        id=i;
    }

    int getInv()
    {
        return inv;
    }

    void setInv(int i)
    {
        inv=i;
    }

    String getTitle()
    {
        return title;
    }

    void setTitle (String t)
    {
        title=t;
    }

    String getGenre()
    {
        return genre;
    }

    void setGenre(String g)
    {
        genre = g;
    }

    String getDesc()
    {
        return desc;
    }

    void setDesc(String d)
    {
        desc=d;
    }
    String getRating()
    {
        return rating;
    }

    void setRating(String r)
    {
            rating=r;
    }
            
}
