package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    public WebDriver driver;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
    }

    @When("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empListOption.click();
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        WebElement employeeId = driver.findElement(By.id("empsearch_id"));
        employeeId.sendKeys("65230336");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        searchBtn.click();
    }

    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
