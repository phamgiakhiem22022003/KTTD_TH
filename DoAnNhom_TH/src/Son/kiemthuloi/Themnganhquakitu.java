package kiemthuloi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Themnganhquakitu {
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
    @Test
    public void login() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button")).click();
        Thread.sleep(2000);
        nganh();
        
       }
    public static void nganh() throws InterruptedException {
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
    	Thread.sleep(2000);
   
        //select ngành
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
    	Thread.sleep(2000);
    	
    	//add ngành mới
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
    	Thread.sleep(2000);
    	
    	//nhập mã ngành ( nhập chữ và có khoảng trắng)
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("NguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuyNguyenTuanHuy");
    	Thread.sleep(2000);
    	
    	//nhập tên ngành
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("Công nghệ thông tin");
    	Thread.sleep(2000);
    	
    	//nhập tên viết tắt
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("CNTT");
    	Thread.sleep(2000);
    	
    	//Arrow chọn CTĐT
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span/span[1]/span/span[2]")).click();
    	Thread.sleep(2000);
    	
    	//Chọn tiêu chuẩn
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[1]")).click();
    	Thread.sleep(2000);
    	
    	//Lưu
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
    }
}
