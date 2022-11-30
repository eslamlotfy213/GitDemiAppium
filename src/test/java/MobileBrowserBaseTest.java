import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileBrowserBaseTest {

   public AppiumDriverLocalService service;
   public UiAutomator2Options options;
   public AndroidDriver driver;

   @BeforeClass
    public  void configuration() throws MalformedURLException{
         service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Eslam.Lotfy//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        options = new UiAutomator2Options();
        options.setDeviceName("testApp");
        options.setChromedriverExecutable("D:\\[LATEST VERSION 2.0] Master on Mobile Apps Automation Testing from basics to Framework CICD with real time examples\\83.0.4103\\chromedriver.exe");
        options.setCapability("browserName","Chrome");

        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public Double getFormatAmmount(String amount){
        Double price= Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public  void TearDown()
    {
        driver.quit();
        service.stop();
    }


}
