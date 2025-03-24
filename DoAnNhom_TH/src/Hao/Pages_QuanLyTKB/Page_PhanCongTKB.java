package Pages_QuanLyTKB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_PhanCongTKB {

	WebDriver driver;

	// Constructor
	public Page_PhanCongTKB(WebDriver driver) {
		this.driver = driver;
	}

	public void MucPhanCong() throws InterruptedException {
		// Nhấp vào dropdown thời khóa biểu
		WebElement timetableDropdown = driver
				.findElement(By.xpath("//a[contains(@href, '#') and .//i[@class='feather feather-clock']]"));
		timetableDropdown.click();
		Thread.sleep(2000);

		// Nhấp vào liên kết nhập thời khoá biểu
		WebElement importTimetableLink = driver
				.findElement(By.xpath("//a[contains(@href, '/Phancong02/Timetable/Assign')]"));
		importTimetableLink.click();
		Thread.sleep(3000);

		// Chọn kỳ học
		WebElement termDropdown = driver.findElement(By.id("select2-term-container"));
		termDropdown.click();
		Thread.sleep(2000);

		// Tìm kiếm và chọn kỳ học
		WebElement termSearchBox = driver.findElement(By.xpath("//input[@aria-controls='select2-term-results']"));
		termSearchBox.sendKeys("420");
		Thread.sleep(1000);

		// Giả lập việc nhấn phím Enter
		termSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// Chọn ngành
		WebElement majorDropdown = driver.findElement(By.id("select2-major-container"));
		majorDropdown.click();
		Thread.sleep(1000);

		// Tìm kiếm và chọn ngành
		WebElement majorSearchBox = driver.findElement(By.xpath("//input[@aria-controls='select2-major-results']"));
		majorSearchBox.sendKeys("Công nghệ 420");
		Thread.sleep(1000);
		// Giả lập việc nhấn phím Enter
		majorSearchBox.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
	}

	public void PhanCongGiangVien() throws InterruptedException {
		// Tìm thấy mục chứa biểu tượng chuyển đổi
		WebElement navItem = driver.findElement(By.cssSelector("li.nav-item.nav-toggle"));

		// Nhấp vào mục điều hướng
		navItem.click();
		Thread.sleep(3000);

		// Khởi tạo đối tượng JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Cuộn trình duyệt xuống cuối trang
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(000); // Wait for 1 second (if needed)

		// Tìm thấy bảng chứa các phần tử
		WebElement table = driver
				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]"));

		// Khởi tạo biến boolean để kiểm tra xem còn phần tử "Chưa phân" nào hiển thị
		// trên trang hay không
		boolean chuaPhanFound = true;

		// Vòng lặp chính để kiểm tra và xử lý các phần tử "Chưa phân"
		while (chuaPhanFound) {
			// Lấy tất cả các phần tử có class "btn assign-card text-nowrap my-25 p-25
			// btn-secondary unassigned-theory" trong bảng
			List<WebElement> chuaPhanElements = table.findElements(
					By.cssSelector("button.btn.assign-card.text-nowrap.my-25.p-25.btn-secondary.unassigned-theory"));

			// Kiểm tra xem có phần tử "Chưa phân" hiển thị hay không
			if (!chuaPhanElements.isEmpty()) {
				// Chọn từng phần tử "Chưa phân" để xử lý
				for (WebElement chuaPhanElement : chuaPhanElements) {
					// Thực hiện click 3 lần vào phần tử đã chọn
					for (int i = 0; i < 3; i++) {
						chuaPhanElement.click();
						Thread.sleep(1000); // Chờ 2 giây trước khi thực hiện click lần tiếp theo
					}

					// Tìm phần tử "Chưa phân công" để hiển thị dropdown
					WebElement chuaPhanCongElement = driver
							.findElement(By.xpath("//span[contains(text(), 'Chưa phân')]"));
					chuaPhanCongElement.click();
					Thread.sleep(3000);

					// Chờ cho dropdown xuất hiện
					WebElement dropdownMenu = null;
					long startTime = System.currentTimeMillis();
					long timeout = 20000; // 20 giây

					while ((System.currentTimeMillis() - startTime) < timeout) {
						try {
							dropdownMenu = driver.findElement(By.xpath("//ul[@class='select2-results__options']"));
							if (dropdownMenu.isDisplayed()) {
								break;
							}
						} catch (Exception e) {
							// Nếu phần tử chưa xuất hiện, tiếp tục vòng lặp
						}
						Thread.sleep(500); // Chờ 500ms trước khi kiểm tra lại
					}

					// Kiểm tra nếu dropdownMenu vẫn null sau khi hết thời gian chờ
					if (dropdownMenu == null) {
						throw new RuntimeException("Dropdown menu không xuất hiện sau 20 giây");
					}

					Thread.sleep(1000);

					while (true) {
						// Quét trong dropdown
						List<WebElement> dropdownOptions = dropdownMenu.findElements(By.tagName("li"));

						// Khởi tạo biến để kiểm tra xem có giá trị false nào không
						boolean foundFalseOption = false;

						// Lặp qua các tùy chọn và kiểm tra xem có giá trị false nào không
						for (WebElement option : dropdownOptions) {
							String optionText = option.getAttribute("aria-selected");
							if (optionText.equals("false")) {
								foundFalseOption = true;
								break; // Thoát khỏi vòng lặp ngay khi tìm thấy giá trị false
							}
						}

						// Nếu không có giá trị false nào, thoát khỏi vòng lặp
						if (!foundFalseOption) {
							System.out.println("Không còn phần tử 'Chưa phân' nào hiển thị trên trang.");
							chuaPhanFound = false; // Đặt biến kiểm tra thành false để thoát khỏi vòng lặp lớn
							break;
						}

						// Nếu có giá trị false, chọn một giá trị false và tiếp tục xử lý
						WebElement randomFalseOption = dropdownOptions.get(0); // Chọn giá trị đầu tiên
						Thread.sleep(1000);

						// Chờ cho phần tử trở nên tương tác được
						long startTime2 = System.currentTimeMillis();
						long timeout2 = 20000; // 20 giây

						while ((System.currentTimeMillis() - startTime2) < timeout2) {
							try {
								if (randomFalseOption.isDisplayed() && randomFalseOption.isEnabled()) {
									break;
								}
							} catch (Exception e) {
								// Bỏ qua nếu phần tử chưa có trên DOM
							}
							Thread.sleep(500); // Chờ 500ms trước khi kiểm tra lại
						}

						// Nếu hết thời gian chờ mà phần tử vẫn chưa khả dụng, báo lỗi
						if (!randomFalseOption.isDisplayed() || !randomFalseOption.isEnabled()) {
							throw new RuntimeException("Phần tử không thể tương tác sau 20 giây");
						}

						// Chọn giá trị false
						randomFalseOption.click();
						Thread.sleep(1000);

						// Sau khi chọn xong, ấn nút lưu
						WebElement saveButton1 = driver.findElement(By.xpath("//button[@aria-label='Assign']"));
						saveButton1.click();
						Thread.sleep(1000);

						// Kiểm tra popup nếu có thì ấn OK
						List<WebElement> okButtons = driver.findElements(By.xpath(
								"//div[@class='swal2-popup swal2-modal swal2-icon-error swal2-show']//button[@class='swal2-confirm btn btn-primary']"));

						// Kiểm tra xem danh sách phần tử có rỗng hay không
						if (!okButtons.isEmpty()) {
							// Click vào nút OK
							okButtons.get(0).click();
						} else {
							// Nếu không tìm thấy phần tử, bỏ qua các bước tiếp theo và in ra thông báo
							System.out.println("Không cần ấn OK" + randomFalseOption.getText());
						}
					}
				}
			} else {
				// Nếu không tìm thấy phần tử "Chưa phân" nào, thoát khỏi vòng lặp
				System.out.println("Không còn phần tử 'Chưa phân' nào hiển thị trên trang.");
				chuaPhanFound = false; // Đặt biến kiểm tra thành false để thoát khỏi vòng lặp lớn
			}
		}
	}

}
