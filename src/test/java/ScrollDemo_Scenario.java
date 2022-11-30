import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollDemo_Scenario extends BaseTest{



    @Test
    public  void  Verify_ScrollDemo_TestCase() throws MalformedURLException, InterruptedException {


       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        Thread.sleep(200);


        scrollToEndAction();
        //scrollIntoView("WebView3");




    }



}
