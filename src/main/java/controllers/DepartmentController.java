package controllers;

import db.DBHelper;
import models.Department;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.get;
import db.DBHelper;
import db.Seeds;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.route.HttpMethod.get;

public class DepartmentController {


    public DepartmentController() {
        setupEndPoint();
    }

    private void setupEndPoint() {
        get("/departments ", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department> departments = DBHelper.getAll(Department.class);
            model.put("template", "templates/departments/index.vtl");
            model.put("departments", departments);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/departments/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Department> departments = DBHelper.getAll(Department.class);
            model.put("template", "templates/departments/create.vtl");
            model.put("departments", departments);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get ("/departments/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            Department departmentById = DBHelper.find(id, Department.class);
            model.put("template", "templates/departments/show.vtl");
            model.put("departmentById", departmentById);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post ("/departments", (req, res) -> {
            String title = req.queryParams("title");
            Department departmentNew = new Department(title);
            DBHelper.save(departmentNew);
            res.redirect("/departments");
            return null;
        }, new VelocityTemplateEngine());

    }

}
