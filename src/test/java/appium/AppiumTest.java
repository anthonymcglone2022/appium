package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	
	@Test
	public void appiumConfig() throws MalformedURLException {
		
		
		 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Program Files\\nodejs\\node_modules\\appium\\build\\lib\\main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		 service.start();		
		
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Demo2");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\ApiDemos-debug.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		service.stop();
	}

}
