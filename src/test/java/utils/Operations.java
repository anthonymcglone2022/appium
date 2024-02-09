package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.util.Arrays;
import java.time.Duration;


public class Operations {
	
    public static void swipe(AndroidDriver driver, Point startPoint, Point endPoint) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint.x, startPoint.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endPoint.x, endPoint.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
    
    public static void swipeLeft(AndroidDriver driver) {
    	Dimension screenSize = driver.manage().window().getSize();
    	
        Point startPoint = new Point((int) (screenSize.width * 0.8), screenSize.height / 2); // 80% of screen width
        Point endPoint = new Point((int) (screenSize.width * 0.2), screenSize.height / 2); // 20% of screen width 
        
        swipe(driver, startPoint, endPoint);
    }
    
    public static void swipeRight(AndroidDriver driver) {
    	Dimension screenSize = driver.manage().window().getSize();

        Point startPoint = new Point((int) (screenSize.width * 0.2), screenSize.height / 2); // 20% of screen width
        Point endPoint = new Point((int) (screenSize.width * 0.8), screenSize.height / 2); // 80% of screen width
    	
    	swipe(driver, startPoint, endPoint);
    }
    
    public static void swipeUp(AndroidDriver driver) {
    	Dimension screenSize = driver.manage().window().getSize();
    	
        Point startPoint = new Point(screenSize.width / 2, screenSize.height / 2);
        Point endPoint = new Point(screenSize.width / 2, screenSize.height / 4); // Swipe upward    	
    	
    	swipe(driver, startPoint, endPoint);
    }
    
    public static void swipeDown(AndroidDriver driver) {
    	Dimension screenSize = driver.manage().window().getSize();
    	
		Point startPoint = new Point(screenSize.width / 2, screenSize.height / 4);
		Point endPoint =  new Point(screenSize.width / 2, screenSize.height / 2); // downward    	
    	
    	swipe(driver, startPoint, endPoint);
    }
}
