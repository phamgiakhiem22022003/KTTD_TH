package QuanLyTKB;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class XemTKB {
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
	public void XemThoiKhoaBieu() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
		Thread.sleep(2000); // click vào TKB
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[3]/a[1]")).click();
		Thread.sleep(2000); // click vào phần xem TKB
	}

	@Test(priority = 3, dependsOnMethods = "XemThoiKhoaBieu")
	public void HHvaHV() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span")).click();
		Thread.sleep(5000); // Click vào ô học kỳ
		
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[1]/input[1]"))
				.sendKeys("997");
		Thread.sleep(5000); // Điền thông tin học kỳ
		
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li"))
				.click();
		Thread.sleep(5000); // Click vào học kỳ muốn chọn
		
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]"))
				.click();
		Thread.sleep(5000); // Click vào ô giảng viên
		
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[2]/span[1]/span[1]/input[1]"))
				.sendKeys("Võ Anh Tiến");
		Thread.sleep(5000); // Điền thông tin giảng viên
		
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li"))
				.click();
		Thread.sleep(5000); // Click vào giảng viên muốn chọn
		

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]"))
				.click();
		Thread.sleep(5000); // Click vào ô tuần
		
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[1]/input[1]"))
				.sendKeys("Tuần 16");
		Thread.sleep(5000); // Điền thông tin Tuần
		
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[1]"))
				.click();
		Thread.sleep(5000); // Click vào tuần muốn chọn
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
