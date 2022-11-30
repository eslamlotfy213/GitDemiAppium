import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommeerce_Tc1 extends  BaseTest{



@Test
    public void FllForm() throws InterruptedException {


    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("eslam lotfy");
    driver.hideKeyboard();
    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
    driver.findElement(By.id("android:id/text1")).click();
    scrollIntoView_Selecting("Armenia");
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    Thread.sleep(3000);
    String toastMessage= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    Assert.assertEquals(toastMessage,"Please enter your name");
    }




}
