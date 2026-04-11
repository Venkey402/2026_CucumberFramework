Feature: Upload resume into Naukri.com

  Background:
    Given user logins into naukri application
    When verify user lands on home page

  @ProfileSummaryUpdate
  Scenario: 1.update resume headline in Naukri.com for every 10 mins.
    And users updates profile summary
    Then verify profile summary is updated

  @ResumeUpdate
  Scenario: 2.Upload resume into Naukri.com for every 10 mins.
    And users uploads resume
    Then verify resume is uploaded