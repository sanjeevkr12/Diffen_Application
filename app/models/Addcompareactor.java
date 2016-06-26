package models;

import play.db.ebean.Model;
import javax.persistence.*;

/**
 * Created by user on 21-06-2016.
 */
@Entity
@Table(name = "comparision")
public class Addcompareactor extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int actor1id;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int actor2id;
    public int actor1rating;
    public int actor2rating;
    public static Finder<Integer,Addcompareactor> find=new Finder<Integer, Addcompareactor>(Integer.class,Addcompareactor.class);
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getActor1id() {
        return actor1id;
    }

    public void setActor1id(int actor1id) {
        this.actor1id = actor1id;
    }

    public int getActor2id() {
        return actor2id;
    }

    public void setActor2id(int actor2id) {
        this.actor2id = actor2id;
    }

    public int getActor1rating() {
        return actor1rating;
    }

    public void setActor1rating(int actor1rating) {
        this.actor1rating = actor1rating;
    }

    public int getActor2rating() {
        return actor2rating;
    }

    public void setActor2rating(int actor2rating) {
        this.actor2rating = actor2rating;
    }
}
