package com.test;

import static org.testng.Assert.assertTrue;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {

	public static Boolean flag = true; // 判断控件是否存在
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;

	/**
	 * 正常新手帐号登录逻辑
	 */
	public void login(String phone1, String phone2) {
		click(findById(Xml.read("welcome"))); // 点击立即进入
		Input(findById(Xml.read("p_edt")), phone1); // 输入帐号
		click(findById(Xml.read("sms_btn"))); // 点击获取验证码
		if (isPlay(Xml.read("vericodebtn"))) {
			back();
			Input(findById(Xml.read("p_edt")), phone2);
			click(findById(Xml.read("sms_btn")));
		}
		Input(findById(Xml.read("code_edt")), "1111"); // 输入验证码
		click(findById(Xml.read("loginbtn"))); // 点击登录
		assertTrue(isPlay(Xml.read("elite")), "找不到控件:" + Xml.read("elite")); // 判断
	}

	/**
	 * 通过id判断控件存不存在，存在找控件的等待
	 */
	public static boolean isPlay(String id) {
		for (int i = 0; i <= 5; i++) {
			if (isPlayById(id)) {
				break;
			}
			sleep(500);
			if (i == 2) {
				break;
			}
		}
		if (isPlayById(id)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isPlayById(String id) {
		try {
			driver.findElementById(id).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 通过by判断控件存不存在，判断完就立即返回
	 */
	public static boolean isPlayBy(By by) {
		try {
			driver.findElement(by).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void getActivity() {
		String s = driver.currentActivity();
		System.out.println(s);
	}

	/**
	 * 往控件输入信息
	 */
	public static void Input(WebElement el, String value) {
		el.sendKeys(value);
	}

	/**
	 * 点击某个控件
	 */
	public static void click(WebElement el) {
		el.click();
	}

	/**
	 * 不可以点击的强制点击
	 */
	// public static void strongclick(WebElement el){
	// int x=el.getRect().x;
	// int y=el.getRect().y;
	//
	//
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// HashMap tapObject = new HashMap();
	// tapObject.put("x", x);
	// tapObject.put("y", y);
	// tapObject.put("duration", 1);
	// js.executeScript("mobile: tap", tapObject);
	// //或者使用adb命令：adb shell input tap x y
	// }

	/**
	 * 输出信息
	 */
	public static void print(String flag2) {
		if (flag2 == "") {
			Reporter.log("在：" + Time() + "输出了空字符串");
			System.out.println("在：" + Time() + "输出了空字符串");
		} else {
			Reporter.log("在：" + Time() + flag2);
			System.out.println("在：" + Time() + flag2);
		}
	}

	/**
	 * 按返回键
	 */
	public static void back() {
		driver.pressKeyCode(0);
	}

	/**
	 * 隐式等待
	 */
	public void waitAuto(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * 显式等待
	 */
	public static WebElement waitAuto(WebDriver driver, final By by,
			int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int attempt = 1; attempt <= waitTime; attempt++) {
			try {
				driver.findElement(by);
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				print("等了" + attempt + "秒");
				if (attempt == waitTime) {
					break;
				}
			}
		}
		if (isPlayBy(by)) {
			flag = true;
			return wait
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else {
			flag = false;
			return null;
		}
	}
	public static WebElement waitAuto(String text, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		for (int attempt = 1; attempt <= waitTime; attempt++) {
			try {
				driver.findElementByAndroidUIAutomator(text);
				break;
			} catch (Exception e) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				print("等了" + attempt + "秒");
				if (attempt == waitTime) {
					break;
				}
			}
		}
		if (isPlayByText(text)) {
			flag = true;
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.tagName(text)));
		} else {
			flag = false;
			return null;
		}
	}
	public static boolean isPlayByText(String text) {
		try {
			driver.findElementByAndroidUIAutomator(text).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static WebElement findById(String id) {
		WebElement el = waitAuto(driver, By.id(id), 3);
		if (flag) {
			return el;
		} else {
			print("控件：" + id + "不存在");
			assertTrue(false, "等了3秒还找不到控件");
			return null;
		}
	}
	public static WebElement findByClass(String id) {
		WebElement el = waitAuto(driver, By.className(id), 3);
		if (flag) {
			return el;
		} else {
			print("控件：" + id + "不存在");
			assertTrue(false, "等了3秒还找不到控件");
			return null;
		}
	}
	public static WebElement findByXpath(String id) {
		WebElement el = waitAuto(driver, By.xpath(id), 3);
		if (flag) {
			return el;
		} else {
			print("控件：" + id + "不存在");
			assertTrue(false, "等了3秒还找不到控件");
			return null;
		}
	}
	public static WebElement findByText(String id) {
		WebElement el = waitAuto(id, 3);
		if (flag) {
			return el;
		} else {
			print("控件：" + id + "不存在");
			assertTrue(false, "等了3秒还找不到控件");
			return null;
		}
	}
	/**
	 * 获取时间
	 * 
	 * @return
	 */
	public static String Time() {
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		long ctime = System.currentTimeMillis();
		String currenttime = formattime1.format(new Date(ctime));
		return currenttime;
	}
	
	public static void sleep(int s) {
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void beforeSuite() {
		cmdCtrl.startServer("4723");
	}
	@AfterSuite
	public void afterSuite() {
		driver.quit();
		cmdCtrl.stopServer("4723");
		cmdCtrl.openHtml();
	}
	final int i=2;
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void BeforeClass(){
		DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setCapability("deviceName", getInfo(i).get("deviceName"));
		cap.setCapability("platformName", "Android");
		 cap.setCapability("platformVersion", getInfo(i).get("platformVersion"));
		cap.setCapability("unicodeKeyboard", "true");
		cap.setCapability("resetKeyBoard", "true");
		cap.setCapability("appPackage", "com.thetiger.ldd");
		cap.setCapability("appActivity",
				"com.thetiger.ldd.ui.activity.SplashActivity");
		// cap.setCapability("sessionOverride", true);
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					cap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取安卓设备信息
	 */
	public static  Map<String,String> getInfo(int i){
		Map<String,String> maps=new HashMap<String, String>();
		switch (i) {
		case 1:
			maps.put("deviceName", "127.0.0.1:62001");
			maps.put("platformVersion","4.4.2");
			break;
        case 2:
        	maps.put("deviceName", "eddffa38");
			maps.put("platformVersion","5.1.1");
			break;	
		default:
			break;
		}
		return maps;
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
	
	/**
	 * 随机生成手机号码
	 */
	public static String phoneNum() {
		int i = 10000000 + (int) (Math.random() * 99999999);
		String pn = "137" + Integer.toString(i);
		return pn;
	}

}
