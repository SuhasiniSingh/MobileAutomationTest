import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseClass {
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver;
        /*File f = new File("src");
        File fs = new File(f,"General-Store.apk ");*/
        File filePath = new File(System.getProperty("user.dir"));
        File app = new File(filePath, "/src/General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"suhasemulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        //System.out.println(app.getAbsolutePath());
         driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
