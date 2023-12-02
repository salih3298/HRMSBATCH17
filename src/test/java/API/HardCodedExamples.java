package API;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    // in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzY4NzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU4MDA3MiwidXNlcklkIjoiNjE2NSJ9.M2b5KqN7IvFvyopZpyyg7LDq-uucSxJJn0ICkURc8Do";
    static String employee_id;

    @Test
    public void acreateEmployee() {
        // prepare the request
        //request specification allows us to prepare the request and gives it in variable
        RequestSpecification request = given().header("Content-Type", "application/json")
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
        //send the request for creating the employee
        // response is the class which holds the complete response body and the info
        Response response = request.when().post("/createEmployee.php");

        // to print the response in console
        response.prettyPrint();

        // validate the response status
        response.then().assertThat().statusCode(201);
        // validate the body
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Salih"));
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));
        //to store the employee id after generating the employee
        employee_id = response.jsonPath().getString("Employee.employee_id");

    }

    @Test
    public void bgetCreatedEmployee() {
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);

    }

    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"rakhima\",\n" +
                        "  \"emp_lastname\": \"bhujbal\",\n" +
                        "  \"emp_middle_name\": \"simonov\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-11-09\",\n" +
                        "  \"emp_status\": \"struggling\",\n" +
                        "  \"emp_job_title\": \"survivor\"\n" +
                        "}");
        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void dgetupdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }


}
