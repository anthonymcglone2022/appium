package tests;

import java.net.MalformedURLException;
import java.time.*;
import java.lang.Thread;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import pom.*;
import driver.Driver;
import utils.Operations;

public class AppiumTest extends Driver {

    @Test
    public void smokeFlow() throws MalformedURLException, InterruptedException {

        // Sleeps added for demo purposes, TODO replace these with WebDriverWait. 
        Thread.sleep(2000);

        StartPage sP = new StartPage(driver);
        sP.clickNextButton();

        Thread.sleep(2000);

        LoginPage lP = new LoginPage(driver);
        lP.clickSkipButton();		
        Thread.sleep(2000);


        Operations.swipeRight(driver);


        Thread.sleep(2000);

        AddEventPage aP = new AddEventPage(driver);

        aP.clickAddButton();
        Thread.sleep(1000);

        aP.clickEventTypeDropDown();
        Thread.sleep(1000);

        aP.clickEventTypeDropDownListSelection("Exam");
        Thread.sleep(1000);

        aP.sendKeysEventNameEditText(String.format("Event Number %d", System.currentTimeMillis()));
        Thread.sleep(1000);

        aP.sendKeysDateOfEventEditText("11.02.2026");
        Thread.sleep(1000);

        aP.clickDateOfEventEditText();
        Thread.sleep(1000);

        aP.clickPopUpOkButton();
        Thread.sleep(1000);

        aP.sendKeysEndOfEventEditText("11.02.2026");
        Thread.sleep(1000);		

        aP.sendKeysTimeOfEventEditText("11:00");
        Thread.sleep(1000);

        aP.clickTimeOfEventEditText();
        Thread.sleep(1000);

        aP.clickPopUpOkButton();
        Thread.sleep(1000);

        aP.sendKeysEndTimeOfEventEditText("11.30");
        Thread.sleep(1000);

        aP.clickAddEventPageSaveButton();
        Thread.sleep(2000);	
    }
}
