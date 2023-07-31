# Web Automation Framework

This is a web automation framework developed using Java as the programming language, Selenium as the web automation framework, Maven for dependency management, Cucumber for Behavior-Driven Development (BDD) style testing, and Allure for reporting purposes. The primary goal of this framework is to provide an efficient and maintainable way to automate web applications testing.

### Getting Started

To set up and use the framework, follow these steps:

 **Prerequisites**:

- Make sure you have Java Development Kit (JDK) installed on your system.
- Ensure you have Maven installed.

**Clone the Repository:**

    git clone https://github.com/SalimKhanDaraz/WebAutomation.git

**Install Dependencies**:
Navigate to the project directory and execute the following command:

    mvn clean install

****
### Project Structure
The project structure is organized in the following manner:

```shell
        |-- WebAutomation
        |    |-- Config
        |    |-- src
        |    |   |-- main
        |    |   |   |-- java
        |    |   |   |   |   |-- PageObjects
        |    |   |   |   |   |-- utils
        |    |   |-- test
        |    |   |   |-- java
        |    |   |   |   |   |-- Pages
        |    |   |   |   |   |-- StepDefinitions
        |    |   |   |   |   |-- Runner
        |    |   |   |-- resources
        |    |   |   |   |-- features
        |    |-- pom.xml
```
**WebAutomation**: Project root directory.
**config**: Holds properties file with project related data like Url, Credentials etc..
**src/main/java**: Contains the main Java code for the framework.
- **PageObjects**: Contains web elements of web pages.
- **utils**: Contains utility classes

**src/test/java**: Contains the test-related Java/Selenium code.
- **Pages**: Includes page object classes representing the web pages of the application under test.
- **StepDefinitions**: Holds Cucumber step definition files mapping feature steps to Java/Selenium code.
- **Runners**: Contains test runners for executing Cucumber tests.

**src/test/resources**: Contains the resources required for testing.
- **features**: Holds the feature files written in Gherkin format.

### Dependencies

                
----

The project dependencies are managed using Maven and are listed in the pom.xml file.

- Java (JDK) 8 or above
- Selenium WebDriver
- Cucumber
- TestNG
- Allure

### Generating Report

                
----

The framework is integrated with Allure for reporting. After running the tests, you can generate the Allure report by executing the following command on terminal:

```shell
allure serve
```

### Test Cases Execution

                
----

The following two scenarios are part of the automation project:

- Successful Login.
- Add to cart and checking out.

To run the project using the below maven command:
```shell
mvn clean test
```
###Feedback

                
----
Any feedback regarding this automation project would be appreciated.
Email: ksalim538@gmail.com
