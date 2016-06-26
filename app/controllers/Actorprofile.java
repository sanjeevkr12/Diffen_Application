package controllers;

import models.Addactor;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.actorProfile;
import views.html.displayactor;

import java.util.List;

/**
 * Created by user on 23-06-2016.
 */
public class Actorprofile extends Controller{

    public static Result actorprofile()
    {
        List<Addactor> list=new Model.Finder<Integer,Addactor>(Integer.class,Addactor.class).all();
        return ok(actorProfile.render(list));
    }
}
