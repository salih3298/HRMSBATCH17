package utils;

import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AdminDashBoardPage adminDashBoardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        adminDashBoardPage = new AdminDashBoardPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
    }


}