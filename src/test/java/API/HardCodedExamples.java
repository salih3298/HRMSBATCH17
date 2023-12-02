package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;


public class HardCodedExamples {

    // in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzIwNTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU3NTI1MiwidXNlcklkIjoiNjA4MCJ9.1xyAXRjk-UyMRqXC_7vSjkaHM-BXkGAGs0Y8AYQD4CA";

    @Test
    public void createEmployee() {
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

    }
}
