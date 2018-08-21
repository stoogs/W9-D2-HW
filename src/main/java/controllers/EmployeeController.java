package controllers;
import db.DBHelper;
import db.Seeds;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


//    get ("/employees/new", (req, res) -> {
//        Map<String, Object> model = new HashMap<>();
//        List<Employee> employeess = DBHelper.getAll(Employee.class);
//        model.put("template", "templates/employees/create.vtl");
//        model.put("employees", employees);
//        return new ModelAndView(model, "templates/layout.vtl");
//    }, new VelocityTemplateEngine());
//
//    post ("/employees, (req, res) -> {
//        int employeeId = Integer.parseInt(req.queryParams("employee"));
//        Employee employee = DBHelper.find(employeeID, Employee.class);
//        String firstName = req.queryParams("firstName");
//        String lastName = req.queryParams("lastName");
//        int salary = Integer.parseInt(req.queryParams("salary"));
//        int budget = Integer.parseInt(req.queryParams("budget"));
//        Employee employee= new Employee(firstName, lastName, salary, budget);
//        DBHelper.save(manager);
//        res.redirect("/managers");
//        return null;
//    }, new VelocityTemplateEngine());
    }
}