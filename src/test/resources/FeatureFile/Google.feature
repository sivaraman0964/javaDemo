Feature: Google search functionality

  Scenario: TC_01 To check the google search functionality with different inputs
    Given user launches the browser
    When user enters the keyword and clicks search and prints in console
      | selenium | java | python | softobiz | technology | azure DevOps | Microsoft Dapr |
    Then user closes the browser
