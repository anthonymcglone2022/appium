package pom;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class StartPage {
	
	AndroidDriver driver;
	
	public StartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id = "com.testerzy.eduittraining:id/layout_btn")
	private WebElement nextButton;
		
	public void clickNextButton(){
		nextButton.click();
    }
	
}
