package User;

import org.testng.annotations.Test;

import Khiem.Authen;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

//import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class XemHS_User {
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
  public void XemdanhSach() throws InterruptedException, AWTException {

	  driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/a/span")).click();
  	//chọn hồ sơ
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
  	//click mã giảng viên và sửa
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input")).clear();
  	//nhập mã mới
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[1]/input")).sendKeys("22022003");
  	//click tên giảng viên và sửa
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input")).clear();
  	//Nhập tên mới
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/div[2]/input")).sendKeys("Gia Khiêm");
  	
  	
 
  	//click cập nhật
 	Thread.sleep(2000);
 	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div[2]/div[1]/div/form/button")).click();
    Thread.sleep(2000);
    Robot robot = new Robot();

 
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000);

  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
