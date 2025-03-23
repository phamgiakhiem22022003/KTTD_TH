package QuanLyThongKe;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class XemThongKe {
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
	
	@Test(priority = 2)
	public void thongke() throws InterruptedException {
        // Click vào thống kê số giờ quy đổi
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();

        // Chờ cho danh sách menu xuất hiện
        Thread.sleep(2000);

        // Lấy danh sách các mục menu
        WebElement ulElement = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Kiểm tra xem danh sách có ít nhất 2 mục
        if (liElements.size() >= 2) {
            // Click vào mục thứ 2
            WebElement secondLiElement = liElements.get(1);
            Actions actions = new Actions(driver);
            actions.moveToElement(secondLiElement).click().perform();
            Thread.sleep(2000);
        }

        // Chọn thống kê theo
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[2]")).click();
        Thread.sleep(2000);

        // Chọn thống kê theo năm học
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[2]")).click();
        Thread.sleep(2000);

        // Chọn năm học 2024-2025
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li[9]")).click();
        Thread.sleep(2000);

        // Chọn ngành công nghệ thông tin
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li[2]")).click();
        Thread.sleep(2000);

        // Xem theo ca giảng
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[1]/div[2]/div/input")).click();
    }


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
