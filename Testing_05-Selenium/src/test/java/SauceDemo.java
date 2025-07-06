import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SauceDemo {

    public static void main(String[] args) {
        // Yêu cầu viết chương trình automation tìm đến trang SauceDemo
        // bắt locator của username, password và nhập dữ liệu, click nút login đăng nhập

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Khởi tạo trình duyệt chrome
        WebDriver driver = new ChromeDriver();

        // Mở full screen
        driver.manage().window().maximize();


        try {
            driver.get("https://www.saucedemo.com/");
            // đợi cho màn hình load lên rồi thực hiện tiếp công việc
            // wait trong 5 giây để load màn hình
            Thread.sleep(5000);

            // Thực hiện bắt các locator
            // Tìm ô username và password
//            WebElement username = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
//            WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
//            // Tìm nút login vào click chọn
//            WebElement login = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));

            // Cách tìm locator nhanh hơn sử dụng By.id hoặc By.name
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement login = driver.findElement(By.id("login-button"));

            // Nhập dữ liệu cho các element
            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");

            Thread.sleep(5000);



            // Click chọn
            login.click();

            System.out.println("Đăng nhập thành công");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
