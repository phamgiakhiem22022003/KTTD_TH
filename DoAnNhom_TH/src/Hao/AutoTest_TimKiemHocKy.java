package ChucNang_QuanLyHocKy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
public class AutoTest_TimKiemHocKy {
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
	public void timkiemhocky1() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("888");// nhap hoc ky muon tim kiem
	  // Kiểm tra nội dung trong bảng
	        WebElement table = driver.findElement(By.xpath("//*[@id=\"tblTerm\"]"));
	        // Thực hiện kiểm tra hoc ki khong ton tai 
	        if (table.getText().contains("888")) {
	            System.out.println("Tim thay - False");
	        } else {
	            System.out.println("Khong tim thay - Pass");
	        }
        }
	@Test (priority = 2)
	public void timkiemhocky2() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("202");// nhap hoc ky muon tim kiem
	  // Kiểm tra nội dung trong bảng
	        WebElement table = driver.findElement(By.xpath("//*[@id=\"tblTerm\"]"));
	        // Thực hiện kiểm tra hoc ki hien co 
	        if (table.getText().contains("202")) {
	            System.out.println("Tim thay - Pass");
	        } else {
	            System.out.println("Khong tim thay - False");
	        }
        }
	   @AfterClass
	   public void teardown() {
	       // Đóng trình duyệt
	        driver.quit();
	   }
}

