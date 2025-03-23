package POM_QuanLyHocKy;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyHocKy.Page_TaoHocKy;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC_TaoHocKyKhongThanhCong {
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
		
		// Thực hiện đăng nhập
        Authen.AuthenTK(driver);
        Thread.sleep(2000);
		
	}

	@Test(priority = 1)
	public void TaoHocKy_SaiKyTu() throws InterruptedException {
		// Bấm nút Học Kỳ và Ngành
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(1000);

		// Bấm nút tạo học kỳ
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(1000);
		
		Page_TaoHocKy hocky = new Page_TaoHocKy(driver);
		hocky.NhapNoiDung("9999", "2025");
		Thread.sleep(2000);
		
		//Thông báo hiển thị
		System.out.println("----------------------------------");
		WebElement errorMessage = driver.findElement(By.id("id-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Không hiển thị thông báo lỗi khi nhập sai ký tự");
	}
	
	@Test(priority = 2)
	public void TaoHocKy_QuaKytu() throws InterruptedException {
		Page_TaoHocKy hocky = new Page_TaoHocKy(driver);
		hocky.NhapNoiDung("9999999", "2025");
		Thread.sleep(2000);
		
		//Thông báo hiển thị
		System.out.println("----------------------------------");
		WebElement errorMessage = driver.findElement(By.id("id-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Không hiển thị thông báo lỗi khi nhập quá số ký tự cho phép");
	}
	
	@Test(priority = 3)
	public void TaoHocKy_KytuChu() throws InterruptedException {
		Page_TaoHocKy hocky = new Page_TaoHocKy(driver);
		hocky.NhapNoiDung("e", "2025");
		Thread.sleep(2000);
		
		//Thông báo hiển thị
		System.out.println("----------------------------------"); 
		WebElement errorMessage = driver.findElement(By.id("id-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Không hiển thị thông báo lỗi khi nhập ký tự chữ");
	}
	
	@Test(priority = 4)
	public void TaoHocKy_RongKyTu() throws InterruptedException {
		
		Page_TaoHocKy Xoahocky = new Page_TaoHocKy(driver);
		Xoahocky.XoaNoiDung("", "");
		Thread.sleep(2000);
		
		//Thông báo hiển thị
		System.out.println("----------------------------------");
		WebElement errorMessage = driver.findElement(By.id("id-error"));
	    Assert.assertTrue(errorMessage.isDisplayed(), "Không hiển thị thông báo lỗi khi để trống thông tin");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
