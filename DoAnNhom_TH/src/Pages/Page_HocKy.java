package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_HocKy {
	private WebDriver driver;
	
	// addterm
	private By ByNhap_HK = By.xpath("/html/body/div[3]/div[2]/form/div[1]/input");

	// năm bắt đầu
	private By Bydropdown_namBĐ = By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span/span[1]/span/span[1]");
	private By ByChon_namBĐ = By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/span[2]/span/span[2]/ul/li[10]");
	
	// năm kết thúc
	private By Bydropdown_namKT = By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span/span[1]/span/span[1]");
	private By ByChon_namKT = By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/span[2]/span/span[2]/ul/li[14]");

	// tuần bắt đầu
	private By ByBTN_Week = By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/button");
	
	// ngày bắt đầu
	private By ByDropDown_Ngay = By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]");
	private By ByXoa_Ngay = By.xpath("/html/body/div[4]/div[1]/div/div/div/input");
	private By ByNhap_Nam = By.xpath("/html/body/div[4]/div[1]/div/div/div/input");
	private By ByChon_Ngay = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[18]");

	// tiết và lớp tối đa
	private By ByBTN_Tiet = By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[1]/div/span[2]/button");
	private By ByBTN_Lop = By.xpath("/html/body/div[3]/div[2]/form/div[6]/div[2]/div/span[2]/button");
	
	
	//Lưu
	private By ByBTN_Luu = By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]");
	
	
	public Page_HocKy (WebDriver driver) {
		this.driver = driver;
	}
	
	public void NhapNoiDung (String inHK, String inNam) {
		
		//addterm
		driver.findElement(ByNhap_HK).sendKeys(inHK);
		
		//nam bắt đầu
		driver.findElement(Bydropdown_namBĐ).click();
		driver.findElement(ByChon_namBĐ).click();
		
		//năm kết thúc
		driver.findElement(Bydropdown_namKT).click();
		driver.findElement(ByChon_namKT).click();
		
		//Chọn Tuần
		driver.findElement(ByBTN_Week).click();
		
		//Chọn ngày bắt đầu
		driver.findElement(ByDropDown_Ngay).click();
		driver.findElement(ByXoa_Ngay).clear();
		driver.findElement(ByNhap_Nam).sendKeys(inNam);
		driver.findElement(ByChon_Ngay).click();
		
		//Chọn tiết lớp
		driver.findElement(ByBTN_Tiet).click();
		driver.findElement(ByBTN_Lop).click();
		
		//Lưu
		driver.findElement(ByBTN_Luu).click();
	}
	
	public void XoaNoiDung(String inHK, String inNam) {

		// addterm
		driver.findElement(ByNhap_HK).clear();

		// nam bắt đầu
		driver.findElement(Bydropdown_namBĐ).click();
		driver.findElement(ByChon_namBĐ).click();

		// năm kết thúc
		driver.findElement(Bydropdown_namKT).click();
		driver.findElement(ByChon_namKT).click();

		// Chọn Tuần
		driver.findElement(ByBTN_Week).click();

		// Chọn ngày bắt đầu
		driver.findElement(ByDropDown_Ngay).click();
		driver.findElement(ByXoa_Ngay).clear();
		driver.findElement(ByNhap_Nam).clear();
		driver.findElement(ByChon_Ngay).click();

		// Chọn tiết lớp
		driver.findElement(ByBTN_Tiet).click();
		driver.findElement(ByBTN_Lop).click();

		// Lưu
		driver.findElement(ByBTN_Luu).click();

	}
}
