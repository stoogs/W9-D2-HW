package controllers;
import db.Seeds;
import spark.ModelAndView;
import static spark.Spark.get;
import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();
        ManagerController managerController = new ManagerController();
        EmployeeController employeeController = new EmployeeController();
        EngineerController engineerController = new EngineerController();
        DepartmentController departmentontroller = new DepartmentController();
        DefaultController defaultController = new DefaultController();
    }

}



