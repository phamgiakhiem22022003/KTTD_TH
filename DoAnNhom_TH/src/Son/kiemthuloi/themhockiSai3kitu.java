package kiemthuloi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class themhockiSai3kitu {
	static WebDriver driver;

	@BeforeClass
	public void setup() {
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
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button"))
				.click();
		Thread.sleep(1000);
		addTerm();
		selectYearBegins();
		selectYearEnds();
		selectWeek();
		selectDay();
		selectClassMaximum();
		saveInfo();

	}

//addTerm
	// Nhập quá kí tự của học kì
	public void addTerm() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("9999");
	}

//select year begins
	public void selectYearBegins() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]")).click();
	}

//select year ends
	public void selectYearEnds() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[14]")).click();
	}

//select week
	public void selectWeek() throws InterruptedException {
		WebElement week = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button"));
		for (int a = 0; a < 3; a++) {
			week.click();
			Thread.sleep(1000);
		}
	}

//select days
	public void selectDay() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input")).sendKeys("2023");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[18]")).click();
	}

//select class maximum
	public void selectClassMaximum() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[1]/div/span[2]/button")).click();
		Thread.sleep(1000);
		WebElement element = driver
				.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[2]/div/span[2]/button"));
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			element.click();
		}
	}

	public void saveInfo() {
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
	}
}
