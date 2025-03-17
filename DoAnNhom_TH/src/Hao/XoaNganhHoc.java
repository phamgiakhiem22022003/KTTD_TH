package QuanLyNganhHoc;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class XoaNganhHoc {
	public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "c:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// Đường dẫn đến thư mục User Data của Chrome để sử dụng thông tin đăng nhập đã
		// lưu
		String key = "C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data";

		// Tạo đối tượng ChromeOptions để cấu hình Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + key);

		// Khởi tạo đối tượng WebDriver cho Chrome với các tùy chọn đã cấu hình
		driver = new ChromeDriver(options);

		// Mở trang web cần kiểm tra đăng nhập
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");

		// Mở rộng cửa sổ trình duyệt
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void AuthenTk() throws InterruptedException {
		// Gọi phương thức đăng nhập từ class Authen
		Authen.AuthenTK(driver);
		Thread.sleep(2000);
	}

	@Test(priority = 2, dependsOnMethods = "AuthenTk")
	public void HocKyvaNganh() throws InterruptedException {
		// Tìm và click vào phần tử có xpath là
		// "//*[@id=\"main-menu-navigation\"]/li[3]/a/span"
		WebElement HK = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span"));
		HK.click();
		Thread.sleep(2000);
		//Chọn Ngành
		WebElement chonNganh = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"));
		chonNganh.click();
		Thread.sleep(2000);
		
		//
		Random RanND = new Random();
		int stt = RanND.nextInt(10) + 1;
		Thread.sleep(2000);
		WebElement str = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[6]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", str);

		Thread.sleep(5000);

	}

	@Test(priority = 3, dependsOnMethods = "HocKyvaNganh")
	public void XoaNHoc() throws InterruptedException {
		Thread.sleep(2000);
		WebElement nope = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[2]/div[2]/div/ul/li[5]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nope);
		//
		Thread.sleep(2000);
		Random RanND = new Random();
		int stt = RanND.nextInt(10) + 1;
		Thread.sleep(2000);
		//

		Thread.sleep(2000);
		//
		WebElement str = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[6]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", str);

		Thread.sleep(3000);

		WebElement xoa = driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr[1]/td[6]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", xoa);

		//
		String Nganhdachon = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[2]"))
				.getText();
		System.out.println("Mã Ngành đã chọn là: " + Nganhdachon);
		//
		String tenNganhdachon = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[3]"))
				.getText();
		System.out.println("Tên Ngành đã chọn là: " + tenNganhdachon);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
