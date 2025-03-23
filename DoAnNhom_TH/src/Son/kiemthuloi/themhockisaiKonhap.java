package kiemthuloi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class themhockisaiKonhap {
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
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(1000);
     
        saveInfo();
        
        
        
    }

    public static void saveInfo() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
    }
    
    
}

