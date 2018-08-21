package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class DefaultController {

    public DefaultController(){
        startEndPoint();
    }

    private void startEndPoint() {
        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "/templates/index.vtl");
        }, new VelocityTemplateEngine());
    }
}
