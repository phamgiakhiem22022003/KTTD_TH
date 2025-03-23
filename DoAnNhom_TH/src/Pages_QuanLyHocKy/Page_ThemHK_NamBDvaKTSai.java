package Pages_QuanLyHocKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_ThemHK_NamBDvaKTSai {
	 WebDriver driver;
	 
	 private By termButton = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span");
	 private By createTermButton = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button");
	 private By termInput = By.xpath("/html/body/div[3]/div[2]/form/div[1]/input");
	 private By yearBeginDropdown = By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[1]");
	 private By yearEndDropdown = By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]");
	 private By weekButton = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button");
	 private By saveButton = By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]");
	 
	 
	public Page_ThemHK_NamBDvaKTSai(WebDriver driver) {
		this.driver = driver;
	}
	 
	public void addTerm(String term) throws InterruptedException {
        driver.findElement(termButton).click();
        Thread.sleep(1000);
        driver.findElement(createTermButton).click();
        Thread.sleep(1000);
        driver.findElement(termInput).sendKeys(term);
    }
    
    public void selectYearBegins() throws InterruptedException {
        driver.findElement(yearBeginDropdown).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[13]")).click();
    }
    
    public void selectYearEnds() throws InterruptedException {
        driver.findElement(yearEndDropdown).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]")).click();
    }
    
    public void selectWeek() throws InterruptedException {
        WebElement week = driver.findElement(weekButton);
        for (int a = 0; a < 3; a++) {
            week.click();
            Thread.sleep(1000);
        }
    }
    
    public void saveTerm() {
        driver.findElement(saveButton).click();
    }

}
