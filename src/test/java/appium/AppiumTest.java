package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class AppiumTest {
	
	public AndroidDriver driver;
	
	
	@Test
	public void appiumConfig() throws MalformedURLException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Demo2");
		options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\ApiDemos-debug.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
