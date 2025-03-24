package POM_QuanLyHocKy;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyHocKy.Page_TimkiemHocKy;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_TimkiemHK {
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
	public void timkiemhocky1() throws InterruptedException {
		
		Page_TimkiemHocKy Timkiem = new Page_TimkiemHocKy(driver);
		Timkiem.TimKiem_HocKy("888");
		
		//Xem kết quả tìm kiếm
		WebElement table = driver.findElement(By.xpath("//*[@id=\"tblTerm\"]"));
		// Thực hiện kiểm tra hoc ki khong ton tai
		if (table.getText().contains("888")) {
			System.out.println("Tim thay - False");
		} else {
			System.out.println("Khong tim that - Pass");
		}
	}

	@Test(priority = 2)
	public void timkiemhocky2() throws InterruptedException {
		
		Page_TimkiemHocKy Timkiem = new Page_TimkiemHocKy(driver);
		Timkiem.TimKiem_HocKy("202");
		
		// Kiểm tra nội dung trong bảng
		WebElement table = driver.findElement(By.xpath("//*[@id=\"tblTerm\"]"));
		// Thực hiện kiểm tra hoc ki hien co
		if (table.getText().contains("202")) {
			System.out.println("Tim thay - Pass");
		} else {
			System.out.println("Khong tim that - False");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
