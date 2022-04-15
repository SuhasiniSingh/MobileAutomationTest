import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

public class ecommerce_tc2 extends baseClass {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver= capabilities();
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
        //System.out.println("Total number of available options are " +  options.size());
        WebElement radioGroup = driver
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                        + "new UiSelector().text(\"Jordan 6 Rings\").instance(0))"));
        int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<count;i++){
            String text= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(text.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        String lastpageText=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals("Jordan 6 Rings",lastpageText);
        driver.quit();
    }
}
