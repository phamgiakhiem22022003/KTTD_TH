package test;

import java.util.Random; // Import class Random từ gói java.util để sử dụng random numbers

import org.openqa.selenium.By; // Import class By từ gói org.openqa.selenium để xác định các phần tử trong trình duyệt
import org.openqa.selenium.WebDriver; // Import interface WebDriver từ gói org.openqa.selenium để tương tác với trình duyệt
import org.openqa.selenium.WebElement; // Import class WebElement từ gói org.openqa.selenium để thực hiện các hành động trên các phần tử trên trang web
import org.openqa.selenium.chrome.ChromeDriver; // Import class ChromeDriver từ gói org.openqa.selenium.chrome để tương tác với trình duyệt Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Import class ChromeOptions từ gói org.openqa.selenium.chrome để cấu hình trình duyệt Chrome
import org.testng.annotations.AfterTest; // Import annotation AfterTest từ gói org.testng.annotations để thiết lập hành động sau khi bài kiểm tra kết thúc
import org.testng.annotations.BeforeTest; // Import annotation BeforeTest từ gói org.testng.annotations để thiết lập hành động trước khi bài kiểm tra bắt đầu
import org.testng.annotations.Test; // Import annotation Test từ gói org.testng.annotations để đánh dấu phương thức kiểm tra

import io.github.bonigarcia.wdm.WebDriverManager; // Import class WebDriverManager từ gói io.github.bonigarcia.wdm để quản lý WebDriver

public class Xoahocki { // Khai báo lớp DeleteHK

	public WebDriver driver; // Khai báo biến driver kiểu WebDriver để điều khiển trình duyệt

	// Phương thức thiết lập trước mỗi bài kiểm tra (test)
	@BeforeTest
	public void setup() throws InterruptedException {
		// Thiết lập WebDriver cho Chrome
		WebDriverManager.chromedriver().setup();

		// Đường dẫn đến thư mục User Data của Chrome để sử dụng thông tin đăng nhập đã
		// lưu
		String key = "C:\\Users\\phamn\\AppData\\Local\\Google\\Chrome for Testing\\User Data";

		// Tạo đối tượng ChromeOptions để cấu hình Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + key);

		// Khởi tạo đối tượng WebDriver cho Chrome với các tùy chọn đã cấu hình
		driver = new ChromeDriver(options);

		// Mở trang web cần kiểm tra đăng nhập
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");

		// Mở rộng cửa sổ trình duyệt
		driver.manage().window().maximize();

		// Tìm và click vào phần tử có xpath là "//*[@id=\"OpenIdConnect\"]"
		WebElement in = driver.findElement(By.xpath("//*[@id=\"OpenIdConnect\"]"));
		in.click();

		// Tạm dừng chương trình trong 5 giây để đợi quá trình đăng nhập xử lý
		Thread.sleep(3000);
	}

	// Phương thức kiểm tra xóa học kỳ và nhóm môn có priority = 0
	@Test(priority = 0)
	public void HKvaN1() throws InterruptedException {
		// Tìm và click vào phần tử có xpath là
		// "/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"
		WebElement HKvaN = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		HKvaN.click();
		Thread.sleep(3000);

		// Tạo số ngẫu nhiên từ 1 đến 10 để chọn phần tử cần xóa
		Random random = new Random();
		int RandomXoaHK = random.nextInt(10) + 1;
		// Xây dựng đường dẫn xpath của phần tử cần xóa dựa trên số ngẫu nhiên
		String DeleteHK = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr["
				+ RandomXoaHK + "]/td[9]/a[2]";
		// Click vào phần tử cần xóa
		driver.findElement(By.xpath(DeleteHK)).click();
		Thread.sleep(3000);
		// Click vào nút xác nhận xóa
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]")).click();
		System.out.println("-----------------------------------------------------------------------------");
	}

	// Phương thức kiểm tra xóa học kỳ và nhóm môn có priority = 1
	@Test(priority = 1)
	public void HKvaN() throws InterruptedException {
		// Tìm và click vào phần tử có xpath là
		// "/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"
		WebElement HKvaN2 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		HKvaN2.click();
		Thread.sleep(3000);

		// Tạo số ngẫu nhiên từ 1 đến 10 để chọn phần tử cần xóa
		Random random = new Random();
		int RandomXoaHK = random.nextInt(10) + 1;
		// Xây dựng đường dẫn xpath của phần tử cần xóa dựa trên số ngẫu nhiên
		String DeleteHK = "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr["
				+ RandomXoaHK + "]/td[9]/a[2]";
		// Click vào phần tử cần xóa
		driver.findElement(By.xpath(DeleteHK)).click();
		Thread.sleep(3000);
		// Click vào nút hủy xóa
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(3000);

		// Lấy text của vị trí để biết học kỳ được chọn
		String HKBiXoa = driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr["
						+ RandomXoaHK + "]/td[1]"))
				.getText();
		System.out.println("học kỳ bạn chọn là: HK" + HKBiXoa);
		System.out.println("-----------------------------------------------------------------------------");
	}

	// Phương thức thiết lập sau mỗi bài kiểm tra (test)
	@AfterTest
	public void afterTest() throws InterruptedException {
		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);
		// Đóng trình duyệt
		driver.close();
	}
}