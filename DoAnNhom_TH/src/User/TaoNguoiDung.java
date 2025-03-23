package User;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TaoNguoiDung {
	public String baseUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "c:\\chromedriver.exe";
	public WebDriver driver;
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();

      // Đường dẫn đến thư mục User Data của Chrome để sử dụng thông tin đăng nhập đã lưu
      String key = "C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data";

      // Tạo đối tượng ChromeOptions để cấu hình Chrome
      ChromeOptions options = new ChromeOptions();
      options.addArguments("user-data-dir=" + key);

      // Khởi tạo đối tượng WebDriver cho Chrome với các tùy chọn đã cấu hình
      driver = new ChromeDriver(options);
      driver.get(baseUrl);

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
  
  @Test (priority = 2, dependsOnMethods = "AuthenTk")
  public void user() throws InterruptedException{
  	//click người dùng
  	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a")).click();
  	//click thêm người dùng
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
  	
  	//nhập mã giảng viên
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("22022003");
  	//nhập tên giảng viên
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("Phạm Khiêm");
  	//Nhập email
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("khiem.2174802010737@vanlanguni.vn");
  	//click arrow của loại giảng viên
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span/span[1]/span/span[2]")).click();
  	//Chọn thỉnh giảng
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[2]")).click();
  	//click arrow chọn role
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span/span[1]/span/span[2]")).click();
  	//chọn role
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li[2]")).click();
  	//Lưu
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
  }
  

  @AfterTest
  public void afterTest() {
	  driver.close(); 
  }

}
