package test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Capnhatuyquyentk {
    public WebDriver driver;

    // Phương thức thiết lập trước mỗi bài kiểm tra (test)
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập WebDriver cho Chrome
        WebDriverManager.chromedriver().setup();

        // Đường dẫn đến thư mục User Data của Chrome để sử dụng thông tin đăng nhập đã lưu
        String key = "C:\\Users\\phamn\\AppData\\Local\\Google\\Chrome for Testing\\User Data";

        // Tạo đối tượng ChromeOptions để cấu hình Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + key);

        // Khởi tạo đối tượng WebDriver cho Chrome với các tùy chọn đã cấu hình
        driver = new ChromeDriver(options);

        // Mở trang web cần kiểm tra đăng nhập
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");

        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Tìm và click vào phần tử có xpath là "//*[@id=\"OpenIdConnect\"]"
        WebElement in = driver.findElement(By.xpath("//*[@id=\"OpenIdConnect\"]"));
        in.click();

        // Tạm dừng chương trình trong 5 giây để đợi quá trình đăng nhập xử lý
        Thread.sleep(3000);
    }

    @Test
    public void find() throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000);

        // Tìm và click vào phần tử có xpath là "//*[@id=\"main-menu-navigation\"]/li[3]/a/span"
        WebElement ND = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a/span"));
        ND.click();
        Thread.sleep(2000);

        // Tìm và nhập "ABCD" vào ô tìm kiếm có xpath là "//*[@id=\"tblUser_filter\"]/label/input"
        WebElement sendKey = driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input"));
        sendKey.sendKeys("ABCD");
        Thread.sleep(2000);

        // Tìm và click vào nút "Sửa" có xpath là "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[7]/a[1]"
        WebElement Sua = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[7]/a[1]"));
        Sua.click();
        Thread.sleep(5000);

        // Click vào dropdown có xpath là "/html/body/div[3]/div[2]/form/div[5]/div/span/span[1]/span/span[1]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span/span[1]/span/span[1]")).click();
        Thread.sleep(2000);

        // Random một số từ 1 đến 4
        Random so = new Random();
        int Num = so.nextInt(4) + 1;

        // Click vào một phần tử trong dropdown có xpath là "/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li["+Num+"]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li[" + Num + "]")).click();
        Thread.sleep(2000);

        // Click vào nút "Lưu" có xpath là "/html/body/div[3]/div[2]/form/div[7]/button[2]"
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);

        // Lấy và in ra thông tin đã cập nhật từ phần tử có xpath là "/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[6]/span"
        WebElement titlElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr/td[6]/span"));
        String titlesString = titlElement.getText();
        System.out.println("Đã cập nhật người dùng thành: " + titlesString);

        // Đóng trình duyệt
        driver.close();
    }
}
