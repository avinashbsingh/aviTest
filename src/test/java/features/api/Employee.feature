@api @firstapi @EmployeeApi

Feature: API Feature

  @apiEmployee
  Scenario: Get All Employee Data
    Given Employee Get endpoint URL as "getEmp" with ""
    And Employee Hit GET call
    Then Expect the Status Code as "200"


  @apiEmployeeById
  Scenario Outline: Get All Employee Data
    Given Employee Get endpoint URL as "getempbyid" with "<ID>"
    And Employee Hit GET call
    Then Expect the Status Code as "<StatusCode>"

    Examples:
      | ID | StatusCode |
      | 1  | 200        |


  Scenario Outline: Create New Employee Data
    Given Employee Create Request for "createemp" with "<attribute>" as "<value>"
    And Employee Hit POST call
    Then Expect the Status Code as "<StatusCode>"

    Examples:
      | ID | StatusCode |
      | 1  | 200        |

  @CreateEmployee
  Scenario Outline: Create New Employee Data
    Given Employee Create Request for "createemp" with "<attribute>" as "<value>"
    And Employee Hit POST call
    Then Expect the Status Code as "<StatusCode>"

    Examples:
      | ID | StatusCode | attribute       | value         |
      | 1  | 200        | name,salary,age | ABC1,20000,23 |