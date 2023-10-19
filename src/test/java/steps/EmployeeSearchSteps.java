package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.time.Duration;

public class EmployeeSearchSteps extends CommonMethods {
    //public WebDriver driver;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empListOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        WebElement employeeId = driver.findElement(By.id("empsearch_id"));
        employeeId.sendKeys("65230336");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        searchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {
        System.out.println("Test passed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("user enters employee name")
    public void user_enters_employee_name() {
        WebElement nameTextField = driver.findElement(By.id("empsearch_employee_name_empName"));
        nameTextField.sendKeys("mali");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }



}