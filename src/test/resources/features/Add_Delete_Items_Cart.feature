
@cart
Feature: Adding and deleting items into cart


@Books @addingitemintocart
  Scenario: Adding item into cart successfully
    Given user is on ebay home page
    When he searchs for "books"
    And clicks on the first item on the search result 
    And adds the item to the cart
    And he navigates to the cart
    Then the item added is in the cart

    
@Books @deleteiteminthecart
  Scenario: Deleting item in the cart successfully
    Given user is on ebay home page
    When he searchs for "books"
    And clicks on the first item on the search result 
    And adds the item to the cart
    And he navigates to the cart
    And delete the item in the cart
    Then the item is deleted from the cart