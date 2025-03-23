package User;

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

public class XoaNDung {
	public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "c:\\chromedriver.exe";
	public WebDriver driver;
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();

      // Đường dẫn đến thư mục User Data của Chrome để sử dụng thông tin đăng nhập đã lưu
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
  
  	@Test (priority = 2, dependsOnMethods = "AuthenTk" )
	public void NguoiDung() throws InterruptedException {
		// Tìm và click vào phần tử có xpath là
		// "//*[@id=\"main-menu-navigation\"]/li[3]/a/span"
		WebElement ND = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span"));
		ND.click();
		Thread.sleep(2000);
		//
		Random RanND = new Random();
		int stt = RanND.nextInt(10) + 1;
		Thread.sleep(2000);
		WebElement str = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[7]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", str);

		Thread.sleep(3000);

	}

	@Test (priority = 3, dependsOnMethods = "NguoiDung" )
	public void Xoa() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		WebElement nope = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[5]/a"));
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
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + stt
						+ "]/td[7]/a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", str);

		Thread.sleep(3000);

		WebElement xoa = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", xoa);

		//
		String who = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + stt + "]/td[3]"))
				.getText();
		System.out.println("Giảng viên bạn đã chọn là: " + who);
		//
		String whoId = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + stt + "]/td[2]"))
				.getText();
		System.out.println("Mã Giảng viên bạn đã chọn là: " + whoId);

	}
  @AfterTest
  public void afterTest() {
	  driver.close();
	  
  }

}
