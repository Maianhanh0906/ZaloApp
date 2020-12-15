import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(AppiumDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
	}

	private String PhoneNumber;
	private String PassWord;
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	

}
