package POM_QuanLyHocKy;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyHocKy.Page_KhoaHK;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_KhoaHK {
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
    public void AddTerm() throws InterruptedException {
        Page_KhoaHK addnewterm = new Page_KhoaHK(driver);
        addnewterm.addNewTerm();
    }

    @Test(priority = 2, dependsOnMethods = "AddTerm")
    public void SelectYearBegins() throws InterruptedException {
    	Page_KhoaHK chonnamBatDau = new Page_KhoaHK(driver);
    	chonnamBatDau.selectYearBegins();
    }

    @Test(priority = 3, dependsOnMethods = "SelectYearBegins")
    public void SelectYearEnds() throws InterruptedException {
    	Page_KhoaHK chonnamKetThuc = new Page_KhoaHK(driver);
    	chonnamKetThuc.selectYearEnds();
    }

    @Test(priority = 4, dependsOnMethods = "SelectYearEnds")
    public void SelectWeek() throws InterruptedException {
    	Page_KhoaHK ChonTuan = new Page_KhoaHK(driver);
    	ChonTuan.selectWeek();
    }

    @Test(priority = 5, dependsOnMethods = "SelectWeek")
    public void SelectDay() throws InterruptedException {
    	Page_KhoaHK ChonNgay = new Page_KhoaHK(driver);
    	ChonNgay.selectDay();
    }

    @Test(priority = 6, dependsOnMethods = "SelectDay")
    public void SelectClassMaximum() throws InterruptedException {
    	Page_KhoaHK TietToiDa = new Page_KhoaHK(driver);
    	TietToiDa.selectClassMaximum();
    }

    @Test(priority = 7, dependsOnMethods = "SelectClassMaximum")
    public void SaveInfo() throws InterruptedException {
    	Page_KhoaHK Save = new Page_KhoaHK(driver);
    	Save.saveInfo();
    }

    @Test(priority = 8, dependsOnMethods = "SaveInfo")
    public void LockTerm() {
    	Page_KhoaHK KhoaHocKy = new Page_KhoaHK(driver);
    	KhoaHocKy.lockTerm();   
    }
	
    @AfterTest
	public void afterTest() {
		driver.close();
	}

}
