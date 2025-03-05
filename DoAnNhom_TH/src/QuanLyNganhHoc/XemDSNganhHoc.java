package QuanLyNganhHoc;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class XemDSNganhHoc {
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
	public void XemDuLieu10() throws InterruptedException {
		// Chọn mục học kỳ và nghành
		WebElement hockyvanganh = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a/span"));
		hockyvanganh.click();
		WebElement chonNganh = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"));
		chonNganh.click();
		System.out.println("tiến hành kiểm thử dữ liệu hiển thị là 10"); // In ra thông điệp trước khi thực hiện kiểm
		// tra hiển thị 10 dữ liệu
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ trước đó hoàn thành

// chọn 10 dữ liệu
		WebElement click10 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[1]/div/label/select/option[1]"));
		click10.click(); // Nhấn vào lựa chọn hiển thị 10 dữ liệu trên trang

// Phân loại theo Mã Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[2]"))
				.click(); // Nhấn vào cột Mã Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Mã Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Mã Ngành

// Phân loại theo Tên Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[3]"))
				.click(); // Nhấn vào cột Tên Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Tên Ngành

// Phân loại theo Tên Viết Tắt
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[4]"))
				.click(); // Nhấn vào cột Tên Viết Tắt để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Viết Tắt thành công"); // In ra thông điệp sau khi phân loại thành công
		// theo cột Tên Viết Tắt

// Phân loại theo CTĐT
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[5]"))
				.click(); // Nhấn vào cột CTĐT để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo CTĐT thành công"); // In ra thông điệp sau khi phân loại thành công theo cột
// CTĐT

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành
		System.out.println("Đã kiểm thử thành công theo kiểu xem 10 dữ liệu"); // In ra thông điệp sau khi kiểm thử
		// thành công
		Thread.sleep(3000); // Tạm dừng chương trình trong 3 giây để chờ trước khi tiếp tục thực hiện các
// thao tác tiếp theo

	}

	@Test(priority = 2, dependsOnMethods = "XemDuLieu10")
	public void XemDuLieu25() throws InterruptedException {
		System.out.println("tiến hành kiểm thử dữ liệu hiển thị là 25"); // In ra thông điệp trước khi thực hiện kiểm
		// tra hiển thị 25 dữ liệu
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ trước đó hoàn thành

// chọn 25 dữ liệu
		WebElement click25 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[1]/div/label/select/option[2]"));
		click25.click(); // Nhấn vào lựa chọn hiển thị 25 dữ liệu trên trang

// Phân loại theo Mã Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[2]"))
				.click(); // Nhấn vào cột Mã Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Mã Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Mã Ngành

// phân loại theo Tên Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[3]"))
				.click(); // Nhấn vào cột Tên Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Tên Ngành

// Phân loại theo Tên Viết Tắt
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[4]"))
				.click(); // Nhấn vào cột Tên Viết Tắt để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Viết Tắt thành công"); // In ra thông điệp sau khi phân loại thành công
		// theo cột Tên Viết Tắt

// Phân loại theo CTĐT
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[5]"))
				.click(); // Nhấn vào cột CTĐT để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo CTĐT thành công"); // In ra thông điệp sau khi phân loại thành công theo cột
// CTĐT

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành
		System.out.println("Đã kiểm thử thành công theo kiểu xem 25 dữ liệu"); // In ra thông điệp sau khi kiểm thử
		// thành công
		Thread.sleep(3000); // Tạm dừng chương trình trong 3 giây để chờ trước khi tiếp tục thực hiện các
// thao tác tiếp theo

	}

	@Test(priority = 3, dependsOnMethods = "XemDuLieu25")
	public void XemDuLieu50() throws InterruptedException {
		System.out.println("tiến hành kiểm thử dữ liệu hiển thị là 50"); // In ra thông điệp trước khi thực hiện kiểm
		// tra hiển thị 50 dữ liệu
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ trước đó hoàn thành

// chọn 50 dữ liệu
		WebElement click50 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[1]/div/label/select/option[3]"));
		click50.click(); // Nhấn vào lựa chọn hiển thị 50 dữ liệu trên trang

// Phân loại theo Mã Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[2]"))
				.click(); // Nhấn vào cột Mã Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Mã Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Mã Ngành

// phân loại theo Tên Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[3]"))
				.click(); // Nhấn vào cột Tên Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Tên Ngành

// Phân loại theo Tên Viết Tắt
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[4]"))
				.click(); // Nhấn vào cột Tên Viết Tắt để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Viết Tắt thành công"); // In ra thông điệp sau khi phân loại thành công
		// theo cột Tên Viết Tắt

// Phân loại theo CTĐT
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[5]"))
				.click(); // Nhấn vào cột CTĐT để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo CTĐT thành công"); // In ra thông điệp sau khi phân loại thành công theo cột
// CTĐT

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành
		System.out.println("Đã kiểm thử thành công theo kiểu xem 50 dữ liệu"); // In ra thông điệp sau khi kiểm thử
		// thành công
		Thread.sleep(3000); // Tạm dừng chương trình trong 3 giây để chờ trước khi tiếp tục thực hiện các
// thao tác tiếp theo

	}

	@Test(priority = 4, dependsOnMethods = "XemDuLieu50")
	public void XemDuLieuALL() throws InterruptedException {
		System.out.println("tiến hành kiểm thử dữ liệu hiển thị là Tất Cả"); // In ra thông điệp trước khi thực hiện
		// kiểm tra hiển thị tất cả dữ liệu
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ trước đó hoàn thành

// chọn tất cả dữ liệu
		WebElement clickAll = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[1]/div/label/select/option[4]"));
		clickAll.click(); // Nhấn vào lựa chọn hiển thị tất cả dữ liệu trên trang

// Phân loại theo Mã Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[2]"))
				.click(); // Nhấn vào cột Mã Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Mã Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Mã Ngành

// phân loại theo Tên Ngành
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[3]"))
				.click(); // Nhấn vào cột Tên Ngành để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Ngành thành công"); // In ra thông điệp sau khi phân loại thành công theo
// cột Tên Ngành

// Phân loại theo Tên Viết Tắt
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[4]"))
				.click(); // Nhấn vào cột Tên Viết Tắt để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo Tên Viết Tắt thành công"); // In ra thông điệp sau khi phân loại thành công
		// theo cột Tên Viết Tắt

// Phân loại theo CTĐT
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/thead/tr/th[5]"))
				.click(); // Nhấn vào cột CTĐT để phân loại dữ liệu theo cột này
		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho việc phân loại hoàn thành
		System.out.println("Phân loại theo CTĐT thành công"); // In ra thông điệp sau khi phân loại thành công theo cột
// CTĐT

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành
		System.out.println("Đã kiểm thử thành công theo kiểu xem Tất Cả dữ liệu"); // In ra thông điệp sau khi kiểm thử
		// thành công

		Thread.sleep(3000); // Tạm dừng chương trình trong 3 giây để chờ trước khi tiếp tục thực hiện các
// thao tác tiếp theo

// Kiểm tra tìm kiếm
		System.out.println("Tiến hành tìm kiếm trên thanh tìm kiếm"); // In ra thông điệp trước khi thực hiện tìm kiếm
		// trên thanh tìm kiếm

		WebElement Timkiem = driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
		System.out.println("nhập từ khóa tìm kiếm: TTNH (Tìm Thử Ngành Học)"); // In ra thông điệp trước khi nhập từ
		// khóa tìm kiếm
		Timkiem.sendKeys("TTNH"); // Nhập từ khóa tìm kiếm vào thanh tìm kiếm

		WebElement outputMa = driver.findElement(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[2]"));
		System.out.println("Mã Ngành: " + outputMa.getText()); // In ra thông tin Mã Ngành sau khi tìm kiếm

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành

		WebElement outputTen = driver.findElement(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[3]"));
		System.out.println("Tên Ngành: " + outputTen.getText()); // In ra thông tin Tên Ngành sau khi tìm kiếm

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành

		WebElement outputTVT = driver.findElement(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]"));
		System.out.println("Tên viết tắt: " + outputTVT.getText()); // In ra thông tin Tên viết tắt sau khi tìm kiếm

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác vụ tiếp theo hoàn thành

		WebElement outputCTĐT = driver.findElement(By
				.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]"));
		System.out.println("CTĐT: " + outputCTĐT.getText()); // In ra thông tin CTĐT sau khi tìm kiếm

		Thread.sleep(2000); // Tạm dừng chương trình trong 2 giây để chờ cho các tác

	}

	@AfterTest
	public void aftertest() {
		driver.close();
	}

}
