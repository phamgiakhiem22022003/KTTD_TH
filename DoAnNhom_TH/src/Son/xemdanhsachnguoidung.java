package Son;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class xemdanhsachnguoidung {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        String key = "C:\\Users\\ASUS\\AppData\\Local\\Google\\Chrome for Testing\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + key);
        driver = new ChromeDriver(options);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        // Maximize the window
        driver.manage().window().maximize();
        
    }
    @Test(priority = 1)
    public void Authen() throws InterruptedException {
    	Authen.AuthenTK(driver);
    	Thread.sleep(2000);
    }
    
    @Test (priority = 2, dependsOnMethods = "Authen")
    public void user() throws InterruptedException {
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a")).click();
    	Thread.sleep(2000);
    	//chọn loại giảng viên
    	 WebElement selectElement = driver.findElement(By.id("UserType"));
    	 Thread.sleep(2000);
    	 
         //chọn giảng viên cơ hữu
         Select select = new Select(selectElement);
         select.selectByVisibleText("Cơ hữu");
         
         //Chọn role
         WebElement selectElement1 = driver.findElement(By.id("UserRole"));
         Thread.sleep(2000);

         //chọn BCN khoa
         Select select1 = new Select(selectElement1);
         select1.selectByVisibleText("BCN khoa");
         
         //chọn hiển thị
         WebElement selectElement2 = driver.findElement(By.name("tblUser_length"));
         Thread.sleep(2000);

         //Chọn số dòng hiển thị 
         Select select2 = new Select(selectElement2);
         select2.selectByVisibleText("25");
    	
    	//columns
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/label/div/span[1]/span[1]/span")).click();
    	Thread.sleep(2000);
    	// delete column
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/label/div/span[2]/span/span/ul/li[4]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[5]")).click();
    }
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
