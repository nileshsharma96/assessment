# assessment

TestNG Automation Framework Documentation

1. Created new maven project eclipse and convert to testNG project

2. Added all the maven dependancy in pom.xml file

3. Created Base file to initialise the browser and created new suite methods in testng.xml file

4. To generate html report, created class for extent report method

5. To capture logs and screenshot for every failed test case, implemented ItestListener interface in testng.xml file and define test rule invoke for each test result scenario

6 Converted screenshots into Base64 file and then attached into extent report so report can be shared over mail easily using smtp mailing method where everybody can access the available screenshots

7. Created two different classes
	a. PageObjects – In this class, all the elements path is defined and method
	b. TestObjects  –  In this class, methods are called using oops method by creating a 	new object and testNG annotations are defines with their respective attributes

8. To cover all the test cases, I have created two classes
	a. SignIn – To login the user and open dashboard
	b. CreateTask - To create new task with adding 3 new rows after switching into 	“iframe” and added dummy data in bold charactes

9. Final report generated in the project directory only in report folder

Selenium based web automation framework:
1) POM based (Completed)
2) Screenshot capture on test failure (Completed)
3) HTML and JSON reports of all tests (Completed)
4) Parallel testing functionality (Completed)
5) Clear documentation (README) about how to setup and run tests sequentially as well as in parallel (Completed)

Test cases:
1) Register for an account on the Evernote website. (Completed)
2) Sign in to your Evernote account. (Completed)
3) Create a task in the Evernote dashboard. (Completed)
4) In the task note, include a table and an image. (Completed)
	a. In the table, add two more rows and fill all the fields with dummy data. 	(Completed)
	b. The dummy data should be in bold font. (Completed)
	c. Insert any images into the note. (Pending)




Note – Not able to upload image on my system due to technical limitation of linux operating 	system, and there is no dedicated upload element with type “input” 	where I can use 	sendKeys method to upload it.
	
	But on windows OS we can use autoIT tool to interact with windows screen to 	uplaod the files directly.
