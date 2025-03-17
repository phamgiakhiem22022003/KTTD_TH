package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewCartTest {
    public static void main(String[] args) {
        System.out.println("🚀 Mở trình duyệt Chrome...");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); // Cập nhật đường dẫn chính xác

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // **Truy cập trang đăng nhập**
            driver.get("https://sneakerholicvietnam.vn/my-account/");
            System.out.println("🔑 Đang thực hiện đăng nhập...");

            // **Nhập tài khoản & mật khẩu**
            WebElement userField = driver.findElement(By.id("username"));
            userField.sendKeys("phamgiakhiem22022003");

            WebElement passField = driver.findElement(By.id("password"));
            passField.sendKeys("luongbi22022003");

            // **Nhấn nút Đăng nhập**
            WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
            loginBtn.click();

            // **Chờ trang chuyển hướng đến trang tài khoản**
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.urlContains("/my-account/"));
            System.out.println("✅ Đăng nhập thành công!");

            // **Truy cập giỏ hàng**
            System.out.println("🛒 Đang mở trang giỏ hàng...");
            driver.get("https://sneakerholicvietnam.vn/cart-2/");

            // **Chờ sản phẩm trong giỏ hàng hiển thị**
            List<WebElement> cartItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//td[@class='product-name']//a")
            ));

            // **In ra tất cả sản phẩm trong giỏ hàng**
            if (cartItems.isEmpty()) {
                System.out.println("Giỏ hàng của bạn hiện tại đang trống.");
            } else {
                System.out.println("✅ Các sản phẩm trong giỏ hàng:");
                for (WebElement item : cartItems) {
                    System.out.println("- " + item.getText());
                }
            }

        } catch (Exception e) {
            System.out.println("⚠ Lỗi: " + e.getMessage());
        } finally {
            // **Đóng trình duyệt**
            System.out.println("🛑 Đóng trình duyệt...");
            driver.quit();
        }
    }
}
