package driver;

import org.testng.annotations.*;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.io.File;
import java.time.Duration;

import utils.Config;

public class Driver {
	
	Config config = new Config();
	
	AppiumDriverLocalService service;
	
	public AndroidDriver driver;

    @BeforeClass
    public void startEnvironment() throws IOException {
        if(Config.runType.equals("Emulator")){
        	startServer();
        	emulatorDriver();
        } else if (Config.runType.equals("BrowserStack")) {
            browserStackDriver();
        }
    }
    
    @AfterClass
    public void stopEnvironment() {
        if(Config.runType.equals("Emulator")){
            driver.quit();
            service.stop();
        } else if (Config.runType.equals("BrowserStack")) {
            driver.quit();
        }
    }    
	
    public AppiumDriverLocalService startServer() {
        boolean running = isServerRunning(Config.appiumPort);
        if (!running) {
            service = new AppiumServiceBuilder()
                    .withAppiumJS(new File(Config.appiumJSExecutor))
                    .withIPAddress(Config.appiumServer)
                    .withLogFile(new File(Config.appiumLog))
                    .withTimeout(Duration.ofSeconds(Config.appiumServerTimeOut))
                    .usingPort(Config.appiumPort).build();
            service.start();
        }
        return service;
    }    
    
    public boolean isServerRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(port);

            serverSock.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSock = null;
        }
        return isServerRunning;
    }
    
    
    public AndroidDriver emulatorDriver() throws IOException {    	
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(Config.emulatorDeviceName);
		options.setApp(config.appLocation());
		driver=new AndroidDriver(new URL(config.appiumURL()), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;     
    }    

    public AndroidDriver browserStackDriver() throws IOException {    	
    	DesiredCapabilities capes = new DesiredCapabilities();
    	
    	capes.setCapability("deviceName", Config.browserStackDeviceName);
    	capes.setCapability("os_version", Config.browserStackOsVersion);
    	capes.setCapability("Project", Config.browserStackProject);
    	capes.setCapability("build", Config.browserStackBuild);
    	capes.setCapability("name", Config.browserStackName);
    	capes.setCapability("app", Config.browserStackAppId);
    	
    	driver=new AndroidDriver(new URL(config.browserStackAppUrl()), capes);
    	
    	return driver;     
    }
}
