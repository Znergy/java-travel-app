import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.*;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/travel", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Travel> travels = request.session().attribute("travels");
      if(travels == null) {
        travels = new ArrayList<Travel>();
        request.session().attribute("travels", travels);
      }
      String description = request.queryParams("description");
      String location = request.queryParams("location");
      Travel newTravel = new Travel(description, location);
      travels.add(newTravel);
      request.session().attribute("travels", travels);
      model.put("travels", request.session().attribute("travels"));
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
  }
}
