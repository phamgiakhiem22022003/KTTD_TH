package ChucNang_ThongKe_SoGioGiangVien;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoTest_ThongKe_SoGioGiangVienTheoHocKy {
	public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void setUp()throws InterruptedException {
		System.out.println("CHAY TRINH DUYET CHROME");
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test(priority = 0)
    public void loginTest() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
	
		driver.findElement(By.xpath("//*[@id=\"OpenIdConnect\"]")).click();
		Thread.sleep(2000);
        // Nhập tên người dùng
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("thai.207ct55169@vanlanguni.vn");// Nhập tài khoản
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(2000);
        // Nhập mật khẩu
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("VLU23072002"); // Nhập password
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(15000);
    
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
//        Thread.sleep(10000);
		// thao tác tay để xác nhận 2 lớp 
       	String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
  		String actualUrl = driver.getCurrentUrl();
  		if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
  		System.out.println("Đăng nhập thành công tài khoản VLU - PASS");
  	}
    	else {
    		System.out.println("Tài khoản không đúng - Thất bại");
    		
    	}
	}
	@Test(priority = 1)
    public void xembieudo() throws InterruptedException{
		//Bấm vào phần tử Thống kê bên thanh bên trái
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(1000);
		//Bấm vào phần tử ở trong dropdown Thống kê
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[1]/a")).click();
		//
		Thread.sleep(1000);
		//Bấm bào ô Học kỳ
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]/span")).click();
		Thread.sleep(1000);
		//Nhập học kỳ muốn tìm kiếm
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys("998");
		Thread.sleep(1000);
		//Chọn vào học kỳ mà mình muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		//Bấm vào ô Ngành
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
		Thread.sleep(1000);
		//Nhập ngành muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys("Tất cả");
		Thread.sleep(1000);
		//Chọn vào ngành mà mình muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li[1]")).click();
		//Bấm vào ô Loại giảng viên
		driver.findElement(By.xpath("//*[@id=\"select2-lecturerType-container\"]")).click();
		Thread.sleep(1000);
		//Nhập Loại giảng viên muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li[1]")).click();
//		Thread.sleep(1000);
//		//Sau khi nhập Tất cả sẽ click vô chữ đó để load bản biểu đồ
//		driver.findElement(By.xpath("//*[@id=\"select2-lecturerType-result-8vz8--1\"]")).click();
		Thread.sleep(3000);
		//Bấm vào phần tử Bảng biểu để xem thông tin chi tiết
		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
		Thread.sleep(3000);
		//Bấm vào phần tử Chi tiết để xem thông tin chi tiết
		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
		//Kiểm tra xem có kiểm thử thành công hay không
		boolean isElementPresent = driver.findElements(By.xpath("//*[@id=\"statisticsDiv\"]/h4")).size() > 0;

		if (isElementPresent) {
		    System.out.println("Kiểm thử chức năng thất bại");
		} else {
		    System.out.println("Kiểm thử chức năng thành công");
		}
	}
	@Test(priority = 2)
    public void xembieudo_rong() throws InterruptedException{
		//
		Thread.sleep(1000);
		//Bấm bào ô Học kỳ
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]/span")).click();
		Thread.sleep(1000);
		//Nhập học kỳ muốn tìm kiếm
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys("921");
		Thread.sleep(1000);
		//Chọn vào học kỳ mà mình muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[2]/ul/li")).click();
		//Bấm vào ô Ngành
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"select2-major-container\"]")).click();
		Thread.sleep(1000);
		//Nhập ngành muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input")).sendKeys("Kiến trúc");
		Thread.sleep(1000);
		//Chọn vào ngành mà mình muốn tìm kiếm
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[2]/ul/li")).click();
		//Bấm vào ô Loại giảng viên
		driver.findElement(By.xpath("//*[@id=\"select2-lecturerType-container\"]")).click();
		Thread.sleep(1000);
		//Nhập Loại giảng viên muốn tìm kiếm
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[2]/ul/li[1]")).click();
		Thread.sleep(1000);
		//Hàm kiểm tra xem có hiện thông tin lên màng hình hay không
		boolean isElementPresent = driver.findElements(By.xpath("//*[@id=\"statisticsDiv\"]/h4")).size() > 0;
		
		if (isElementPresent) {
		    System.out.println("Kiểm thử chức năng thất bại");
		} else {
		    System.out.println("Kiểm thử chức năng thành công");
		}
	}
	@AfterClass
	 public void teardown() {
	    // Đóng trình duyệt
	    driver.quit();
	 }

}
