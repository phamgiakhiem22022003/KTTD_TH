package POM_QuanLyHocKy;

import org.testng.annotations.Test;

import Khiem.Authen;
import Pages_QuanLyHocKy.Page_NgayBĐRong;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TC_NgayBĐRong {
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
    public void addTerm() throws InterruptedException {
		Page_NgayBĐRong addterm = new Page_NgayBĐRong(driver);
		addterm.openTermPage();
		addterm.createTerm();
    }

    @Test(priority = 3, dependsOnMethods = "addTerm")
    public void selectYearBegins() throws InterruptedException {
    	Page_NgayBĐRong NamBĐ = new Page_NgayBĐRong(driver);
    	NamBĐ.selectYearBegins();
    }

    @Test(priority = 4, dependsOnMethods = "selectYearBegins")
    public void selectYearEnds() throws InterruptedException {
    	Page_NgayBĐRong NamKetThuc = new Page_NgayBĐRong(driver);
    	NamKetThuc.selectYearEnds();
    }

    @Test(priority = 5, dependsOnMethods = "selectYearEnds")
    public void selectWeek() throws InterruptedException {
    	Page_NgayBĐRong ChonTuan = new Page_NgayBĐRong(driver);
    	ChonTuan.selectWeek();
    }

    @Test(priority = 6, dependsOnMethods = "selectWeek")
    public void selectClassMaximum() throws InterruptedException {
    	Page_NgayBĐRong ChonToiDa = new Page_NgayBĐRong(driver);
    	ChonToiDa.selectClassMaximum();
    }

    @Test(priority = 7, dependsOnMethods = "selectClassMaximum")
    public void saveInfo() {
    	Page_NgayBĐRong save = new Page_NgayBĐRong(driver);
    	save.saveInfo();
    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
