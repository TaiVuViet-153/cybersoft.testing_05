import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSourceAddEmployee {
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

            System.out.println("Đăng nhập thành công");

            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()=\"PIM\"]")).click();
            System.out.println("Click PIM thành công");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//a[text()=\"Add Employee\"]")).click();
            System.out.println("Click Add Employee thành công");
            Thread.sleep(5000);

            String firstName = "Elon";
            String lastName = "Musk";
            driver.findElement(By.name("firstName")).sendKeys(firstName);
            driver.findElement(By.name("lastName")).sendKeys(lastName);
            WebElement empID = driver.findElement(By.xpath("//label[text()=\"Employee Id\"]/../following-sibling::div/input"));
            String empIDValue = empID.getAttribute("value").trim();

            driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
            System.out.println("Tạo thành công");
            Thread.sleep(5000);

            String actualFirstName = driver.findElement(By.name("firstName")).getAttribute("value").trim();
            String actualLastName = driver.findElement(By.name("lastName")).getAttribute("value").trim();
            String actualEmpID = driver.findElement(By.xpath("//label[text()=\"Employee Id\"]/../following-sibling::div/input")).getAttribute("value").trim();
            System.out.println(actualFirstName + " " + actualLastName + " " + actualEmpID);
            System.out.println(firstName + " " + lastName + " " + empIDValue);

            // Nên so sánh bằng equals
            boolean isNameCorrect = firstName.equals(actualFirstName) && lastName.equals(actualLastName);
            boolean isIDCorrect = empIDValue.equals(actualEmpID);

            if(isNameCorrect && isIDCorrect) {
                System.out.println("Thêm nhân viên thành công và thông tin trùng khớp");
            } else {
                System.out.println("Thông tin sau khi lưu không trùng khớp");
            }

        } catch (Exception e) {
            System.out.println("Lỗi : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
