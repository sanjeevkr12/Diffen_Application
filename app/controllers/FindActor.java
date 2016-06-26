package controllers;

import models.Addactor;
import models.Addactor;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search;
import static play.libs.Json.toJson;
import java.util.List;

/**
 * Created by user on 22-06-2016.
 */
public class FindActor extends Controller {


    public static Result dosearch(String term)
    {
        List<Addactor> users=Addactor.find.where().like("firstname", "%"+ term+"%").findList();
        return ok(toJson(users));
    }
}
