import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommeerce_Tc3 extends  BaseTest {


    private double totalsum;

    @Test
    public void FllForm() throws InterruptedException {


        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("eslam lotfy");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollIntoView_Selecting("Armenia");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        // driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        List<WebElement>   prductprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = prductprices.size();
        totalsum = 0;
        for (int i = 0; i < count; i++) {
            String ammountstring =prductprices.get(i).getText();
            Double price= getFormatAmmount(ammountstring);
            totalsum = totalsum + price;
        }
        String displaysum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double finalsum   = getFormatAmmount(displaysum);

        Assert.assertEquals(totalsum,finalsum);

        WebElement element=  driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        LongpressAction(element);

        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.className("android.widget.CheckBox")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(3000);

        Set<String> contexts = driver.getContextHandles();

        for ( String contextName :contexts) {

            System.out.println(contextName);
        }

       // NATIVE_APP
       // WEBVIEW_com.androidsample.generalstore
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Welcome");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}