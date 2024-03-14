# What is the appium repository?

- A repository built on Appium 2 for Mobile QA automation
- Allows test cases to be run via a local emulator (with Appium) or on BrowserStack
- Contains an Android app called STApp

## Pre-requisites before building the project

- Install [Maven 3](https://maven.apache.org/index.html) and [Java](https://www.oracle.com/java/technologies/downloads/)
- You must edit the repo's `Config.java` (@ src/test/java/utils/) file with either "Emulator" or "BrowserStack", depending where you wish to run.
- If running locally, follow the [Appium quickstart](https://appium.io/docs/en/latest/quickstart/) for installation instructions
- If running locally, edit the `Config.java` setting `appiumJSExecutor` to point to your installation of NodeJS
- For Browserstack, the above 2 steps are not required, but you must create an account (to receive credentials) and POST the STApp app to [app-automate](https://www.browserstack.com/docs/app-automate/api-reference/appium/apps#upload-an-app) to receive your app's id `bs://`
- For Browserstack, edit the `Config.java` file parameters `browserStackUserName` , `browserStackApiKey` , `browserStackApiKey`

## Building the project

- Run **mvn clean test** on the command line
