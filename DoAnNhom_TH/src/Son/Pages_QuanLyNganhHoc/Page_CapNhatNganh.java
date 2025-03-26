package Pages_QuanLyNganhHoc;

import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_CapNhatNganh {
	private WebDriver driver;
	
	//Mở Menu Ngành
    private By majorMenu = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span");
    
    //Cập nhật Ngành
    private By majorNameInput = By.xpath("/html/body/div[3]/div[2]/form/div[2]/input");
    private By shortNameInput = By.xpath("/html/body/div[3]/div[2]/form/div[3]/input");
    private By curriculumDropdown = By.xpath("//*[@id=\"major-form\"]/div[4]/div/span[1]");
    private By curriculumOption = By.xpath("//span[contains(text(), 'Tiêu chuẩn')]");
    private By saveButton = By.xpath("//*[@id=\"major-form\"]/div[5]/button[2]");

    public Page_CapNhatNganh (WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToMajors() {
        driver.findElement(majorMenu).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
    }
    
    public void openUpdateMajorPage() throws InterruptedException {
        Random random = new Random();
        int index = random.nextInt(10) + 1;
        
        WebElement editButton = driver.findElement(By.xpath(
                "/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[" + index + "]/td[6]/a[1]"
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
        Thread.sleep(2000);
    }
    
    public void updateMajor(String name, String shortName) throws InterruptedException {
        driver.findElement(majorNameInput).clear();
        driver.findElement(majorNameInput).sendKeys(name);

        driver.findElement(shortNameInput).clear();
        driver.findElement(shortNameInput).sendKeys(shortName);

        driver.findElement(curriculumDropdown).click();
        Thread.sleep(1000);
        driver.findElement(curriculumOption).click();
    }

    public void saveChanges() {
        driver.findElement(saveButton).click();
    }

}
