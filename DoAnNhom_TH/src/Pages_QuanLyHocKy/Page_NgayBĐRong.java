package Pages_QuanLyHocKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_NgayBĐRong {
	
	 WebDriver driver;

	    public Page_NgayBĐRong (WebDriver driver) {
	        this.driver = driver;
	    }

	    public void openTermPage() throws InterruptedException {
	        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
	        Thread.sleep(1000);
	    }

	    public void createTerm() throws InterruptedException {
	        driver.findElement(By.xpath(
	                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button"))
	                .click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("999");
	    }

	    public void selectYearBegins() throws InterruptedException {
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[1]")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]")).click();
	    }

	    public void selectYearEnds() throws InterruptedException {
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[14]")).click();
	    }

	    public void selectWeek() throws InterruptedException {
	        WebElement week = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button"));
	        for (int a = 0; a < 3; a++) {
	            week.click();
	            Thread.sleep(1000);
	        }
	    }

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
