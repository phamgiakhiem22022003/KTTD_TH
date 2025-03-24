package Pages_QuanLyNguoiDung;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_TimKiemNguoiDung {
	WebDriver driver;
	
    private By userMenu = By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span");
    private By searchField = By.xpath("//*[@id=\"tblUser_filter\"]/label/input");
    private By resultTable = By.xpath("/html/body/div[2]/div[2]");

    public Page_TimKiemNguoiDung (WebDriver driver) {
        this.driver = driver;
    }

    public void openUserPage() throws InterruptedException {
        driver.findElement(userMenu).click();
        Thread.sleep(2000);
    }

    public boolean searchUser(String userName) throws InterruptedException {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(userName);
        Thread.sleep(2000);

        WebElement table = driver.findElement(resultTable);
        return table.getText().contains(userName);
    }

}
