package User;

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

public class TimkiemTKNDung {
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

	@Test (priority = 2, dependsOnMethods = "AuthenTk")
	public void timkiemnguoidung1() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Thành Hảo");// nhap ten nguoi dung muon tim kiem
	  // Kiểm tra nội dung trong bảng
	        WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));
	        Thread.sleep(2000);
	        // Thực hiện kiểm tra nguoi dung khong ton tai 
	        if (table.getText().contains("Thành Hảo")) {
	            System.out.println("Tim thay - False");
	        } else {
	            System.out.println("Khong tim thay - Pass");
	        }
        }
	@Test (priority = 3, dependsOnMethods = "timkiemnguoidung1")
	public void timkiemnguoidung2() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Con chim nho nhỏ");// nhap ten nguoi dung muon tim kiem
	  // Kiểm tra nội dung trong bảng
	        WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));
	        Thread.sleep(2000);
	        // Thực hiện kiểm tra nguoi dung khong ton tai
	        if (table.getText().contains("Con chim nho nhỏ")) {
	            System.out.println("Tim thay - False");
	        } else {
	            System.out.println("Khong tim thay - Pass");
	        }
        }


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
