import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowser extends MobileBrowserBaseTest{



    @Test
    public  void MobileBrowserTest() throws InterruptedException {

//        driver.get("https://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("Amazon AmazonAmazonAmazonAmazon");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        Thread.sleep(6000);


        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);", "");
        String text= driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(text,"Devops");
















    }
}
