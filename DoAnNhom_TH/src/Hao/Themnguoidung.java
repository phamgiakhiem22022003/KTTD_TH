package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Themnguoidung {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button/span")).click();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }
        
        WebElement magvInput = driver.findElement(By.xpath("//*[@id=\"staff_id\"]"));
        magvInput.sendKeys("teoem");
        WebElement tengvInput = driver.findElement(By.xpath("//*[@id=\"full_name\"]"));
        tengvInput.sendKeys("Nguyen Van Teo");
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.sendKeys("nguyenvanteo@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"select2-type-container\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-type-result-z8wk-TG\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-role_id-container\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-role_id-result-m05z-c0653144-928b-49bd-b98c-512c9f9391dd\"]")).click();
        
        driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"select2-type-container\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-type-result-z8wk-TG\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-role_id-container\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-role_id-result-m05z-c0653144-928b-49bd-b98c-512c9f9391dd\"]")).click();
    }


	}

