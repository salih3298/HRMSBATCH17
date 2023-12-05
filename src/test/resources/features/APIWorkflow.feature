Feature: Syntax API workflow feature

  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee via API

    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request

  @api
  Scenario: get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    And the global employee id must match with "employee.employee_id" key
    And the retrieved data at "employee" object matches the data used to create employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Salih         | Aygun        | Sr.             | Male       | 2003-01-26   | confirmed  | QA            |


  @json   @api
  Scenario: Creating the employee using json paylaod
    Given a request is prepared for creating an employee via json payload
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request
    And the response body contains "Message" key and value "Employee Created"

  @jsondynamic   @api
  Scenario: Creating the employee using json paylaod
    Given a request is prepared for creating an employee with dynamic data "Salih", "Aygun", "Sr.","M", "2003-01-26","confirmed","QA"
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for other request
    And the response body contains "Message" key and value "Employee Created"


    # Write the scenarios get request for getting all the job titles and employees and validate the results
  @apiHW1
  Scenario: Getting all employees
    Given a request is prepared for getting all employees
    When a GET call is made to get all employees
    Then the status code for this employee is 200

  @apiHW2
  Scenario: Getting all job titles
    Given a request is prepared for getting all job titles
    When a GET call is made to get all job titles
    Then the status code for this employee is 200
