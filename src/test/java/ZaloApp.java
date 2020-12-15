import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;

public class ZaloApp {

	
	
	static AppiumDriver<MobileElement> driver;
	public static MobileElement phonenumber;
	public static MobileElement password;
	public static MobileElement login;
	public static MobileElement resetPassword;
	public static MobileElement btnLogin;
	public static MobileElement allow;

	public static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) throws IOException {
		
		try {
			openZaloApp();
		} catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		//wait.until(ExpectedConditions.el
		//login.click();
		allow.click();
		allow.click();

		//loginApp();
	}

	public static void init() {
		phonenumber = driver.findElement(By.id("com.zing.zalo:id/edtAccount"));
		password = driver.findElement(By.id("com.zing.zalo:id/edtPass"));
		login = driver.findElement(By.id("com.zing.zalo:id/btnLogin"));
		resetPassword = driver.findElement(By.id("com.zing.zalo:id/tvForgotPassword"));
		allow = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
	}

	public static void openZaloApp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Maianhtest");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.zing.zalo");
		cap.setCapability("appActivity", "com.zing.zalo.ui.SplashActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		init();

		System.out.println("Application Started");
	}	
	public static void loginApp() {
		
		login.click();
		allow.click();
		allow.click();
	}

	public static void insertPhone(String phone) {
		phonenumber.clear();
		phonenumber.sendKeys(phone);
	}

	public static void insertPass(String strPass) {
		password.clear();
		password.sendKeys(strPass);
	}

	public static void loginzalo(String Phone, String Pass) {
		User user = new User();
		Phone = user.getPhoneNumber();
		Pass = user.getPassWord();

	}

}
