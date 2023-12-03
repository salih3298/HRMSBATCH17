Feature: Syntax API workflow feature

  Background:
    Given aa JWT is generated

  @api1
  Scenario: acreate an employee via API

    Given aa request is prepared to create an employee
    When aa POST call is made to create an employee
    Then athe status code for this request is 201
    And athe employee id "Employee.employee_id" is stored as global variable for other request


