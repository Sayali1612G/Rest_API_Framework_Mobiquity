# This Feature is related with Testing a REST API which can get users details
#
# @author  Sayali Gulhane
# @version 1.0
# @since   2021-20-03
Feature: Validating User Search using REST API
  		 Users should be able to submit GET requests and Validate by Rest Assured
  
  @API_Restassured_Scenario @Smoke
  Scenario Outline: User will search username into the service (endpoint=/users)
    When User will search for a user details with "<Path>" , "<username>"
    Then User will Verify the user details as <statusCode> , "<content_Type>" , "<emailid>" and "<name>"

    Examples: 
      | Path        | username  |  statusCode |  content_Type     | 	emailid                     | name              | Validations       |
      | /9          | Delphine  |         200 |  application/json | 	Chaim_McDermott@dana.io  	| Glenna Reichert   | Positivescenario  |
	  | /11         | Delphine  |         404 |  application/json | 	Chaim_McDermott@dana.io  	| Glenna Reichert   | Negativescenario  |