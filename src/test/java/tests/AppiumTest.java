package tests;

import java.net.MalformedURLException;
import java.time.*;
import java.lang.Thread;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import pom.*;
import driver.Driver;

public class AppiumTest extends Driver {
	
	// TODO do browserstack capabilities

	@Test
	public void smokeFlow() throws MalformedURLException, InterruptedException {		
		Thread.sleep(2000);
		StartPage sP = new StartPage(driver);
		sP.clickNextButton();
		Thread.sleep(2000);
		
		LoginPage lP = new LoginPage(driver);
		lP.clickSkipButton();
		Thread.sleep(2000);
	}

}
