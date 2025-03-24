package Pages_QuanLyNganhHoc;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_XoaNganhHoc {
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;
    private Random random;

    public Page_XoaNganhHoc (WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.random = new Random();
    }
    
    public void goToNganhHocPage() throws InterruptedException {
        WebElement hocKyTab = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span"));
        hocKyTab.click();
        Thread.sleep(2000);

        WebElement nganhHocTab = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a"));
        nganhHocTab.click();
        Thread.sleep(2000);
    }
    
    public void selectRandomNganh() throws InterruptedException {
        int stt = random.nextInt(10) + 1;
        Thread.sleep(2000);

        WebElement nganhElement = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt + "]/td[6]/a[2]"));
        jsExecutor.executeScript("arguments[0].click();", nganhElement);

        Thread.sleep(5000);
    }

    public void deleteRandomNganh() throws InterruptedException {
        Thread.sleep(2000);

        WebElement settingsTab = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[2]/div[2]/div/ul/li[5]/a"));
        jsExecutor.executeScript("arguments[0].click();", settingsTab);
        Thread.sleep(2000);

        int stt = random.nextInt(10) + 1;
        WebElement deleteElement = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt + "]/td[6]/a[2]"));
        jsExecutor.executeScript("arguments[0].click();", deleteElement);
        Thread.sleep(3000);

        WebElement confirmDelete = driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr[1]/td[6]/a[2]"));
        jsExecutor.executeScript("arguments[0].click();", confirmDelete);

        // Lấy mã ngành & tên ngành đã chọn
        String maNganh = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt + "]/td[2]")).getText();
        System.out.println("Mã Ngành đã chọn là: " + maNganh);

        String tenNganh = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + stt + "]/td[3]")).getText();
        System.out.println("Tên Ngành đã chọn là: " + tenNganh);
    }

}
