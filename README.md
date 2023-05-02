# Onpier Web Automation Framework

This is a Web Automation Framework built using Selenium + Java + TestNG 

Framework Tree Structure of the Major Components

```
.
|-- Parameters
|   |-- config.properties
|-- src
|   |-- main
|   |   `-- java
|   |       `-- onpierTestHelper
|   |           |   |-- BasePage.java
|   |           |   |-- ConfigRead.java
|   |           |   |-- TestBase.java
|   |           |   `-- WaitHelper.java
|   |           `-- pageObjects
|   |               `-- FahrzeugscheinhochladenPage.java
|   |               `-- OnpierHomePage.java
|   |               `-- PersönlicheDateneingebenPage.java

|   `-- test
|       `-- java
|           `-- onpierTestpersonaldetails
|               `-- TestBuyNow.java
|-- test-output
|-- pom.xml
`-- testng.xml

```

# How to Run Tests

To Run your assignment tests please configure them as a part of the suite in `testng.xml` file and execute the following maven command
`mvn clean test`

OR

Run the `testng.xml` file as TESTNG suite 

