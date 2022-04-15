import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ecommerce_tc5 extends baseClass {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElementById("android:id/text1").click();
        MobileElement listitem = (MobileElement) driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(" +
                                "new UiSelector().text(\"Argentina\"));"));
        System.out.println(listitem.getLocation());
        listitem.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        //driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        //driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        //Mobile Gestures
        WebElement CheckBox=driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction act = new TouchAction(driver);
        act.tap(tapOptions().withElement(element(CheckBox))).perform();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(8000);
        Set<String> contexts= driver.getContextHandles();
        Thread.sleep(7000);
        for(String contextNames : contexts){
            System.out.println(contextNames);
        }
       // driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.context((String) contexts.toArray()[1]);
        driver.findElement(By.name("q")).sendKeys("hello");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //to comeback from webview to native app
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        driver.quit();
    }


}
