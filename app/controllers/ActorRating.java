package controllers;

import models.Addactor;
import models.Addcompareactor;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.actorRating;
import views.html.displayactor;

/**
 * Created by user on 25-06-2016.
 */
public class ActorRating extends Controller {

    public static Result displayrating(){

        final DynamicForm dynamicForm= Form.form().bindFromRequest();
        String s1=dynamicForm.get("user1");
        String s2=dynamicForm.get("user2");
        Addactor user1=Addactor.find.where().like("firstname", "%" + s1+ "%").findUnique();
        Addactor user2=Addactor.find.where().like("firstname", "%" + s2+ "%").findUnique();
        Integer aid1=user1.getId();
        Integer aid2=user2.getId();
        System.out.println(aid1+"========"+aid2);
       // Addcompareactor addcompareactor=new Addcompareactor();
        //addcompareactor.actor1id=aid1;
       // addcompareactor.actor2id=aid2;
       // System.out.println(addcompareactor.getActor1id()+"============="+addcompareactor.getActor2id());
        //finding compare table id
        Addcompareactor cmp1=Addcompareactor.find.where().eq("id",aid1).findUnique();
        //Addcompareactor cmp2=Addcompareactor.find.byId(addcompareactor.actor2id);
        //System.out.println(cmp1+"=========="+cmp2);
        Addcompareactor cmp2=Addcompareactor.find.where().eq("id",aid2).findUnique();

        return ok(actorRating.render(user1,user2,cmp1,cmp2));
    }
}
