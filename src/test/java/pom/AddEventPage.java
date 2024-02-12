package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddEventPage {

    AndroidDriver driver;

    public AddEventPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/add_btn")
    private WebElement addButton;

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/save_btn")
    private WebElement saveButton;

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/event_type")
    private WebElement eventTypeDropDown;

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/event_edittext")
    private WebElement eventNameEditText;

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/date_of_event_edittext")
    private WebElement dateOfEventEditText;	

    @AndroidFindBy(id = "android:id/button1")
    private WebElement popUpOkButton;	

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/date_end_edittext")
    private WebElement endOfEventEditText;	
	
    @AndroidFindBy(id = "com.testerzy.eduittraining:id/event_start_time_edittext")
    private WebElement timeOfEventEditText;		

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/event_end_time_edittext")
    private WebElement endTimeOfEventEditText;	

    @AndroidFindBy(id = "com.testerzy.eduittraining:id/save_button")
    private WebElement addEventPageSaveButton;	

    public void clickAddButton(){
        addButton.click();
    }

    public void clickSaveButton(){
        saveButton.click();
    }	

    public void clickEventTypeDropDown(){
        eventTypeDropDown.click();
    }

    public void clickEventTypeDropDownListSelection(String choice){
        String xpath = "//android.widget.TextView[@resource-id=\"com.testerzy.eduittraining:id/event_type\" and @text=\"" + choice + "\"]";
        driver.findElement(By.xpath(xpath)).click();
    }	
	
    public void sendKeysEventNameEditText(String text){
        eventNameEditText.sendKeys(text);
    }	

    public void sendKeysDateOfEventEditText(String text){
        dateOfEventEditText.sendKeys(text);
    }		

    public void clickDateOfEventEditText(){
        dateOfEventEditText.click();
    }

    public void clickPopUpOkButton(){
        popUpOkButton.click();
    }

    public void sendKeysEndOfEventEditText(String text){
        endOfEventEditText.sendKeys(text);
    }				

    public void sendKeysTimeOfEventEditText(String text){
        timeOfEventEditText.sendKeys(text);
    }		

    public void clickTimeOfEventEditText(){
        timeOfEventEditText.click();
    }	

    public void sendKeysEndTimeOfEventEditText(String text){
        endTimeOfEventEditText.sendKeys(text);
    }		

    public void clickAddEventPageSaveButton(){
        addEventPageSaveButton.click();
    }
}
