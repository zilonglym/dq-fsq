package com.zilong.wechat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RealMachineWeChatTest {
	private AppiumDriver driver;
	
	@Before
	public void setUp() throws Exception {

    }
    @Test
    public void addContact(){
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "");
        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("appActivity", ".ui.LauncherUI");
        capabilities.setCapability("deviceName","c81d08ac");
        capabilities.setCapability("fastReset", "false");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        //Appium版本1.3.3以上,设置允许输入中文
        capabilities.setCapability("unicodeKeyboard", "True"); //使用unicodeKeyboard的编码方式来发送字符串
        capabilities.setCapability("resetKeyboard", "True");   //将键盘给隐藏起来
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        try {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("App is launched!");
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //driver.findElement(((WebElement) By.id(("com.tencent.mm:id/j0"))).click();
        //driver.findElementById("com.tencent.mm:id/aft").click();
        
        //Xpath1
        //driver.findElementByXPath("//android.widget.LinearLayout[5]").click();
        //LinearLayout顺序index随机，不采用
         
        //Xpath2 列表只返回当前屏幕内控件，不采用
//        List<WebElement> linearLayoutList =  driver.findElementsByXPath(
//        		"//android.widget.LinearLayout/android.widget.LinearLayout/"
//        		+ "android.widget.LinearLayout/android.widget.LinearLayout/android.view.View");
//        for (WebElement webElement : linearLayoutList) {
//        	System.out.println(webElement.getText());
//			
//		}
        
        try {
			//搜索定位
        	Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@content-desc='搜索']").click();
			Thread.sleep(500);
			//输入
			//driver.findElementByXPath("//android.widget.EditTex[@text='搜索']").sendKeys("fsq1");  此处不能定位
			List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
			for (AndroidElement androidElement : textFieldsList) {
				if(androidElement.getText().equalsIgnoreCase("搜索")){
					androidElement.sendKeys("fsq1");
					break;
				}
			}
			Thread.sleep(500);
			//点击风湿圈APP
			driver.findElementByXPath("//android.widget.TextView[@text='风湿圈App']").click();
			Thread.sleep(1000);
			
			//driver.findElementByXPath("//android.widget.TextView[@text='问答咨询']").click();//竟然不能直接定位
			List<AndroidElement> textentranceList = driver.findElementsByClassName("android.widget.TextView");
			for (AndroidElement androidElement : textentranceList) {
				if(androidElement.getText().equalsIgnoreCase("问答咨询")){
					androidElement.click();
					break;
				}
			}
			System.out.println("Found!");
			
			//driver.tap(1, 100,1100 , 200);
			//简易咨询
			
			//病历咨询
			
			//远程会诊
			
			//患者管理
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}