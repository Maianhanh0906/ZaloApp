import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginApp {
	public static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readExcel();
		for(User user:users) {
			System.out.println(user.getPhoneNumber()+"\t"+user.getPassWord());
		}
	}

	public static void readExcel() throws IOException {
		FileInputStream file = new FileInputStream("CaseLogin.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
		for (Row row : sheet) {
			User user = new User();
			if (row.getCell(0) != null) {
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//				System.out.println(row.getCell(0));
				user.setPhoneNumber(row.getCell(0).getStringCellValue());
			}
			if (row.getCell(1) != null) {
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//				System.out.println(row.getCell(1));
				user.setPassWord(row.getCell(1).getStringCellValue());
			}
			users.add(user);
		}
		wb.close();
		file.close();
	}
}
