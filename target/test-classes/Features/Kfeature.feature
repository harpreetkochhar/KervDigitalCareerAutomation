@JobSearch
Feature: Job Application
  
  @JobApplicationJourney
  Scenario: Job Application at Kerv Digital
    Given I navigate to Kerv Digital Website
    And I select to accept cookies
    When I hoover on Careers 
    And I select Job Opportunities
    And I Search Vacancies by Job Role
    |JobRole   | UX Designer                  |    
    And I select the Job Role
    |JobRole   | UX Designer                  |
    |Country   | United Kingdom               |
    And I entered the required details to apply the job
    |FirstName | KervJobTest                  |
    |LastName  | Test                         |
    |Email     | kvtest@gmail.com             |
    |Phone     | 0123456789                   |
    |Resume    | F:\kervJob.pdf               |         
    And select Privacy Policy
    And Submit the applictaion
    Then I see successful confirmation message

  
