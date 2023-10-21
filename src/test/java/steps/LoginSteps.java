package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    //  public WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        //  driver = new ChromeDriver();
        //  driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //  driver.manage().window().maximize();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApplication();


    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        WebElement usernameTextField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        // object of the login page class to access all the web elements
        LoginPage lp = new LoginPage();
        // usernameTextField.sendKeys("admin");
        // Thread.sleep(2000);
        sendText(lp.usernameTextField, ConfigReader.getPropertyValue("username"));
        // WebElement passwordTextField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        //WebElement passwordTextField = driver.findElement(By.cssSelector("input#txtPassword")); //Shortcut for CssSelector
        sendText(lp.passwordTextField, ConfigReader.getPropertyValue("password"));
        //  passwordTextField.sendKeys("Hum@nhrm123");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage lp = new LoginPage();
        // WebElement loginButton = driver.findElement(By.xpath("//*[@value='LOGIN']"));
        click(lp.loginBtn);
        // loginButton.click();
        // Thread.sleep(2000);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("My test passed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


}
