Feature: TekArch APITesting

  Scenario: Login with valid username and password
		Given Set the EndPoint
		When Send Post HTTP request
		Then Validate the response
		
		 Scenario: Get AllUsers
		Given Set the EndPoint_GatData
		When Send Get HTTP request
		Then Validate the response for getData