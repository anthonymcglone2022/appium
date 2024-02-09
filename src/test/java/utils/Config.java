package utils;



public class Config {

	public static String deviceType = "Emulator"; // Or "BrowserStack"
	public static String deviceName = "Demo8"; // Name of emulator created in Android Studio or found via "adb devices"

	public static String appiumJSExecutor = "C:\\Program Files\\nodejs\\node_modules\\appium\\build\\lib\\main.js";
	public static String appiumServer = "127.0.0.1";
	public static int appiumPort = 4723;
	public static String appiumLog = "appium.log";	
	
	public String appiumURL() {
		return String.format("http://%s:%d", appiumServer, appiumPort); 
	}
	
	public String appLocation() {
		return System.getProperty("user.dir") + "\\src\\test\\resources\\software-testing-app-stapp-0-2-22.apk";
	}
	
}
