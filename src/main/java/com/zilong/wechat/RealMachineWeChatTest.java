package com.zilong.wechat;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RealMachineWeChatTest {
	private static AppiumDriver driver;
	private AndroidElement finalElement;
	
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
        capabilities.setCapability("newCommandTimeout", "300");
        //Appium版本1.3.3以上,设置允许输入中文
        capabilities.setCapability("unicodeKeyboard", "True"); //使用unicodeKeyboard的编码方式来发送字符串
        capabilities.setCapability("resetKeyboard", "True");   //将自带键盘给隐藏起来
        
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
        	Thread.sleep(10000);
			driver.findElementByXPath("//android.widget.TextView[@content-desc='搜索']").click();
			Thread.sleep(500);
			//输入
//			driver.findElementByXPath("//android.widget.EditTex[@text='搜索']").sendKeys("fsq1");  //此处不能定位
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
			System.out.println("Login Success!");
			
			
			Thread.sleep(1000);
			//System.out.println(driver.getPageSource());
			//driver.context("WEBVIEW_com.tencent.mm:tools");
			//切换到webview
			switchtoWeb();
			
//			//简易咨询//*/div[@class='main_content ']/*/*/p
//			////*/div[@class='main_content ']/*/*/a[@class='weui-btn module-1']
////			Thread.sleep(1000);
////			driver.findElementByXPath("//*[contains(@href, 'order')]").click();
//			driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[@class='weui-btn module-1']").click();
////			driver.findElementByXPath("/html/body/div[3]/div[1]/div[1]/p").click();
//			System.out.println("点击简易咨询成功");
//			Thread.sleep(1000);
//			navigate(-1);
//			Thread.sleep(1000);
			
			//病历咨询
			Thread.sleep(5000);
			//switchtoWeb();
			////*/div[@class='main_content ']/*/*/a[@class='weui-btn module-2']
//			driver.findElementByXPath("//*[contains(@href, 'friend')]").click(); //page里有多个隐藏api
			driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[@class='weui-btn module-2']").click();
			//driver.findElementByLinkText("病历咨询").click();//超文本链接获取
			//上面这句没法定位
			//driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[contains(@href, 'friend')]").click();
			System.out.println("点击病历咨询成功");
			Thread.sleep(10000);
			//navigate(-1);
			//Thread.sleep(1000);
			//页面跳转后重新获取上下文
			
			System.out.println(driver.getContext());
			Set<String> contextNames = driver.getContextHandles();
	        for (String contextName : contextNames) {
	        	System.out.println(contextName); 
//	        	if(contextName.contains("tools")){
//	        		driver.context(contextName);
//	        	}
	         }
	        //driver.context("WEBVIEW_com.tencent.mm:tools");
	        //System.out.println(driver.getPageSource());//此处无法获取PageCode
	        
	        //clickScreen100(30,30);
	        
//			List<AndroidElement> orderList1 = driver.findElementsByXPath("//*/div[@class='main_content ']/div[@class='weui-form-preview']");
//			if(orderList1.size()<1){
//				System.out.println("无病历咨询记录1");
////				return ;
//			}
			
			List<AndroidElement> orderList2 = driver.findElementsByClassName("weui-form-preview__hd order_type_online");
			if(orderList2.size()<1){
				System.out.println("无病历咨询记录2");
//				return ;
			}
			
			for (AndroidElement androidElement : textentranceList) {
				if(androidElement.getText().equalsIgnoreCase("问答咨询")){						
					androidElement.click();
					break;
				}
			}
			
//			//远程会诊
//			////*/div[@class='main_content ']/*/*/a[@class='weui-btn module-4']
////			driver.findElementByXPath("//*[contains(@href, 'remote')]").click();
//			Thread.sleep(5000);
//			driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[@class='weui-btn module-4']").click();
//			System.out.println("点击远程会诊成功");
//			Thread.sleep(5000);
//			navigate(-1);
//			Thread.sleep(5000);
			
//			//患者管理
//			////*/div[@class='main_content ']/*/*/a[@class='weui-btn module-5']
////			driver.findElementByXPath("//*[contains(@href, 'patient')]").click();
//			driver.findElementByXPath("//*/div[@class='main_content ']/*/*/a[@class='weui-btn module-5']").click();
//			System.out.println("点击患者管理成功");
//			Thread.sleep(5000);
//			navigate(-1);
//			Thread.sleep(1000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    /**
     * 获取当前时间并截图，命名
     * @return
     */
    public static String getScreen(){
    	String fileRoute="路径";
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
    	String picname=fileRoute+df.format(new Date()).toString()+".png";
    	       File screen = driver.getScreenshotAs(OutputType.FILE);
    	       System.out.println(picname);
    	       File screenFile = new File(picname);
    	       try {
    	           FileUtils.copyFile(screen, screenFile); 
    	           String time=df.format(new Date()).toString();
    	           System.out.println("当前时间"+time);
    	           return time;
    	       } catch (IOException e) {
    	           e.printStackTrace();
    	       }
    	return null;
    }
    
    /***
    * 切换WEB页面查找元素
    */
    public static void switchtoWeb(){
	    try {
	         Set<String> contextNames = driver.getContextHandles();
	         for (String contextName : contextNames) {
	           // 用于返回被测app是NATIVE_APP还是WEBVIEW，如果两者都有就是混合型App
//	           if(contextName.contains("WEBVIEW")||contextName.contains("webview")){
//		           driver.context(contextName);
//		           System.out.println("跳转到web页 开始操作web页面"); 
//		           break;
//	           }
	           if(contextName.contains("appbrand")||contextName.contains("appbrand")){
		           driver.context(contextName);
		           System.out.println("跳转到web页 开始操作web页面"); 
		           break;
	           }
	         }
	    }catch (Exception e) {
	         e.printStackTrace();
	    }
    }
    
    
    /***
    * 相对坐标 传入长宽的百分比
    * @param 宽度从左到右的百分比
    * @param 长度从上到下的百分比
    */
    public static void clickScreen100(int i,int j){
    	int x=driver.manage().window().getSize().width;
    	int y=driver.manage().window().getSize().height;
    	driver.tap(1, x*i/100, y*j/100, 200);
    }
    
    /***
    * 截图 文件名: 内容-年月日时分秒
    */

    public static String getScreen(String name){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    	String picname=name+df.format(new Date()).toString()+".png";
        File screen = driver.getScreenshotAs(OutputType.FILE);
        System.out.println(picname);
        File screenFile = new File(picname);
        try {
            FileUtils.copyFile(screen, screenFile); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picname;
    }
    
    /**
     * 发送邮件
     */
    public static void mail(String Value, String subject){
    	
    }
    
    /***
    * 根据text查找元素
    * @param view的类型
    * @param text的内容
    * @return
    */
    public static WebElement getViewbyXathwithtext(String view,String name){
    	return driver.findElementByXPath("//"+view+"[contains(@text,'"+name+"')]");
    }
	    
	/**
	 * WebView navigate 操作    /html/body/div[1]/div[1]/a
	 */
    public static void navigate(int action){
    	switch(action){
    	case-1:
    		///html/body/div[1]/div[1]/a
    		//driver.findElementByXPath("//*/div[@class='weui-flex app-header']/div[@class='weui-flex__item']/a[@href='/wx/11/service']").click();
    		//driver.findElementByClassName("tool-icon fa fa-home").click();
    		driver.navigate().back();   // 后退
    		switchtoWeb();
    		break;
    	case 1:
    		driver.navigate().forward();// 前进
    		break;
    	default:
    		driver.navigate().refresh();// 刷新
    		break;
    	}
    }
}