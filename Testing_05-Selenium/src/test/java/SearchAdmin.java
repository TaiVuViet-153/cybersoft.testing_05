import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchAdmin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(3000);

            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            Thread.sleep(5000);
            System.out.println("Đăng nhập thành công");

            driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();
            Thread.sleep(5000);
            System.out.println("Vào được màn hình Admin thành công");

            // Tìm ô input để nhập dữ liệu search
            driver.findElement(By.xpath("//label[text()=\"Username\"]/../following-sibling::div/input")).sendKeys("admin");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            Thread.sleep(5000);
            System.out.println("Đã ấn tìm kiếm");

            // Lấy danh sách
            List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-body")); // Tạo ra mảng
            // Đặt cờ
            boolean userFound = false; // không tìm thấy
            // Tạo vòng lặp lấy dữ liệu từng dòng
            for (WebElement row : rows) {
                String userFind = row.findElement(By.xpath("//div[@role=\"cell\"][2]/div")).getText();
                if (userFind.equalsIgnoreCase("Admin")) {
                    userFound = true;
                    break; // Dừng vòng lặp
                }
            }

            // Kiểm tra xem đã tìm thấy user hay chưa
            if (userFound) {
                System.out.println("Tìm thấy user");
            } else {
                System.out.println("Không tìm thấy user");
            }

        } catch (Exception e) {
            System.out.println("Lỗi " + e.getMessage());
        } finally {
//            driver.quit();
        }
    }
}
