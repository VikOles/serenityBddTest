Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

  Scenario Outline: Search verification
    When he calls endpoint "<product>"
    Then he sees the results displayed for "<product>"
    And verify json schema "searchProducts.json"
    Examples:
      | product |
      | orange  |
      | apple   |
      | pasta   |
      | cola    |
  Scenario: Negative search verification
    When he calls endpoint "car"
    Then he does not see the results
