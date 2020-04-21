package com.minuth.automation.youtube;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<MobileElement> driver;
        String appId = "com.google.android.youtube";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","PIXEL 3 XL");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("appPackage",appId);
        capabilities.setCapability("appActivity","com.google.android.youtube.HomeActivity");
        capabilities.setCapability("noReset",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); // URL of Appium Server
        driver = new AndroidDriver<MobileElement>(url,capabilities);

        //Click on search button
        driver.findElementById("com.google.android.youtube:id/menu_item_1").click();
        // type text "Tom and Jerry" in Search Box
        driver.findElementById("com.google.android.youtube:id/search_edit_text").sendKeys("Tom and Jerry");
        //Press Key ENTER after finishing search.
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        System.out.println("Application started....");
    }
}
