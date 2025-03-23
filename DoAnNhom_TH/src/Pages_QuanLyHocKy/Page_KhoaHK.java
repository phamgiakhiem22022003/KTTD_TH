package Pages_QuanLyHocKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_KhoaHK {
	private WebDriver driver;

	public Page_KhoaHK (WebDriver driver) {
        this.driver = driver;
    }
	
	// Thêm học kỳ mới
    public void addNewTerm() throws InterruptedException {
    	driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys("999");
    }

    // Chọn năm bắt đầu
    public void selectYearBegins() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]")).click();
    }

    // Chọn năm kết thúc
    public void selectYearEnds() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[14]")).click();
    }

    // Chọn số tuần
    public void selectWeek() throws InterruptedException {
        WebElement week = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button"));
        for (int a = 0; a < 3; a++) {
            week.click();
            Thread.sleep(1000);
        }
    }

    // Chọn ngày
    public void selectDay() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
        Thread.sleep(1000);
        WebElement inputField = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
        inputField.clear();
        Thread.sleep(1000);
        inputField.sendKeys("2025");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[18]")).click();
    }

    // Chọn số lớp tối đa
    public void selectClassMaximum() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[1]/div/span[2]/button")).click();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[2]/div/span[2]/button"));
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            element.click();
        }
    }

    // Lưu thông tin học kỳ
    public void saveInfo() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
        Thread.sleep(2000);
    }

    // Khóa học kỳ
    public void lockTerm() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[8]/div/input")).click();
    }

}
