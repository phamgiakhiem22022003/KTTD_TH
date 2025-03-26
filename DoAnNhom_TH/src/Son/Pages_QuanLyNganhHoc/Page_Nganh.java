package Pages_QuanLyNganhHoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Nganh {

	private WebDriver driver;

	private By ByNhapMaNganh = By.xpath("/html/body/div[3]/div[2]/form/div[1]/input");
	private By ByNhapTenNganh = By.xpath("/html/body/div[3]/div[2]/form/div[2]/input");
	private By ByNhapTenVietTat = By.xpath("/html/body/div[3]/div[2]/form/div[3]/input");

	private By ByChonCTDT = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span/span[1]/span/span[2]");
	private By ByChonTieuChuan = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[1]");

	// Lưu
	private By ByBTN_Luu = By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]");

	public Page_Nganh(WebDriver driver) {
		this.driver = driver;
	}

	public void NhapNoiDung(String inMaNganh, String inTenNganh, String inTenVietTat) {

		driver.findElement(ByNhapMaNganh).sendKeys(inMaNganh);
		driver.findElement(ByNhapTenNganh).sendKeys(inTenNganh);
		driver.findElement(ByNhapTenVietTat).sendKeys(inTenVietTat);
		driver.findElement(ByChonCTDT).click();
		driver.findElement(ByChonTieuChuan).click();
		
		// Lưu
		driver.findElement(ByBTN_Luu).click();
	}
	
	public void NoiDungRong(String inMaNganh, String inTenNganh, String inTenVietTat) {

		driver.findElement(ByNhapMaNganh).clear();
		driver.findElement(ByNhapTenNganh).clear();
		driver.findElement(ByNhapTenVietTat).clear();
		driver.findElement(ByChonCTDT).click();
		driver.findElement(ByChonTieuChuan).click();
		
		// Lưu
		driver.findElement(ByBTN_Luu).click();
	}

}
