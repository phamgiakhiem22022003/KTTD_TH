package User;
import Khiem.Authen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class CapNhajtNDUyQuyen {
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
	@Test (priority = 1)
	  public void AuthenTk() throws InterruptedException {
	      // Gọi phương thức đăng nhập từ class Authen
	      Authen.AuthenTK(driver);
	      Thread.sleep(2000);
	 }
	@Test
    public void find() throws InterruptedException {
        // TODO Auto-generated method stub
        
        
      //click người dùng
      	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a")).click();
      	Thread.sleep(2000);
      	
        // Tìm và nhập "ABCD" vào ô tìm kiếm có xpath là "//*[@id=\"tblUser_filter\"]/label/input"
        WebElement sendKey = driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input"));
        sendKey.sendKeys("ABCD");
        Thread.sleep(2000);

        // Tìm và click vào nút "Sửa" có xpath là "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[7]/a[1]"
        WebElement Sua = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[7]/a[1]"));
        Sua.click();
        Thread.sleep(5000);

        // Click vào dropdown có xpath là "/html/body/div[3]/div[2]/form/div[5]/div/span/span[1]/span/span[1]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span/span[1]/span/span[1]")).click();
        Thread.sleep(2000);

        // Random một số từ 1 đến 4
        Random so = new Random();
        int Num = so.nextInt(4) + 1;

        // Click vào một phần tử trong dropdown có xpath là "/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li["+Num+"]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li[" + Num + "]")).click();
        Thread.sleep(2000);

        // Click vào nút "Lưu" có xpath là "/html/body/div[3]/div[2]/form/div[7]/button[2]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);

        // Lấy và in ra thông tin đã cập nhật từ phần tử có xpath là "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[6]/span"
        WebElement titlElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[6]/span"));
        String titlesString = titlElement.getText();
        System.out.println("Đã cập nhật người dùng thành: " + titlesString);

        // Đóng trình duyệt
        driver.close();
    }
}

