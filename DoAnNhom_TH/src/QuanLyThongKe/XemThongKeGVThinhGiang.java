package QuanLyThongKe;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class XemThongKeGVThinhGiang {
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

	@Test(priority = 2) // Đánh dấu phương thức kiểm thử này có độ ưu tiên là 0
	public void View() throws InterruptedException { // Phương thức kiểm thử View
		// Hệ thống chuyển vào mục thống kê và chọn giảng viên thỉnh giảng
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[3]/a")).click();

		
		System.out.println("----------------------------------"); // In ra dấu gạch ngang
		System.out.println("Bắt đầu kiểm thử Thống kê giờ giảng viên với số học kỳ đã chọn là:"); // In ra thông báo bắt
																									// đầu kiểm thử với
																									// số học kỳ đã chọn
		WebElement ChonHK = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul/li")); // Tìm
																															// và
																															// gán
																															// phần
																															// tử
																															// ChonHK
		ChonHK.click(); // Click vào phần tử ChonHK
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/div/button[2]"))
				.click(); // Click vào nút
		Thread.sleep(1000); // Tạm ngừng chương trình trong 1000ms
		//
		System.out.println("Bỏ chọn tất cả "); // In ra thông báo bỏ chọn tất cả
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/button"))
				.click(); // Click vào nút
		System.out.println("hệ thống hiển thị popup: Bạn chưa chọn học kỳ để thống kê!"); // In ra thông báo hệ thống
																							// hiển thị popup
		System.out.println("----------------------------------"); // In ra dấu gạch ngang
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms
	}

	@Test(priority = 3) // Đánh dấu phương thức kiểm thử này có độ ưu tiên là 1
	public void View1() throws InterruptedException { // Phương thức kiểm thử View1
		System.out.println("Bắt đầu kiểm thử Thống kê giờ giảng viên với số học kỳ đã chọn là: "); // In ra thông báo
																									// bắt đầu kiểm thử
																									// với số học kỳ đã
																									// chọn
		System.out.println("Chọn tất cả "); // In ra thông báo chọn tất cả
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms
		WebElement ChonHK = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul/li")); // Tìm
																															// và
																															// gán
																															// phần
																															// tử
																															// ChonHK
		ChonHK.click(); // Click vào phần tử ChonHK
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"term\"]/option")); // Tìm tất cả các phần tử
																								// có id là term và gán
																								// vào danh sách
																								// elements
		int numberOfElements = elements.size(); // Gán số lượng phần tử trong danh sách elements vào biến
												// numberOfElements
		System.out.println(numberOfElements); // In ra số lượng phần tử elements
		// Chọn số học kỳ
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/div/button[1]"))
				.click(); // Click vào nút
		Thread.sleep(1000); // Tạm ngừng chương trình trong 1000ms
		// chọn bấm nút thống kê
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/button"))
				.click(); // Click vào nút
		Thread.sleep(3000); // Tạm ngừng chương trình trong 3000ms
		// In ra thông báo lỗi
		WebElement GetTB = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]")); // Tìm và gán phần tử GetTB
		System.out.println("Hệ thống hiển thị PopUp thông báo: " + GetTB.getText()); // In ra thông báo hệ thống hiển
																						// thị PopUp
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click(); // Click vào nút
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms
		System.out.println("----------------------------------"); // In ra dấu gạch ngang
		Thread.sleep(3000); // Tạm ngừng chương trình trong 3000ms
	}

	@Test(priority = 4) // Đánh dấu phương thức kiểm thử này có độ ưu tiên là 2
	public void View2() throws InterruptedException { // Phương thức kiểm thử View2
		System.out.println("Bắt đầu kiểm thử Thống kê giờ giảng viên với số học kỳ đã chọn là: "); // In ra thông báo
																									// bắt đầu kiểm thử
																									// với số học kỳ đã
																									// chọn
		System.out.println("Chọn 10 HK bất kỳ "); // In ra thông báo chọn 10 học kỳ bất kỳ
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms

		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul"))
				.click(); // Click vào phần tử
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/div/button[2]"))
				.click(); // Click vào nút
		Thread.sleep(2000); // Tạm ngừng chương trình trong 2000ms
		WebElement ChonHK = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/ul/li")); // Tìm
																															// và
																															// gán
																															// phần
																															// tử
																															// ChonHK
		System.out.println("học kỳ được chọn là: "); // In ra thông báo học kỳ được chọn là
		ChonHK.click(); // Click vào phần tử ChonHK

		// Chọn số học kỳ
		// Random từ đây
		// Ran1
		Thread.sleep(2000);
		Random RanND1 = new Random();
		int stt = RanND1.nextInt(1) + 9;
		
		int stt1 = RanND1.nextInt(11)+9;
		// Ran2
		Random RanND2 = new Random();
		int stt2 = RanND2.nextInt(21)+9;
		// Ran3
		Random RanND3 = new Random();
		int stt3 = RanND3.nextInt(31)+9;
		// Ran4
		Random RanND4 = new Random();
		int stt4 = RanND4.nextInt(41)+9;

		

		// Chọn các học kỳ
		Thread.sleep(3000);
		WebElement hk1 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span/ul/li["
						+ stt1 + "]"));
		hk1.click();
		System.out.println(hk1.getText());
		WebElement hk2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span/ul/li["
						+ stt2 + "]"));
		hk2.click();
		System.out.println(hk2.getText());
		WebElement hk3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span/ul/li["
						+ stt3 + "]"));
		hk3.click();
		System.out.println(hk3.getText());
		WebElement hk4 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span/ul/li["
						+ stt4 + "]"));
		hk4.click();
		System.out.println(hk4.getText());
		
		// Chọn xong rồi đóng
		Thread.sleep(5000);
		ChonHK.click();

		// chọn bấm nút thống kê
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/button"))
				.click();
		Thread.sleep(3000);
		// chọn số liệu thống kê là tất cả
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label/select"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/label/select/option[4]"))
				.click();

		Thread.sleep(2000);
		System.out.println("----------------------------------");
		Thread.sleep(2000);
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
