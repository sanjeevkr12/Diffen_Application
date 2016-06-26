package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.*;

/**
 * Created by user on 21-06-2016.
 */
@Entity
@Table(name = "addactor")
public class Addactor extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer actorid;
    public String firstname;
    public String lastname;
    public String photo;
    public String url;
    public Addactor(){}
    public Addactor(Integer actorid, String firstname,String lastname,String photo,String url)
    {
        this.actorid = actorid;
        this.firstname=firstname;
        this.lastname=lastname;
        this.photo=photo;
        this.url=url;
    }

    public static Finder<Integer,Addactor> find=new Finder<Integer, Addactor>(Integer.class,Addactor.class);
    public Integer getId() {
        return actorid;
    }

    public void setId(Integer id) {
        this.actorid = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
