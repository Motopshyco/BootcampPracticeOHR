Bootcamp practice in the Orange page

This is a framework to test the Orange HRM page and here are the instructions to use it:

Dependencies:
- testng version 7.5
- selenium java version 4.4
- webdrivermanager version 5.3
- commons-io version 2.11
- cucumber-testng version 7.3.4 with jUnit exclusion
- cucumber-java version 7.3.4
- cucumber-picocontainer 7.3.4
- cucumber-core 7.3.4

how to run it: 
- you will need intelliJ IDE
- set up the following env variables in the IDE config:
  - browser: chrome or firefox
  - user: login username
  - password: login password
  - url: Orange HRM login URL
  - timeout: in second, for example: 5
- Execute the test runner class in the test/java/runner folder

To see the reports:
After execute the fremework, go to target folder and open the cucumber-reports folder and there is a cucumber-pretty file.
Select this file and open it in the explorer, that will take to you to the file folder and open that file with your browser.
You will se the full report with all the information of the test execution.
