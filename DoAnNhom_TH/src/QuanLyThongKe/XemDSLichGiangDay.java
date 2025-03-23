package QuanLyThongKe;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class XemDSLichGiangDay {
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
	public void lichgiangday() throws InterruptedException{
    	//chọn thống kê
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
    	Thread.sleep(2000);
    	//chọn thời khóa biểu
    	driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Statistics/Timetable");
    	
    	Thread.sleep(2000);
    	//chọn học kỳ
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span/span[1]/span/span[2]")).click();
    	Thread.sleep(2000);
    	//chọn học kỳ 
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]")).click();
    	Thread.sleep(10000);
    	//chọn giảng viên
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[1]/span[1]/span/ul/li/input")).click();
    	Thread.sleep(2000);
    	//chọn tất cả
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/span[2]/span/div/button[1]/i")).click();
    	Thread.sleep(2000);
    	//chọn Loại giảng viên
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[1]/span[1]/span/ul/li/input")).click();
    	Thread.sleep(2000);
    	//chọn cơ hữu
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/span[2]/span/span/ul/li[1]")).click();
    	Thread.sleep(2000);
    	//chọn lọc ca giảng
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span/span[1]/span/ul/li[6]/input")).click();
    	Thread.sleep(2000);
    	//tắt ca 4 ca 5
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li[4]")).click();
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[5]/span[2]/span/span/ul/li[5]")).click();
    	Thread.sleep(2000);
    	//lọc thứ
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span/span[1]/span/ul/li[8]/input")).click();
    	Thread.sleep(2000);
    	//Tắt chủ nhật
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div[6]/span[2]/span/span/ul/li[7]")).click();
    	
    	Thread.sleep(2000);
    	//chọn thử
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[4]/button")).click();
    }

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
