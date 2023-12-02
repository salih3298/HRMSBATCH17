package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkflowSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    RequestSpecification request;
    Response response;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        request = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"salihbatch17@gmail.com\",\n" +
                        "  \"password\": \"123456789\"\n" +
                        "}");
        response = request.when().post("/generateToken.php");
        // storing the token after generating it
        token = "Bearer " + response.jsonPath().getString("token");

    }

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request = given().header("Content-Type", "application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"Salih\",\n" +
                        "  \"emp_lastname\": \"Aygun\",\n" +
                        "  \"emp_middle_name\": \"Sr.\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2003-01-26\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post("/createEmployee.php");

        // to print the response in console
        response.prettyPrint();

    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer statusCode) {
        // validate the response status
        response.then().assertThat().statusCode(statusCode);
        // validate the body
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Salih"));
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));


    }

}
