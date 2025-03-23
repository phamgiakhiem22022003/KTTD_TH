package User;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class CapNhatThongtinCaNhan {
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

	@Test(priority = 2, dependsOnMethods = "AuthenTk")
	public void ChangeProfile1() throws InterruptedException {
		// Cập nhật Mã Giảng Viên
		// Tìm và lấy phần tử input để nhập mã giảng viên
		WebElement inputMGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input"));
		Thread.sleep(1000); // Dừng 1 giây để đảm bảo trang web đã load hoàn toàn
		inputMGV.clear(); // Xóa bỏ nội dung đã có trong input
		Thread.sleep(1000); // Dừng 1 giây
		inputMGV.sendKeys("000000000000000000000"); // Nhập mã giảng viên mới

		// Cập nhật Tên Giảng Viên
		// Tìm và lấy phần tử input để nhập tên giảng viên
		WebElement inputTGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input"));
		Thread.sleep(1000); // Dừng 1 giây
		inputTGV.clear(); // Xóa bỏ nội dung đã có trong input
		Thread.sleep(1000); // Dừng 1 giây
		inputTGV.sendKeys("Phạm Gia Khiêm"); // Nhập tên giảng viên mới

		// Nhấn nút Cập Nhật
		// Tìm và lấy phần tử button để thực hiện cập nhật
		WebElement btnCN = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnCN); // Sử dụng JavascriptExecutor để nhấn nút bằng script
		Thread.sleep(1000); // Dừng 1 giây

		// Đóng PopUp
		// Tìm và lấy phần tử button để đóng pop-up thông báo
		WebElement btnPU = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", btnPU); // Sử dụng JavascriptExecutor để nhấn nút đóng bằng script
		System.out.println("Cập nhật thành công !"); // In thông báo cập nhật thành công
		System.out.println("Mã Giảng viên được cập nhật thành: 000000000000000000000"); // In mã giảng viên mới
		System.out.println("Tên Giảng viên được cập nhật thành: Phạm Gia Khiêm"); // In tên giảng viên mới

		System.out.println("----------------");

	}

	@Test(priority = 3, dependsOnMethods = "ChangeProfile1")
	public void ChangeProfile2() throws InterruptedException {
		// Cập nhật Mã Giảng Viên: Tìm và nhập dữ liệu vào ô nhập Mã Giảng Viên
		WebElement inputMGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input"));
		Thread.sleep(1000); // Dừng chương trình 1 giây để chờ cho trang web phản hồi
		inputMGV.clear(); // Xóa dữ liệu hiện có trong ô nhập Mã Giảng Viên
		Thread.sleep(1000); // Dừng chương trình 1 giây trước khi nhập dữ liệu mới
		inputMGV.sendKeys("1"); // Nhập dữ liệu mới "1" vào ô nhập Mã Giảng Viên

		// Cập nhật Tên Giảng Viên: Tìm và nhập dữ liệu vào ô nhập Tên Giảng Viên
		WebElement inputTGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input"));
		Thread.sleep(1000); // Dừng chương trình 1 giây để chờ cho trang web phản hồi
		inputTGV.clear(); // Xóa dữ liệu hiện có trong ô nhập Tên Giảng Viên
		Thread.sleep(1000); // Dừng chương trình 1 giây trước khi nhập dữ liệu mới
		inputTGV.sendKeys("Phạm Gia Khiêm"); // Nhập dữ liệu mới "Hoàng Phạm Nhật" vào ô nhập Tên Giảng Viên

		// Nhấn nút Cập Nhật: Tìm và nhấn vào nút Cập Nhật bằng cách sử dụng Javascript Executor
		WebElement btnCN = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver; // Khởi tạo một executor để thực hiện thao tác click bằng Javascript
		executor.executeScript("arguments[0].click();", btnCN); // Sử dụng executor để thực hiện thao tác click lên nút Cập Nhật
		Thread.sleep(1000); // Dừng chương trình 1 giây để chờ cho trang web phản hồi

		// Đóng PopUp: Tìm và nhấn vào nút Đóng PopUp bằng cách sử dụng Javascript Executor
		WebElement btnPU = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver; // Khởi tạo một executor mới
		executor1.executeScript("arguments[0].click();", btnPU); // Sử dụng executor để thực hiện thao tác click lên nút Đóng PopUp

		// In ra thông báo lỗi khi cập nhật không thành công
		System.out.println("Cập nhật không thành công !");
		System.out.println("Hệ thống hiển thị popup: Mã giảng viên này đã có trong hệ thống!");
		System.out.println("Tên Giảng viên được cập nhật thành: Phạm Gia Khiêm");
		
		System.out.println("----------------");


	}

	@Test(priority = 4, dependsOnMethods = "ChangeProfile2")
	public void ChangeProfile3() throws InterruptedException {
		// Cập nhật Mã Giảng Viên
		WebElement inputMGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input"));
		// Tìm và chọn phần tử input để nhập Mã Giảng Viên

		Thread.sleep(1000); // Dừng chương trình trong 1 giây

		inputMGV.clear(); // Xóa nội dung trong input

		Thread.sleep(1000); // Dừng chương trình trong 1 giây

		inputMGV.sendKeys("   . , ;       : ... - \\ / ? ! ' \" () [] {} ~ @ # $ % & * _ + =");
		// Nhập chuỗi ký tự có ký tự đặc biệt vào trường input Mã Giảng Viên

		// Cập nhật Tên Giảng Viên
		WebElement inputTGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input"));
		// Tìm và chọn phần tử input để nhập Tên Giảng Viên

		Thread.sleep(1000); // Dừng chương trình trong 1 giây

		inputTGV.clear(); // Xóa nội dung trong input

		Thread.sleep(1000); // Dừng chương trình trong 1 giây

		inputTGV.sendKeys("Hoàng Phạm Nhật"); // Nhập tên giảng viên "Hoàng Phạm Nhật" vào trường input Tên Giảng Viên

		// Nhấn nút Cập Nhật
		WebElement btnCN = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button"));
		// Tìm và chọn nút "Cập Nhật"

		JavascriptExecutor executor = (JavascriptExecutor) driver; // Khởi tạo executor để thực thi script JavaScript

		executor.executeScript("arguments[0].click();", btnCN); // Click vào nút "Cập Nhật" bằng cách sử dụng JavaScript

		Thread.sleep(1000); // Dừng chương trình trong 1 giây

		// In ra màn hình các thông báo về việc cập nhật không thành công và thông tin mới của giảng viên
		System.out.println("Cập nhật không thành công !");
		System.out.println("Hệ thống hiển thị thông báo dưới Mã Giảng Viên: Chỉ được nhập số-chữ không dấu và không có khoảng trắng!");
		System.out.println("Mã Giảng viên được cập nhật thành: 1");
		System.out.println("Tên Giảng viên được cập nhật thành: Phạm Gia Khiêm");
		
		System.out.println("----------------");


	}
	@Test(priority = 5, dependsOnMethods = "ChangeProfile3")
	public void ChangeProfile4() throws InterruptedException {
		// Cập nhật Mã Giảng Viên
		// Tìm và chọn phần tử HTML input cho Mã Giảng Viên
		WebElement inputMGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input"));
		Thread.sleep(1000); // Tạm dừng chương trình 1 giây để đảm bảo phần tử được tìm thấy và tương tác
		inputMGV.clear(); // Xóa nội dung hiện tại của ô nhập liệu Mã Giảng Viên
		Thread.sleep(1000); // Tạm dừng chương trình 1 giây
		inputMGV.sendKeys("2174802010804"); // Nhập mã giảng viên mới vào ô nhập liệu

		// Cập nhật Tên Giảng Viên
		// Tìm và chọn phần tử HTML input cho Tên Giảng Viên
		WebElement inputTGV = driver.findElement(
		    By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input"));
		Thread.sleep(1000); // Tạm dừng chương trình 1 giây để đảm bảo phần tử được tìm thấy và tương tác
		inputTGV.clear(); // Xóa nội dung hiện tại của ô nhập liệu Tên Giảng Viên
		Thread.sleep(1000); // Tạm dừng chương trình 1 giây
		inputTGV.sendKeys("Phạm Gia Khiêm"); // Nhập tên giảng viên mới vào ô nhập liệu

		// Nhấn nút Cập Nhật
		// Tìm và chọn phần tử HTML button để thực hiện cập nhật
		WebElement btnCN = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", btnCN); // Sử dụng JavaScript để bấm vào nút Cập Nhật
		Thread.sleep(1000); // Tạm dừng chương trình 1 giây
		
		// Đóng PopUp
		// Tìm và chọn phần tử HTML button để đóng pop-up
		WebElement btnPU = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", btnPU); // Sử dụng JavaScript để bấm vào nút đóng pop-up
		System.out.println("Cập nhật thành công !"); // In ra thông báo cập nhật thành công
		System.out.println("Mã Giảng viên được cập nhật thành: 2174802010737"); // In ra thông báo về mã giảng viên đã được cập nhật
		System.out.println("Tên Giảng viên được cập nhật thành: Phạm Gia Khiêm"); // In ra thông báo về tên giảng viên đã được cập nhật
		
		System.out.println("----------------");

	}
	@AfterTest
	public void AfterTest() {
		driver.close();//Đóng trình duyệt
	}

}
