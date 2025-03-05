Feature: Job Search

  Scenario: Search for automation tester jobs
    Given the user is on the LexisNexis homepage
    When the user navigates to the Careers page
    And the user clicks on "Search jobs"
    And the user searches for "Senior Quality Test Engineer"
    Then the user should see at least one search result