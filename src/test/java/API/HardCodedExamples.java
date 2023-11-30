package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.junit.runner.Request;


public class HardCodedExamples {

    // in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDEzMDU0NjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTM0ODY2MywidXNlcklkIjoiNjA4MCJ9.D77mrc9pM7yfZOTBfumixdKERw_mHxQIUmuuMcQo4zw";

    public void createEmployee() {
        // prepare the request
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
        // send the request
        // response is the class which holds the complete response body and the info
        Response response = request.when().post("/createEmployee.php");

        // validate the response
        response.then().assertThat().statusCode(201);
    }


}
