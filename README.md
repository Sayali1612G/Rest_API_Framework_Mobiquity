### What is this repository for? ###

* Cucumber-Rest Assured-Junit- Web Service Automation-Framework
* 1.0.0
* Behavior Driven Development Cucumber-Rest Assured-Junit- Web Service Automation-Framework including Cucumber Pretty & Advanced reports

### How do I get set up? ###

* Summary of set up: 

  1. User should have Java (JDK) and Maven installed.
  2. Clone the repository using "git clone https://github.com/Sayali1612G/Rest_API_Framework_Mobiquity.git"
  
* Dependencies
  
  1. ** Cucumber Dependencies: **
       <dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>5.2.0</version>
		</dependency>
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-jvm-deps</artifactId>
			<version>1.0.6</version>
			<scope>provided</scope>
		</dependency>
 
  2. ** Rest Assured Dependencies: **
       <dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>4.3.2</version>
			<scope>test</scope>
		</dependency>
		
  4. ** Log4j Dependencies: **
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>
		
  5. ** Junit Dependencies: **
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13</version>
			<scope>test</scope>
		</dependency>
		
* How to run tests

   1. ** Maven: ** Run "clean install" to get complete reporting (Advanced & Preety Cucumber Reporting)
   2. ** Junit: ** Run As Junit Test After Selecting the runner class (TestRunner.java)
   3. ** Cucumber: ** Run "clean install -Dcucumber.options="–tags @API_Restassured_Scenario"" to get complete reporting (Advanced & Preety Cucumber Reporting)
  
* Report: Cucumber Reports: net.masterthought - This will generate two reports

   ** Cucumber Pretty (folder - "target\cucumber-reports\cucumber-pretty") **
  
   ** Cucumber Advanced (folder - "target\cucumber-reports\cucumber-advanced-reports\cucumber-html-reports") 
   ** Logger: Implemented the logging feature using LOG4j.

  1. Get the logging details  from logfile.log
  
