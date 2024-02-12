package utils;

public class Config {

    public static String runType = "Emulator"; // "Emulator" Or "BrowserStack"
    public static String emulatorDeviceName = "Demo8"; // Created in Android Studio or found via "adb devices"

    public static String browserStackUserName = ""; // Generated with a BrowserStack account
    public static String browserStackApiKey = "";

    // POST .apk to endpoint /app-automate/upload to receive ID of remote location 
    public static String browserStackAppId = "bs://";

    public static String browserStackDeviceName = "Google Pixel 5";
    public static String browserStackOsVersion = "12.0";
    public static String browserStackProject = "BrowserStack Environment";
    public static String browserStackBuild = "1.0";
    public static String browserStackName = "BrowserStack Demo Test";	

    public static String appiumJSExecutor = "C:\\Program Files\\nodejs\\node_modules\\appium\\build\\lib\\main.js";
    public static String appiumServer = "127.0.0.1";
    public static int appiumPort = 4723;
    public static String appiumLog = "appium.log";
    public static long appiumServerTimeOut = 200;

    public String appiumURL() {
        return String.format("http://%s:%d", appiumServer, appiumPort); 
    }

    public String appLocation() {
        return System.getProperty("user.dir") + "\\src\\test\\resources\\software-testing-app-stapp-0-2-22.apk";
    }

    public String browserStackAppUrl() {
        return "https://"+browserStackUserName+":"+browserStackApiKey+"@hub-cloud.browserstack.com/wd/hub";
    }

}
