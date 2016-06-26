package controllers;


import com.avaje.ebean.Ebean;
import models.*;
import play.api.mvc.MultipartFormData;
import play.data.DynamicForm;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import static play.libs.Json.toJson;
import views.html.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import play.mvc.BodyParser;

public class Application extends Controller {

    public static Result index()
    {
        return ok(index1.render());
    }
    public static Result addactor()
    {
        return ok(addactor.render());
    }
    public static Result doAddactor()
    {

        final DynamicForm form= Form.form().bindFromRequest();
        String fname=form.get("firstname");
        String lname=form.get("lastname");
        //String photo=form.get("photo");
        String weburl=form.get("url");
        String fileName="";
       /* Http.MultipartFormData body = request().body().asMultipartFormData();
        if(body == null)
        {
            return badRequest("Invalid request, required is POST with enctype=multipart/form-data.");
        }

        Http.MultipartFormData.FilePart filePart = body.getFile("upload");
        if(filePart == null)
        {
            return badRequest("Invalid request, no file has been sent.");
        }

        // getContentType can return null, so we check the other way around to prevent null exception
        if(!"application/images".equalsIgnoreCase(filePart.getContentType()))
        {
            return badRequest("Invalid request, only IMAGEs are allowed.");
        }*/
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart image = body.getFile("upload");
        if (image != null) {
            fileName = image.getFilename();
            File file = image.getFile();
            file.renameTo(new File("C:\\Users\\user\\workspace\\AjaxTest\\public\\images\\storeimages", fileName));
        }
        Addactor addactor=new Addactor();
        addactor.firstname=fname;
        addactor.lastname=lname;
        addactor.photo=fileName;
        addactor.url=weburl;
        addactor.save();
        return ok(success.render("File Upload SuccessFully"));
    }
    public static Result displayactor()
    {
        List<Addactor> list=new Model.Finder<Integer,Addactor>(Integer.class,Addactor.class).all();
        return ok(displayactor.render(list));
    }
    public static Result addcompareactor()
    {
        return ok(addcompareactor.render());
    }
    public static Result docompare()
    {
        final DynamicForm dynamicForm=Form.form().bindFromRequest();
        Integer aid1=Integer.parseInt(dynamicForm.get("actor1id"));
        Integer aid2=Integer.parseInt(dynamicForm.get("actor2id"));
        Addcompareactor addcompareactor=new Addcompareactor();
        addcompareactor.actor1id=aid1;
        addcompareactor.actor2id=aid2;
        boolean resultFlag = false;
        // Here We check from Addactor table actorid values whether matching with AddCompareactor id values or not
        Addactor a1 = (Addactor)new Model.Finder(Integer.class, Addactor.class).byId(aid1);
        Addactor a2 = (Addactor)new Model.Finder(Integer.class, Addactor.class).byId(aid2);

        if(a1!=null && a2!=null && aid1!=aid2) {
            resultFlag = true;
        }

//        for (Addactor cmp : compare) {
//            if ((cmp.actorid==addcompareactor.actor1id || cmp.actorid==addcompareactor.actor2id)) {
//                resultFlag = true;
//            }
//        }
        if (resultFlag ) {
            addcompareactor.save();
            return ok(success.render("ActorID1 and ActorID2 has been inserted"));
        }else{
            return badRequest("Remind you have apply foeign key so You have to give same id value from AddActor");
        }
        //Addactor ac=Addactor.find.findUnique();
        //Integer a1=ac.actorid;
        //System.out.println("==================== "+a1);

    }
    public static Result editactor()
    {
        final DynamicForm dynamicForm=Form.form().bindFromRequest();
        Integer aid= Integer.parseInt(dynamicForm.get("aid"));
        String fname=dynamicForm.get("fname");
        String lname=dynamicForm.get("lname");
        String photo=dynamicForm.get("photo");
        String wesite=dynamicForm.get("website");
        ArrayList<Addactor> list=new ArrayList<Addactor>();
        list.add(new Addactor(aid,fname,lname,photo,wesite));
        return ok(editactor.render(list));
    }
    public static Result updateactor()
    {
        final DynamicForm dynamicForm=Form.form().bindFromRequest();
        String aid=dynamicForm.get("aid");
      //  System.out.println("============AID============ "+aid);
        //int ai=Integer.parseInt(aid.trim());
        //Integer aid=Integer.parseInt(dynamicForm.get("aid"));
        String fname=dynamicForm.get("firstname");
       // System.out.println("============AID============ "+fname);
        String lname=dynamicForm.get("lastname");
        //String photo=dynamicForm.get("upload");
        String website=dynamicForm.get("url");
        String fileName="";
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart image = body.getFile("upload");
        if (image != null) {
            fileName = image.getFilename();
            File file = image.getFile();
            file.renameTo(new File("C:\\Users\\user\\workspace\\AjaxTest\\public\\images\\storeimages", fileName));
        }
        Ebean.beginTransaction();
        try {
            Addactor st = Ebean.find(Addactor.class, 1);
            st.setFirstname(fname);
            st.setLastname(lname);
            st.setPhoto(fileName);
            st.setUrl(website);
            st.update();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
        return  ok(success.render("Success fully Updated"));
    }

}
