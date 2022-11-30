import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LognPress_Scenario extends BaseTest{



    @Test
    public  void  Verify_LognPress_TestCase() throws MalformedURLException, InterruptedException {


       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
       driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();





         WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
         LongpressAction(element);

         String menuTitle =  driver.findElement(By.id("android:id/title")).getText();
         Assert.assertEquals(menuTitle,"Sample menu");
         Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
         Thread.sleep(3000);




    }



}
