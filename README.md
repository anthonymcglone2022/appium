# What is the appium repository?

- A repository built on Appium 2 for Mobile QA automation
- Allows test cases to be run via a local emulator (with Appium) or on BrowserStack
- Contains an Android app called STApp

## Pre-requisites before building the project

- Install [Maven 3](https://maven.apache.org/index.html) and [Java](https://www.oracle.com/java/technologies/downloads/)
- You will have to edit the repo's `Config.java` file with either "Emulator" or "BrowserStack"
- If running locally, follow the [Appium quickstart](https://appium.io/docs/en/latest/quickstart/) for installation instructions
- For Browserstack, the above step is not required, but you must create an account (to receive credentials) and POST your app to [app-automate](https://www.browserstack.com/docs/app-automate/api-reference/appium/apps#upload-an-app) to receive your app's id `bs://`

## Building the project

- Run **mvn clean test** on the command line
