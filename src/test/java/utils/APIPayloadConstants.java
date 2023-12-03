package utils;

public class APIPayloadConstants {

    public static String generateTokenPayload() {
        String generateToken = "{\n" + "  \"email\": \"salihbatch17@gmail.com\",\n" + "  \"password\": \"123456789\"\n" + "}";
        return generateToken;
    }


    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" + "  \"emp_firstname\": \"Salih\",\n" + "  \"emp_lastname\": \"Aygun\",\n" +
                "  \"emp_middle_name\": \"Sr.\",\n" + "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2003-01-26\",\n" + "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"QA\"\n" + "}";
        return createEmployeePayload;
    }

}