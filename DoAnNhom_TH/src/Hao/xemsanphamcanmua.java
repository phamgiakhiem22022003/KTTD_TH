package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class xemsanphamcanmua {
    public String baseUrl = "https://sneakerholicvietnam.vn";
    String driverPath = "c:\\chromedriver.exe";
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.out.println("CHẠY TRÌNH DUYỆT CHROME");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);  
    }
    @Test
    // Đăng nhập tài khoản
    public void DangNhapThanhCong() throws InterruptedException {
        WebElement loginBTN = driver.findElement(By.className("icon-user"));
        loginBTN.click();
        Thread.sleep(1000);

        WebElement loginKey = driver.findElement(By.name("username"));
        loginKey.sendKeys("phamgiakhiem22022003");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("luongbi22022003");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[1]/div/form/p[3]/button"));
        loginButton.click();
        Thread.sleep(3000);
        
        WebElement danhMuc = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div/ul/li[2]/a"));
        danhMuc.click();
        Thread.sleep(3000);
        
        WebElement hinhsanpham = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/div[1]/a/img[1]"));
        hinhsanpham.click();
        Thread.sleep(3000);
    } 
    @AfterTest
    public void afterTest() {
        driver.close();
    }
}