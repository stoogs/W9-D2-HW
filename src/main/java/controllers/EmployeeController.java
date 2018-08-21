package controllers;
import db.DBHelper;
import db.Seeds;
import models.Department;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.post;
import static spark.route.HttpMethod.get;

public class EmployeeController {

    public EmployeeController() {
    setupEndPoint();
    }

    private void setupEndPoint(){
            get("/employees", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                List<Employee> employees = DBHelper.getAll(Employee.class);
                model.put("template", "templates/employees/index.vtl");
                model.put("employees",employees);
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

        get ("/employees/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Integer id = Integer.parseInt(req.params(":id"));
            Employee employeeById = DBHelper.find(id, Employee.class);
            model.put("template", "templates/employees/show.vtl");
            model.put("employeeById", employeeById);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}