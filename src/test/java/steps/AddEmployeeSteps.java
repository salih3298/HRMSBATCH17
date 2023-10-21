package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeBtn = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        click(addEmployeeBtn);
    }

    @When("user enters firstName middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement middleNameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText(firstNameField, "Salih");
        sendText(middleNameField, "Anıl");
        sendText(lastNameField, "Aygün");

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
        click(saveBtn);

    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @Then("user close the browser")
    public void user_close_the_browser() {
        closeBrowser();
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement middleNameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText(firstNameField, firstName);
        sendText(middleNameField, middleName);
        sendText(lastNameField, lastName);
    }
    @When("user enters {string} and {string} and enters {string}")
    public void user_enters_and_and_enters(String firstName, String middleName, String lastName) {
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement middleNameField = driver.findElement(By.xpath("//input[@id='middleName']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
        sendText(firstNameField, firstName);
        sendText(middleNameField, middleName);
        sendText(lastNameField, lastName);
    }


}
