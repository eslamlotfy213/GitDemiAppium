import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Wifi_Scenario extends BaseTest{



    @Test
    public  void  Verify_Wifi_TestCase() throws MalformedURLException
    {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();

        driver.findElement(By.id("android:id/checkbox")).click();

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        String alertTitle =  driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals(alertTitle,"WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("wifi text");

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();



    }



}
