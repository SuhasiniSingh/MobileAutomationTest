import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppiumServer {

    static String Nodepath="C://Program Files//nodejs//node.exe";
    static String AppiummainJs_path="C://Users//Vishal//AppData//Roaming//npm//node_modules//appium//build//lib//main.js";

    static AppiumDriverLocalService service;
    //static SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);
    SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String input = "2014-12-09 02:18:38";
    Date date = sdfIn.parse(input);

    public AppiumServer() throws ParseException {
    }

    @BeforeTest
    public void startServer() throws InterruptedException {
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
        .usingDriverExecutable(new File(Nodepath))
        .withAppiumJS(new File(AppiummainJs_path))
        .withIPAddress("127.0.0.1")
        .usingPort(4728)
        .withLogFile(new File("C:\\Appium Package\\AppiumLog.txt")));
        System.out.println("Starting the appium server " + "\n" + sdfOut.format(date)+
                "\n--------------------------------------------------------------");
        service.start();
        Thread.sleep(10000);
    }
    @Test
    public void testServer(){
        System.err.println("The URL is : " + service.getUrl().toString());
        System.err.println("Is server running : " + service.isRunning());
    }
    @AfterTest
    public void stopServer(){
        if(service.isRunning()==true){
            service.stop();
            System.out.println("\n----------------------------------------------" +
                    "\nStopping the server..." + "\n" + sdfOut.format(date));
        }
    }

}
