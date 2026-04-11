Feature: Upload resume into Naukri.com

  Scenario: Upload resume into Naukri.com for every 10 mins
    Given user logins into naukri application
    When verify user lands on home page
    And users updates profile summary
    Then user resume is updated
