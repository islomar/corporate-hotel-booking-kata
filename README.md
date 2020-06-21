[![](https://github.com/islomar/corporate-hotel-booking-kata/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/islomar/corporate-hotel-booking-kata/actions)

# Corporate Hotel Booking kata
https://katalyst.codurance.com/corporate-hotel-booking

## Requirements
1. You need to have installed **Maven 3.x** (variables M2_HOME, M2, MAVEN_OPTS, PATH...)
   * https://maven.apache.org/install.html
   * Example for Ubuntu: https://www.vultr.com/docs/how-to-install-apache-maven-on-ubuntu-16-04
2. You need **JDK 1.8**
   * E.g. for Ubuntu: https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04
   * You should have JAVA_HOME correctly configured!

## Set up the development environment
Run `make setup-devenv`. It will:
    * Configure the Git hooks.

## How to run the tests
`mvn clean test` or `make test`

## Documentation
* [Domain Model Diagram](https://app.diagrams.net/?src=about#Hislomar%2Fcorporate-hotel-booking-kata%2Fmaster%2Fdocs%2FDomain%20Model%20Diagram.png)


## BACKLOG
* Refactors:
    * Improve data structure for rooms inside HotelService
    * Use types instead of primitives
    
* TEST CASES: which is the most simple failing test which would help us to move on?
    * Next booking requirement: Verify if booking is allowed according to the booking policies defined, if any. See Booking Policy Service for more details.