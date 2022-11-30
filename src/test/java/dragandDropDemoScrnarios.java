import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class dragandDropDemoScrnarios extends BaseTest{



    @Test
    public  void  Verify_dragandDrop_TestCase() throws MalformedURLException, InterruptedException {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        WebElement source=   driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        DrapandDropAction(source);

        String Result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(Result,"Dropped!");


    }


}
