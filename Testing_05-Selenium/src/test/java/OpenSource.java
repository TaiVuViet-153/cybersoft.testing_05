import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TransferQueue;

public class OpenSource {
    public static void main(String[] args) {
        // Yêu cầu: viết chương trình automation tìm đến trang opensource
        // và lấy ra ô username, password và button login

        // setup chromdriver
        WebDriverManager.chromedriver().setup();

        // khởi tạo trình duyệt chrome
        WebDriver driver = new ChromeDriver();

        // mở fullscreen
        driver.manage().window().maximize();

        // wait thay thế bằng thread.sleep() -> bọc vô bằng try catch
        // vì khi trang web được load thì cần khoảng thời gian chờ để load
        // nếu không wait thì lúc này code findElement sẽ thực thi và không tim được element
        try {
            // truy cập trang web opensource
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // simple wait (sau này sẽ thay thế bằng Webdriverwait)
            Thread.sleep(3000);

            // Tìm đến ô username và password - Locator
            WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
            WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
            // Lấy giá trị của element ra
            // starts-with kiểm tra giá trị bắt đầu của một thuộc tính, em nó có khớp một phần
            String usernameText = driver.findElement(By.xpath("//p[starts-with(normalize-space(),\"Username\")]")).getText();
            String passwordText = driver.findElement(By.xpath("//p[starts-with(normalize-space(),\"Password\")]")).getText();

            String usernameValue = usernameText.split(":")[1].trim();
            String passwordValue = passwordText.split(":")[1].trim();


            // Nhập dữ liệu vào ô username và password
            username.sendKeys(usernameValue);
            password.sendKeys(passwordValue);

            // Tìm đến nút button login
            WebElement btnLogin = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            // Thao tác click nút Login
            btnLogin.click();

            System.out.println("Đăng nhập thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
