package QuanLyNganhHoc;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TimKiemNganhHoc {
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
    public void xemdanhsach() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
    Thread.sleep(5000);

    }
	
    @Test(priority = 2, dependsOnMethods = "xemdanhsach")
    public void timkiem() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("9999");
    Thread.sleep(2000);
    String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Major";
    String actualUrl = driver.getCurrentUrl();
    if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
        System.out.println("Hiển Thị Danh Sách Ngành- PASS");
    }
        else {
            System.out.println("Không Hiển Thị - Thất bại");
            }

    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
