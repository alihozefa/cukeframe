@search-hotel @smoke-test @regression

  @requireLogin
  Feature: Verify search hotel functionality
    Scenario: Validate search module
      Given user is at the home page "PHPTRAVELS | Travel Technology Partner"
      When user select the "Hotel" tab
      And search hotel or city name "Sydney"
      And enter check-in date "10/09/2019"
      And enter check-out date "11/09/2019"
      And click search button
      Then view hotel details
      And verify hotel overview