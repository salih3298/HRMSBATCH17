Feature: add job Title feature


  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
@jobTitle1
  Scenario: Add new job titles
    When user clicks on the admin button
    And user clicks on the job button
    And user clicks on the job Titles button
    And user clicks on the add button
    And user enters jobTitle "SlowQA" desc "Lightining slow testing" note "Results guranted speed is"
    And user clicks on the save button
    Then verify same info from backend
