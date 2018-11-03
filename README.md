# api-test
A small Java application that validates a given api with a pre-defined criteria

## Description
In response to Assurity team’s request, this is a stand-alone eclipse project offering a small application to validate a given api with a pre-defined criteria. 
The application provides a GUI (using Java’s awt) allowing users to define dynamic values for certain expected parameters. In addition, the application is also executable by JUnit with static values for the requested criteria.   

In general, the application focuses mainly on the following measurements:
1. The API’s endpoint’s availability and http success response: verified by having a successful connection and valid response code. 
2. The response type of the ‘Get’ HttpRequest: the test will fail if any response type that is not “application/json”
3. The required criteria with specified values in the Json response:
	 - Name = "Carbon credits"
	 - CanRelist = true
	 - The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"

The application runs each of above points in a seperate test, but the final result is based on the success for all tests. 

The default end point URL for the API is set to [a static server](https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false). But; to add more functionality, the GUI has dynamic input fields so that testers can change the criteria values whenever needed (for the URL and also for the condition values). 

Although the many tools and libraries that are available to validate rest Api, this application was developed without utilizing any.  

## Prerequisites

Things you need to install to run the software:

1. [Eclipse IDE](https://www.eclipse.org/downloads/), or any IDE of your choice. 
2. [Java SDK 1.8 or later](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
3. Gson jar that is available from [Maven Central](https://search.maven.org/artifact/com.google.code.gson/gson/2.8.5/jar).
4. JUnit 4 or later.

## Running the project

1. After cloning/downloading the project into a directory, open Eclipse (or any IDE of you choice) and import the project. 
In case of Eclipse, create a new Java Project, the go to File -> Import to get files from file System.  Hit `Next` and `Select root directory` to the folder where you installed the project, select it and then finish.

2. Make sure you have the build path set to include the Prerequisites. In Eclipse, right-click on the project, click on `Build Path` and select `Configure build path` to include the neccessary libraries.  
![builtpath](https://user-images.githubusercontent.com/6084396/47948231-958b5f80-df35-11e8-8f22-eeeec8c82fc5.png)

![pre](https://user-images.githubusercontent.com/6084396/47948230-958b5f80-df35-11e8-9268-f594ac80d40a.PNG)

## How it works
A tester may run the application in one of two ways: 
1. Using the User Interface 
2. Using Junit runner. 

###### Using Panel Interface

![start](https://user-images.githubusercontent.com/6084396/47948382-f5cfd080-df38-11e8-8913-984273c9f5a0.PNG)

![running](https://user-images.githubusercontent.com/6084396/47948236-a1772180-df35-11e8-9147-b0f4f60e2f79.png)

The `ApplicationLauncher` is the class that has the main method. When it is selected to run the application with, a panel (awt panel) is launched to run the tests. In there, a user can select and type whatever criteria values are required to validate. In the panel, the available dynamic fields for values’ validation are: 
- The api’s url
- Name
- CalRelist
- Promotions values: 
  - Name
  - Description

![canrelist](https://user-images.githubusercontent.com/6084396/47948238-a20fb800-df35-11e8-842d-39ee68b5928c.PNG)

![1_url_failure](https://user-images.githubusercontent.com/6084396/47948237-a1772180-df35-11e8-9b2a-6856afdcf1e1.PNG)

![promotion_fail](https://user-images.githubusercontent.com/6084396/47948235-a1772180-df35-11e8-9312-b8be2837d692.PNG)

The application is clever enough to recognize where failures are coming from. And hence, it prints out the red X flag at the exact point where the failure happens with an error message at the bottom. The overall test result (pass or fail) depends on the success of all the criteria given in the panel.

![details](https://user-images.githubusercontent.com/6084396/47948239-a20fb800-df35-11e8-95c8-e92de25cd9ca.PNG)

![pass](https://user-images.githubusercontent.com/6084396/47948396-2a438c80-df39-11e8-9838-33a3f546f93a.PNG)


###### Using Junit

If only Junit tests are preferred to run without the UI, a user may select the file `CriteriaTest` to run. In this case, only Junit tests will execute without the UI. But in this case, the tests will give their assesrtion results seperately without an overall status for all tests. 

![junit](https://user-images.githubusercontent.com/6084396/47948240-a20fb800-df35-11e8-8317-0b6b15a769e0.PNG)

## Notes
1. The application is designed to ignore case sensitivity in the name and description criteria. For example, if the criteria is set to verify ‘2x lArger iMagE’ content in the description while api response has ‘2x larger image’, the test is considered a success pass. 
2. The application Panel UI is configured to have default values that are equal to the original criteria from Assurity. 
3. Also, no empty values are allowed in the UI. If any field is left blank, it will be populated with the default value.
