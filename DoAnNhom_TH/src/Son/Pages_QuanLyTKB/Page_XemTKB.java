package Pages_QuanLyTKB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindActiveElement;

public class Page_XemTKB {
	
	WebDriver driver;
	
	private By tkbMenu = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/a/span");
	private By xemTKB = By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[3]/a");
	
	private By ClickHocKy = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]/span");
	private By InputHocKy = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[1]/span[1]/input[1]");
	private By ChonHocKy = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[2]/ul/li");
	
	private By ClickGiangVien = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[1]/span[1]/span[1]");
	private By InputGiangVien = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/span[2]/span[1]/span[1]/input[1]");
	private By ChonGiangVien = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[2]/ul/li");
	
	private By ClickTuan = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]");
	private By InputTuan = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[1]/input[1]");
	private By ChonTuan = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]/span[1]/span[2]/ul[1]/li[1]");

	
    // Constructor
    public Page_XemTKB (WebDriver driver) {
        this.driver = driver;
    }

    // Chọn mục "Thời Khóa Biểu"
    public void navigateToSchedule() throws InterruptedException {
    	driver.findElement(tkbMenu).click();
        Thread.sleep(2000);
        driver.findElement(xemTKB).click();
        Thread.sleep(2000);
    }

    //Chọn Học Kỳ
    public void ChoiceHocKy (String inHK) {
    	driver.findElement(ClickHocKy).click();
    	driver.findElement(InputHocKy).sendKeys(inHK);
    	driver.findElement(ChonHocKy).click();
    }
    
  //Chọn Tên Giảng Viên
    public void ChoiceGiangVien (String inGV) {
    	driver.findElement(ClickGiangVien).click();
    	driver.findElement(InputGiangVien).sendKeys(inGV);
    	driver.findElement(ChonGiangVien).click();
    	
    }
    
  //Chọn Tuần
    public void ChoiceTuan (String inTuan) {
    	driver.findElement(ClickTuan).click();
    	driver.findElement(InputTuan).sendKeys(inTuan);
    	driver.findElement(ChonTuan).click();
    	
    }

}
