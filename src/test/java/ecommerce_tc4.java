import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class ecommerce_tc4 extends baseClass {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        Thread.sleep(4000);
        int listitems=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum=0;
        for(int i=0;i<listitems;i++){
            String amount=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            double amountvalue= getamount(amount);
            sum=sum+amountvalue;
        }
       /* String amount=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        double amountvalue= getamount(amount);
        String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
         double amountvalue1=getamount(amount1);
         double sumofProduct=amountvalue+amountvalue1;*/
        System.out.println(sum);
        String totalAmt=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double totalamount=getamount(totalAmt);
        System.out.println(totalamount);
        Assert.assertEquals(sum,totalamount);
        //Mobile Gestures
        WebElement CheckBox=driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction act = new TouchAction(driver);
        act.tap(tapOptions().withElement(element(CheckBox))).perform();
       /* WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
        act.longPress(longPressOptions().withElement(element(tc))).withDuration(ofseconds(2)).realease().perform();*/
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        driver.quit();
    }
    public static double getamount(String value){
        value=value.substring(1);
        double amountvalue=Double.parseDouble(value);
        return amountvalue;
    }
}
