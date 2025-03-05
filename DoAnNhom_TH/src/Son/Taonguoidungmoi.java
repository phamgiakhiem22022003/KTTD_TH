package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Taonguoidungmoi {
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
        user();}
    @Test
    public void user() throws InterruptedException{
    	//click người dùng
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a")).click();
    	//click thêm người dùng
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
    	//nhập mã giảng viên
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("2222222222");
    	//nhập tên giảng viên
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input")).sendKeys("Nguyễn Huy");
    	//Nhập email
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).sendKeys("loc.2173401151306@vanlanguni.vn");
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
    	driver.quit();
    }}
