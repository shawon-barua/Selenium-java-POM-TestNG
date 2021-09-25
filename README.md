# Selenium-java-POM-TestNG
Web automation by selenium, java ,TestNG following Page Object Model
# Environment Requirement #
1. Java should be installed 
2. Maven will be needed

#Test Implemeted
1. Check if country change ,also change currency and rate 
2. Check if buy and sell text box emptied when written on another
3. Check if loss value showing correctly if loss occurs
## How to use : ##	
-Open the project in an IDE , I Will suggest IntelliJ IDEA .
- <b>Configure webdriver.</b>
    - Download chromeDriver according to your chrome browser version as this test will run in chrome browser
    - keep it in resource folder of the project > './src/resource/chromedriver.exe'

- Go to project root path by terminal. And execute the command one after another 
- Run `mvn clean` / From IntelliJ in maven lifecycle run 'clean' 
- Run `mvn compile` / From IntelliJ in maven lifecycle run 'compile'
- Run `mvn test` / From IntelliJ in maven lifecycle run 'test'
-  or un testcases

# Result : #
Test result in :  `./target/surefire-reports/index.html`.
