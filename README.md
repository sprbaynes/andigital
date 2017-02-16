# ANDigital Foursquare Project

## Overview

This project is for the ANDigital Foursquare developer tech test. It is an Angular 1.4 single page application running
on top of a Spring RestTemplate based API. It makes use of the Foursquare locations and venue search APIs to find venues
of a given cateogry near a general location e.g. Coffee shops near London, UK.

## Running the project

Software Requirements: Java 8, Maven 3, npm, bower, grunt

To run the project execute the following command, in a terminal, from the root directory of the project. This should run
all the necessary commands to get the app up. This command requires you to have the software, listed above, installed:

    npm start

Once run, visit the URL: http://localhost:8080/

If running the project from a Windows machine you may find that the single shot command 'npm start' doesn't work. If so
Execute the following commands in sequence:

    1. npm install #the post install part of the command may fail on windows but this is fine, please continue
    2. bower install
    3. grunt
    4. mvn tomcat7:run

## Running the Java unit tests

To run the Java unit tests execute the following command, which will build and test the application as well as package
it into a deployable war file.

mvn clean package

## Running the Angular e2e tests

To run the Angular e2e test execute the following command:

    npm run protractor

## Running the Angular unit tests

To run the Angular unit tests execute the following command:

    npm test

## Using the Frontend Application

To use the frontend application execute the following steps on the running project:

    1. In your browser visit the URL 'http://localhost:8080/'. You should see a web page containing two text inputs.
    2. Click on the Location text input, clear the text and type 'London'. An auto-complete dropdown should appear
    beneath the input. To select your location click on one of the auto-complete results.
    3. Click on the Venue text input, clear the text and type 'Coffee'.
    4. Click the 'Go' button to the right of the Venue input. The results should be displayed on the right side of the
    page.


