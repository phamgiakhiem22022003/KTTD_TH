package ChucNang_ThongKe_SoGioGiangVien;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
public class AutoTest_ThongKe_SoGioGiangVienTheoNam {
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
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("thai.207ct55169@vanlanguni.vn");
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(2000);
        // Nhập mật khẩu
        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("VLU23072002");
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(10000);
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
	@Test (priority = 1)
	public void thongketheohocki() throws InterruptedException {

 // chọn vô navbar thống kê giờ giảng viên
 driver.findElement(By.xpath("(//li[@class='nav-item has-sub'])[2]")).click();
  	Thread.sleep(1000);
  	driver.findElement(By.cssSelector("a[href='/Phancong02/Statistics']")).click();	
  	Thread.sleep(1000);
  	
  	// thống kê theo năm học
  	driver.findElement(By.cssSelector("span[data-select2-id='1']")).click();
  	Thread.sleep(2000);
  	// nhập tìm kiếm là năm học
  	driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("năm học");
  	Thread.sleep(2000);
  	driver.findElement(By.cssSelector("li.select2-results__option.select2-results__option--highlighted")).click();
 // chọn năm học
  	driver.findElement(By.cssSelector("span[data-select2-id='5']")).click();
  	Thread.sleep(2000);
  	// nhập tìm kiếm là năm học
  	driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("2024 - 2025");
  	Thread.sleep(6000);
  	driver.findElement(By.cssSelector("li.select2-results__option.select2-results__option--highlighted")).click();
  	
  	// chọn ô ngành =  Tất cả sau khi tìm kiếm trong ô input
  	Thread.sleep(6000);
  	driver.findElement(By.cssSelector("span[data-select2-id='7']")).click();
  	Thread.sleep(6000);
  	driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Tất cả");
  	Thread.sleep(6000);
  	driver.findElement(By.cssSelector("li.select2-results__option.select2-results__option--highlighted")).click();
  	System.out.println("ra được bảng theo năm học");
  	// chọn vào bảng biểu
  	Thread.sleep(6000);
  	driver.findElement(By.cssSelector("a[href='#tableIcon']")).click();	
  	// nhập vào ô input mã giảng viên của thầy Phan Hồ Viết Trường
  	System.out.println("nhập vào ô input mã giảng viên của thầy Phan Hồ Viết Trường");
  	 WebElement divElementInupt = driver.findElement(By.id("tblStatistics_filter"));
  	divElementInupt.findElement(By.tagName("input")).sendKeys("2001101105");
  	Thread.sleep(6000);
  	String result = (String) driver.findElement(By.className("sorting_1")).getText();
  	
  	System.out.println("số giờ của thầy là " + result );

	}  
  
	   @AfterClass
	   public void teardown() {
	       // Đóng trình duyệt
	        driver.quit();
	   }

}

