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

public class BaseTest {

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
       // options.setApp("C://Users//Eslam.Lotfy//IdeaProjects//untitled//src//test//resources//ApiDemos-debug.apk");
       options.setApp("C://Users//Eslam.Lotfy//IdeaProjects//untitled//src//test//resources//General-Store.apk");




        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public Double getFormatAmmount(String amount){
        Double price= Double.parseDouble(amount.substring(1));
        return price;
    }


    public void LongpressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),
                        "duration",2000));
    }



    public void scrollToEndAction()
    {
        boolean canScrollMore=true;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }



    public void scrollIntoView_Selecting(String Text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"" +Text+ "\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text=\""+Text+"\"]")).click();
    }




    public void scrollIntoView(String Text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"" +Text+ "\"));"));
    }



    public void SwipAction(WebElement element, String direction ) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }


    public  void  DrapandDropAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 619,
                "endY", 560
        ));
    }


    @AfterClass
    public  void TearDown()
    {
        driver.quit();
        service.stop();
    }


}
