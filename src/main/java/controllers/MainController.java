package controllers;

import db.Seeds;

public class MainController {
    public static void main(String[] args) {
        Seeds.seedData();
        ManagerController managerController = new ManagerController();
        EmployeeController employeeController = new EmployeeController();
        EngineerController engineerController = new EngineerController();
        DepartmentController departmentontroller = new DepartmentController();
    }
}
