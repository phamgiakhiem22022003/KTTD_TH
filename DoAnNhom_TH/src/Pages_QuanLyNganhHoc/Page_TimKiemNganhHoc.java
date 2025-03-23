package Pages_QuanLyNganhHoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_TimKiemNganhHoc {
	
	WebDriver driver;
	
	public Page_TimKiemNganhHoc (WebDriver driver) {
        this.driver = driver;
    }
	
	// Điều hướng đến danh sách ngành học
    public void goToMajorList() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(5000);
    }

    // Tìm kiếm ngành học
    public boolean searchMajor(String inTuKhoaTimKiem) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys(inTuKhoaTimKiem);
        Thread.sleep(2000);

        String expectedUrl = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/Major";
        return driver.getCurrentUrl().equalsIgnoreCase(expectedUrl);
    }
}
