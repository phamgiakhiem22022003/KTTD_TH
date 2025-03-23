package POM_QuanLyNganhHoc;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyNganhHoc.Page_XemDanhSachNganh;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_XemDanhSachNganhHoc {
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
	
	@Test (priority = 1)
	public void VaoMenuNganh () {
		Page_XemDanhSachNganh MenuNganh = new Page_XemDanhSachNganh(driver);
		MenuNganh.VaoMenu();
	}
	
	@Test (priority = 2)
	public void xemdanhsach_hienthi10 () throws InterruptedException {
		Page_XemDanhSachNganh xem10hienthi = new Page_XemDanhSachNganh(driver);
		xem10hienthi.XemDuLieu10();
		
	}
	
	@Test (priority = 3)
	public void xemdanhsach_hienthi25 () throws InterruptedException {
		Page_XemDanhSachNganh xem25hienthi = new Page_XemDanhSachNganh(driver);
		xem25hienthi.XemDulieu25();
	}
	
	@Test (priority = 4)
	public void xemdanhsach_hienthi50 () throws InterruptedException {
		Page_XemDanhSachNganh xem50hienthi = new Page_XemDanhSachNganh(driver);
		xem50hienthi.XemDuLieu50();
	}
	
	@Test (priority = 5)
	public void xemdanhsach_hienthiTatCa() throws InterruptedException {
		Page_XemDanhSachNganh xemAllhienthi = new Page_XemDanhSachNganh(driver);
		xemAllhienthi.XemDuLieuAll();
		xemAllhienthi.KiemtraTimkiem();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
