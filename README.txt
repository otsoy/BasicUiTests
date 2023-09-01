## Running the Tests
1. Open a terminal or command prompt.
2. Navigate to the project's root directory.
3. Run the following command to execute the tests:

bash
mvn test

If you want to execute test marked with tag add parameter
mvn test -Dcucumber.filter.tags=@Smoke

4. The tests will run, and the results will be displayed in the terminal/command prompt.

## Test Results
The test results will be located at target/cucumber-reports. You can open the HTML report file (index.html) in a web browser to view the detailed test results.

5. Test properties are located in resource/environments folder. TO execute test against specific env add new *.properties file and execute
 mvn test -Dcucumber.filter.tags=@Smoke -Dapp.env=QA
