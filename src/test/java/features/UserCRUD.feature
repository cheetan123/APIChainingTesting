Feature: GoRest User Operations

  Scenario: User calls web service to create a user
    When create a user
    Then verify user created successfully with status code 201

  Scenario: User calls web service to update the user data by Id
    When update the user
    Then verify updated successfully and api returns status code 200

  Scenario: User calls web service to delete the user data by Id
    When delete the user
    Then verify user deleted successfully and api returns status code 204
