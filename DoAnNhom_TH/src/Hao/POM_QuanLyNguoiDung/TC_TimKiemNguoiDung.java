package POM_QuanLyNguoiDung;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyNguoiDung.Page_TimKiemNguoiDung;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_TimKiemNguoiDung {
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
    public void SearchUser_Exists() throws InterruptedException {
		Page_TimKiemNguoiDung userPage = new Page_TimKiemNguoiDung(driver);
        userPage.openUserPage();
        boolean isFound = userPage.searchUser("Thành Hảo");
        assertTrue(isFound, "User should be found but is not.");
    }

    @Test(priority = 2)
    public void SearchUser_NotExists() throws InterruptedException {
    	
    	Page_TimKiemNguoiDung userPage = new Page_TimKiemNguoiDung(driver);
        boolean isFound = userPage.searchUser("Con chim nho nhỏ");
        assertFalse(isFound, "User should not be found but appears in results.");
    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
