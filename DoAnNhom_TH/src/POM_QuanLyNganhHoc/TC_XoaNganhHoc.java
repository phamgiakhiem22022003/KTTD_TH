package POM_QuanLyNganhHoc;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyNganhHoc.Page_XoaNganhHoc;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_XoaNganhHoc {
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
    public void GoToNganhHoc() throws InterruptedException {
		Page_XoaNganhHoc TrangNganhHoc = new Page_XoaNganhHoc(driver);
		TrangNganhHoc.goToNganhHocPage();
    }

    @Test(priority = 2, dependsOnMethods = "GoToNganhHoc")
    public void SelectAndDeleteNganh() throws InterruptedException {
    	Page_XoaNganhHoc XoaNganhHoc = new Page_XoaNganhHoc(driver);
    	XoaNganhHoc.selectRandomNganh();
    	XoaNganhHoc.deleteRandomNganh();
    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
