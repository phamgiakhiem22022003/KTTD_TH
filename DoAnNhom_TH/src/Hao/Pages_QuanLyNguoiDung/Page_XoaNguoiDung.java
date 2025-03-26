package Pages_QuanLyNguoiDung;

import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_XoaNguoiDung {
	WebDriver driver;

    public Page_XoaNguoiDung (WebDriver driver) {
        this.driver = driver;
    }

    public void openUserManagement() throws InterruptedException {
        WebElement userMenu = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span"));
        userMenu.click();
        Thread.sleep(2000);
    }

    public String selectRandomUser() throws InterruptedException {
        Random random = new Random();
        int randomRow = random.nextInt(10) + 1;
        Thread.sleep(2000);

        WebElement deleteButton = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + randomRow + "]/td[7]/a[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
        Thread.sleep(3000);

        return UserInfo (randomRow);
    }

    public String UserInfo (int row) {
        String userName = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + row + "]/td[3]")).getText();
        String userId = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + row + "]/td[2]")).getText();
        return "Giảng viên: " + userName + ", Mã: " + userId;
    }
    
    public void openDeletedUserTab() throws InterruptedException {
        WebElement deletedUserTab = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[5]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletedUserTab);
        Thread.sleep(2000);
    }

    public String deleteRandomUser() throws InterruptedException {
        Random random = new Random();
        int randomRow = random.nextInt(10) + 1;
        Thread.sleep(2000);

        WebElement deleteButton = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + randomRow + "]/td[7]/a[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
        Thread.sleep(3000);

        WebElement confirmDelete = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmDelete);
        Thread.sleep(2000);

        return getUserInfo(randomRow);
    }

    private String getUserInfo(int row) {
        String userName = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + row + "]/td[3]")).getText();
        String userId = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[" + row + "]/td[2]")).getText();
        return "Xoá giảng viên: " + userName + ", Mã: " + userId;
    }

}
