Feature: API UI test

  @uiTest @create_user
  Scenario Outline: User verify create user api
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    And User verifies the output data for <apiName>
    Examples:
      | apiName       | endPoint      | availability |
      | "CREATE_USER" | "CREATE_USER" | "VISIBLE"    |

  @uiTest @register_user
  Scenario Outline: User verify register user api
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    Examples:
      | apiName         | endPoint        | availability |
      | "REGISTER_USER" | "REGISTER_USER" | "VISIBLE"    |


  @uiTest @single_user
  Scenario Outline: User verify API for Single User
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    And User verifies the output data for <apiName>
    Examples:
      | apiName       | endPoint      | availability  |
      | "SINGLE_USER" | "SINGLE_USER" | "NOT_VISIBLE" |


  @uiTest @list_user
  Scenario Outline: User verify API for list User
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    And User verifies the output data for <apiName>
    Examples:
      | apiName     | endPoint    | availability  |
      | "LIST_USER" | "LIST_USER" | "NOT_VISIBLE" |

  @uiTest @single_user_not_found
  Scenario Outline: Verify single user not found api
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    Examples:
      | apiName                 | endPoint                | availability  |
      | "SINGLE_USER_NOT_FOUND" | "SINGLE_USER_NOT_FOUND" | "NOT_VISIBLE" |


  @uiTest @update_user
  Scenario Outline: User verify update user api
    Given User navigate to home page
    Then User scroll down to <apiName>
    And User click the <endPoint> endpoint
    And User verifies the <apiName> request data is <availability>
    And User verifies the response code for <apiName>
    And User verifies the request path for <apiName>
    And User verifies the output data for <apiName>
    Examples:
      | apiName       | endPoint      | availability |
      | "UPDATE_USER" | "UPDATE_USER" | "VISIBLE"    |
#