package POM_QuanLyHK;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages.Page_HocKy;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_HK {
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
	public void SaiKyTu() throws InterruptedException {
		// Bấm nút Học Kỳ và Ngành
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(1000);

		// Bấm nút tạo học kỳ
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button"))
				.click();
		Thread.sleep(1000);
		
		Page_HocKy hocky = new Page_HocKy(driver);
		hocky.NhapNoiDung("9999", "2023");
		Thread.sleep(2000);
	}
	
	@Test(priority = 3, dependsOnMethods = "SaiKyTu")
	public void KhongDungKy() throws InterruptedException {
		Page_HocKy hocky = new Page_HocKy(driver);
		hocky.NhapNoiDung("9999999", "2023");
		Thread.sleep(2000);
	}
	
	@Test(priority = 4, dependsOnMethods = "KhongDungKy")
	public void Rong() throws InterruptedException {
		
		Page_HocKy Xoahocky = new Page_HocKy(driver);
		Xoahocky.XoaNoiDung("", "");
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
