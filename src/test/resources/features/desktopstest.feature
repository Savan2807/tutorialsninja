Feature: Desktop page

  As a user I want to check desktop page and add product into cart

  Background: I am on homepage

  @sanity @smoke @regression
  Scenario: User should arrange product in alphabetical order successfully
    When I mouse hover and click on desktop tab
    And I select menu "Show AllDesktops"
    And I select product sort by "Name (Z - A)"
    Then I should see product arrange in alphabetical order successfully

  @smoke @regression
  Scenario Outline:User should be able to add product to cart successfully
    When I mouse hover and click on currency dropdown
    And I mouse hover and click on  £ Pound Sterling
    And I mouse hover and click on desktop tab
    And I select menu "Show AllDesktops"
    And I select product sort by "Name (Z - A)"
    And I select product "<product>"
    And I should see product text "<product>"
    And I select qty 1
    And I click on add to cart button
    And I should see the message Success: You have added "<product>" to your shopping cart!
    And I click on shopping cart link into success message
    And I should see the shopping text
    And I should see the product name "<product>"
    And I should see the model "<model>"
    Then I should see the total "<price>"
    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |