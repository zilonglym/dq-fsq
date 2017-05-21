# dq-fsq
## Appium Api 文档
https://testerhome.com/topics/3144

##软件安装月环境配置篇：##
1）安装node.js安装
http://nodejs.cn/download/
http://www.runoob.com/nodejs/nodejs-install-setup.html
v6.10.2
2）Appium
    -- 使用npm安装appium
https://testerhome.com/topics/645  appium npm 。安装uiautomantion2时需要翻墙；
http://www.cnblogs.com/ydnice/p/5787800.html  appium  exe  ，
download https://bitbucket.org/appium/appium.app/downloads/
把node_modules的bin目录放到系统的Path路径里
使用appium-doctor检查安装及配置成功

3）下载安装Android SDK
SDK版本？已安装，跳过
*4）安装JDK并设置JAVA_HOME目录（注意安装64位JDK）
*5）安装ANT
*6）安装MAVEN
安装后添加Path %MAVEN_HOME%/bin
添加MAVEN_HOME

设置Settling.xml的本地仓库地址为F:\maven_repository
在pom或者setting.xml中设置远程仓库地址

遇到的问题：
连接真机步骤：
1）打开手机的USB调试模式 
2）手机连接电脑
验证真机连通性
adb devices
若显示unauthorized未授权，需打开手机调试模式
3）启动appium服务 


一、Appium Inspector定位
在Appium-Android Settings-Device Name中设置连接的机器设备名
启动Appium

二、UI Automator Inspector定位
打开后，点击Device Screenshot，就能刷新出手机的界面，并且能展示定位


##遇到及解决问题：##
1.selenium-Java与Stand的版本不一致导致一些怪异的问题
2.Appium无法输入中文
//Appium版本1.3.3以上,设置允许输入中文
        capabilities.setCapability("unicodeKeyboard", "True");  
        capabilities.setCapability("resetKeyboard", "True");  
仍不行，可能和输入法有关系
3.Appium的日志log中文显示乱码的问题
4.不能直接定位后，直接点击Click
5.H5识别
一个整体的com.tencent.smtt.webkit.WebView下面
进入bebugx5.qq.com内核调试界面，打开定位内核调试功能
->信息->勾选"是否打开TBS内核Inspector调试功能"
貌似不能识别这种内嵌于微信的H5，百度后在testerhome网站有发现有人有解决方案：


进入
chrome://inspect/#devices定位path
具体见：http://www.cnblogs.com/terrylin/p/4606277.html
6.	
https://testerhome.com/topics/7866
https://testerhome.com/topics/7053

7.OCR文字识别
http://www.zuidaima.com/share/2287525382147072.htm
8.

dom格式的元素，通过class_name等等就能够定位到公众号webview的元素了

9.["NATIVE_APP","WEBVIEW_com.tencent.mm:tools","WEBVIEW_com.tencent.mm:appbrand0"]
是用tools还是appbrand0

10.页面跳转的问题
跳转后 getPageSource为空

11.WEBVIEW_undefined
getContextHandles获取的context有出现WEBVIEW_undefined；
查询有人在Android 6.0上遇到，认为是Appium的问题
http://www.cnblogs.com/fgzhang/p/6866466.html

12.SetCapability("newCommandTimeout", "300"); //设置收到下一条命令的超时时间,超时appium会自动关闭session ,默认60秒

13.