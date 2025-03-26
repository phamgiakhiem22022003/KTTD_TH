package Pages_QuanLyTKB;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page_ExportVaImport_TKB {
	
	WebDriver driver;
	//Chọn Menu
    private By menuThoiKhoaBieu = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/a");
    
    //Thời Khóa Biểu
    private By arrowChonHocKy = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span/span[1]/span/span[2]");
    private By chonHocKy = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[1]/div/span[2]/span/span[2]/ul/li[1]");
    private By arrowNganh = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span/span[1]/span/span[2]");
    private By chonNganh = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[1]/div[2]/div/span[2]/span/span[2]/ul/li[1]");
    private By importButton = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[2]/div");

    public Page_ExportVaImport_TKB(WebDriver driver) {
        this.driver = driver;
    }

    public void clickThoiKhoaBieu() {
        driver.findElement(menuThoiKhoaBieu).click();
    }
    
    public void importTKB() throws InterruptedException, AWTException {
    	WebElement ulElement = driver.findElement(By.xpath("(//ul[@class='menu-content'])"));
		WebElement firstLiElement = ulElement.findElement(By.tagName("li"));
		Actions actions = new Actions(driver);
		actions.moveToElement(firstLiElement).click().perform();
		Thread.sleep(2000);

        driver.findElement(arrowChonHocKy).click();
        Thread.sleep(2000);
        driver.findElement(chonHocKy).click();
        Thread.sleep(2000);

        driver.findElement(arrowNganh).click();
        Thread.sleep(2000);
        driver.findElement(chonNganh).click();
        Thread.sleep(2000);

        driver.findElement(importButton).click();
        Thread.sleep(2000);

        // Sử dụng Robot để tải file lên
        Robot robot = new Robot();
        StringSelection ss = new StringSelection("C:\\Users\\Admin\\Downloads\\CNTT UIS-ThoiKhoaBieu_TieuChuan_Mau.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }

}
