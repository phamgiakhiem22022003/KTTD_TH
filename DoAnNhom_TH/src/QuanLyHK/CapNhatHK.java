package QuanLyHK;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class CapNhatHK {
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
	    public void updateHocKy() throws InterruptedException {
	        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
	        Thread.sleep(2000);

	        // button cập nhật
	        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[9]/a[1]")).click();
	        Thread.sleep(2000);
	        // select năm bắt đầu
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[2]")).click();
	        Thread.sleep(2000);
	        // select năm 2023
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]")).click();
	        Thread.sleep(2000);
	        // select năm kết thúc
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[2]")).click();
	        Thread.sleep(2000);
	        // select năm 2024
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[10]")).click();
	        Thread.sleep(2000);
	        
	    }
	    @Test(priority = 2)
	    public void batDau() throws InterruptedException {
	        // chọn tuần bắt đầu
	        WebElement week = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button"));
	        for (int a = 0; a < 3; a++) {
	            week.click();
	            Thread.sleep(1000);
	            // chọn ngày tháng năm bắt đầu
	            WebElement YearStart = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]"));
	            YearStart.click();
	            Thread.sleep(2000);
	            // xóa năm cũ
	            driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input")).clear();
	            Thread.sleep(2000);
	            // chọn năm 2023
	            WebElement Get2023 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
	            Get2023.sendKeys("2023");
	            Thread.sleep(2000);
	            // chon ngày
	            WebElement Day = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[15]"));
	            Day.click();
	            Thread.sleep(3000);
//	            System.out.println(YearStart.getText());
//	            System.out.println(Get2023.getText());
//	            System.out.println(Day.getText());
	            
	        }
	    }
	    @Test(priority = 3)
	    public void selectClassMaximum() throws InterruptedException {
	        // Tiết tối đa
	        Thread.sleep(1000);
	        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[1]/div/span[1]/button"));
	        for (int i = 0; i < 3; i++) {
	            Thread.sleep(1000);
	            element.click();
	        }

	        // Tuần tối đa
	        WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[2]/div/span[2]/button"));
	        for (int i = 0; i < 3; i++) {
	            Thread.sleep(1000);
	            element1.click();
	        }
	        
	       WebElement Luu = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]"));
	       Luu.click();
    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
