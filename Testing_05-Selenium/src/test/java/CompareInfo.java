import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareInfo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(3000);

            // Tìm đến các Locator
            // Data đăng nhập phải được tạo từ trước
            driver.findElement(By.name("username")).sendKeys("elon.musk");
            driver.findElement(By.name("password")).sendKeys("P@ssword1");
            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            Thread.sleep(5000);
            System.out.println("Đăng nhập thành công");

            // Truy cập vào màn hình My Info
            driver.findElement(By.xpath("//span[text()=\"My Info\"]")).click();
            Thread.sleep(5000);

            // Gọi element info
            WebElement firstName = driver.findElement(By.name("firstName"));
            WebElement lastName = driver.findElement(By.name("lastName"));

            // Lấy value từ element
            String firstNameValue = firstName.getAttribute("value").trim();
            String lastNameValue = lastName.getAttribute("value").trim();

            // Fullname
            String fullNameValue = firstNameValue + " " + lastNameValue;

            // Lấy xpath bằng classname:
            // 1. By.classname: chỉ gọi được tới 1 classname
            // 2. By.cssSelector: có thể gọi được nhiều class và có thể reference tới html tag tương ứng
            // VD: button.btn-submit (cssSelector)
            WebElement fullNameDisplay = driver.findElement(By.cssSelector("p.oxd-userdropdown-name"));
            String fullNameDisplayValue = fullNameDisplay.getText().trim();

            // So sánh
            // .equalIgnoreCase: là so sánh giá trị bất kể viết hoa hay viết thường
            if (fullNameValue.equalsIgnoreCase(fullNameDisplayValue)) {
                System.out.println("Kết quả trùng khớp.");
            } else {
                System.out.println("Kết quả không trùng khớp.");
            }


        } catch (Exception e) {
            System.out.println("Lỗi " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
