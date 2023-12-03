package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkflowSteps2 {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;
    public static String employee_id;
    RequestSpecification request;
    Response response;

    @Given("aa JWT is generated")
    public void aa_jwt_is_generated() {
        request = given().header("Content-Type", "application/json").body("{\n" +
                "  \"email\": \"salihbatch17@gmail.com\",\n" + "  \"password\": \"123456789\"\n" + "}");
        response = request.when().post("\n" + "/generateToken.php");
        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);
    }

    @Given("aa request is prepared to create an employee")
    public void aa_request_is_prepared_to_create_an_employee() {
        request = given().header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" + "  \"emp_firstname\": \"Anıl\",\n" + "  \"emp_lastname\": \"Aygun\",\n" +
                        "  \"emp_middle_name\": \"Kucuk\",\n" + "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2005-01-26\",\n" + "  \"emp_status\": \"Trying\",\n" +
                        "  \"emp_job_title\": \"SDET\"\n" + "}");

    }

    @When("aa POST call is made to create an employee")
    public void aa_post_call_is_made_to_create_an_employee() {
        response = request.when().post("/createEmployee.php\n");
        response.prettyPrint();
    }

    @Then("athe status code for this request is {int}")
    public void athe_status_code_for_this_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));
        response.then().assertThat().header("Keep-Alive", equalTo("timeout=5, max=100"));
        response.then().assertThat().header("Content-Type", equalTo("application/json"));
        response.then().assertThat().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_status", equalTo("Trying"));
    }

    @Then("athe employee id {string} is stored as global variable for other request")
    public void athe_employee_id_is_stored_as_global_variable_for_other_request(String empID) {

        employee_id = response.jsonPath().getString(empID);
        System.out.println(employee_id);
        System.out.println(empID);

    }
}
