package com.dqfsq.doctor.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SimpleConsultationTest {
	private static AppiumDriver driver;
	private AndroidElement finalElement;
	
	@Before
	public void setUp() throws Exception {
        try {
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
            capabilities.setCapability("resetKeyboard", "True");   //将自带键盘给隐藏起来
            
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			System.out.println("Wechat is launched!");
			Thread.sleep(10000);
			driver.findElementByXPath("//android.widget.TextView[@content-desc='搜索']").click();
			Thread.sleep(500);
			//输入
			List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
			for (AndroidElement androidElement : textFieldsList) {
				if(androidElement.getText().equalsIgnoreCase("搜索")){
					androidElement.sendKeys("fsq1");
					break;
				}
			}
			Thread.sleep(2000);
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
			System.out.println("Current Doctor login fsq Success!");
			
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    @Test
    public void AcceptOrder(){
    	
    	try {
			Thread.sleep(5000);
			driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[@class='weui-btn module-2']").click();
			System.out.println("点击病历咨询成功");
			Thread.sleep(5000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    @After
    public void tearDown() throws Exception {
    	driver.quit();
    }
}
