import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc_1 extends baseClass{
//Positive scenario for login
    @Test
       public void positiveTestcase() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElementById("android:id/text1").click();
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new Uiselector()).scrollIntoview(text(\"Argentina\"));");
        MobileElement listitem = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(" +
                "new UiSelector().text(\"Argentina\"));"));
        System.out.println(listitem.getLocation());
        listitem.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.quit();
    }
}
