package driver;

import org.testng.annotations.*;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

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
        if(config.deviceType.equals("Emulator")){
        	startServer();
        	createDriver();
        } else if (config.deviceType.equals("BrowserStack")) {
            //bsCapabilities();
        }
    }
    
    @AfterClass
    public void stopEnvironment() {
        if(config.deviceType.equals("Emulator")){
            driver.quit();
            service.stop();
        } else if (config.deviceType.equals("BrowserStack")) {
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
                    .withTimeout(Duration.ofSeconds(200))
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
    
    
    public AndroidDriver createDriver() throws IOException {    	
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(Config.deviceName);
		options.setApp(config.appLocation());
		driver=new AndroidDriver(new URL(config.appiumURL()), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;     
    }    
     
}
