package Pages_QuanLyHocKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_CapNhatHocKy {

	private WebDriver driver;

	private By menuHocKy = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a");
	private By btnCapNhat = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[9]/a[1]");

	private By selectNamBatDau = By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[2]");
	private By option2023 = By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]");

	private By selectNamKetThuc = By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[2]");
	private By option2024 = By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[10]");

	private By btnLuu = By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]");

	public Page_CapNhatHocKy(WebDriver driver) {
		this.driver = driver;
	}

	public void capNhatHocKy() throws InterruptedException {
		driver.findElement(menuHocKy).click();
		Thread.sleep(2000);

		driver.findElement(btnCapNhat).click();
		Thread.sleep(2000);

		driver.findElement(selectNamBatDau).click();
		Thread.sleep(1000);
		driver.findElement(option2023).click();
		Thread.sleep(1000);

		driver.findElement(selectNamKetThuc).click();
		Thread.sleep(1000);
		driver.findElement(option2024).click();
		Thread.sleep(1000);
	}

	public void luuCapNhat() {
		driver.findElement(btnLuu).click();
	}

}
