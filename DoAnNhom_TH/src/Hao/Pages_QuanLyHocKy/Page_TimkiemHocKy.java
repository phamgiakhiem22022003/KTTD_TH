package Pages_QuanLyHocKy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_TimkiemHocKy {
	
	private WebDriver driver;
	
	//Bấm menu học kỳ và ngành
	private By ByBTN = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a/span");
	
	// nhap hoc ky muon tim kiem
	private By Nhap_TimKiem = By.xpath("//*[@id=\"tblTerm_filter\"]/label/input");
	
	public Page_TimkiemHocKy (WebDriver driver) {
		this.driver = driver;
	}
	
	public void TimKiem_HocKy(String inTimKiem) {

		//Bấm menu Học Kỳ và ngành
		driver.findElement(ByBTN).click();
		
		//Tìm kiếm học kỳ
		driver.findElement(Nhap_TimKiem).sendKeys(inTimKiem);
		
	}
	
}
