package DonGia_HeSo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
public class AutoTest_DonGia_CTDTTC {
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
		public void thaydoidongia() throws InterruptedException{
			driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span/span[1]/span/span[2]/b")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div/div/span[2]/span/span[1]/input")).sendKeys("2027 - 2028");// nhap hoc ky muon tim kiem
			
			Thread.sleep(2000);
		  // Kiểm tra nội dung trong bảng
		        WebElement table = driver.findElement(By.xpath("//*[@id=\"priceCoefficientDiv\"]"));
		  //Chinh sua don gia
		        driver.findElement(By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys("22222");// nhap so muon sua
				driver.findElement(By.xpath("//*[@id=\"unitprice-form\"]/div[3]/button[2]")).click();
				Thread.sleep(2000);
				
		        // Thực hiện kiểm tra 
		        if (table.getText().contains("")) {
		            System.out.println("Tim thay - False");
		        } else {
		            System.out.println("Khong tim thay - Pass");
		        }
	        }
		@Test (priority = 2)
		public void xoadongia() throws InterruptedException{
			driver.findElement(By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()=\"Xoá\"]\r\n"
					+ "")).click();
			Thread.sleep(2000);
		  // Kiểm tra nội dung trong bảng
		        WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));
		        // Thực hiện kiểm tra hoc ki hien co 
		        if (table.getText().contains("")) {
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

