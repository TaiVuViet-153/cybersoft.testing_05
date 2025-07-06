import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        // tự động tải chrome driver
        WebDriverManager.chromedriver().setup();

        // khởi tạo trình duyệt chrome
        WebDriver driver = new ChromeDriver();

        // thiết lập ChromeOption để dùng profile thật -> mở chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:/Users/ASUS/AppData/Local/Google/Chrome/User Data/Guest Profile");
        options.addArguments("--profile-directory=Guest Profile");


        // mở fullscreen
        driver.manage().window().maximize();

        // truy cập vào trang google
        driver.get("https://www.google.com/");

        // đóng trình duyệt
//        driver.quit();


        // xpath: "//tagname[@attribute="value"]
        // "//": tìm kiếm ở mọi nơi có trong cây html
        // tagname: tên thẻ html (div, input, span, p, h1, h2, h3, img,...) ko bao gồm style và script
        // attribute: điều kiện lọc là tìm các thuộc tính của thẻ (type, id, class,...)

        // tìm tới ô tìm kiếm của google
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id=\"APjFqb\"]"));
        // nhập dữ liệu vào ô tìm kiếm của google
        searchBox.sendKeys("Doraemon");
        // nhấn Enter tìm kiếm
//        searchBox.submit();

        // contains
        // element xpath: //tagname[contains(@attribute, value)]
        // VD1: //h1[contains(@class, "text-2xl")] // dùng để kiểm tra 1 phần giá trị của attribute
        // VD2: //h1[text()="XPath Demo Page"] (đường dẫn tuyệt đối/khớp toàn bộ nội dung)
        // VD3: //h1[contains(@text()="XPath")] (dẫn tương đối/khớp 1 phần nội dung)

        // text()
        // element xpath: //tagname[text()="value"]
        // VD: //button[text()="Login"]

        // xpath: (xpath cơ bản)[vị trí] - vị trí này là vị trí của phần tử bắt đầu từ 1, 2, 3,...
        // VD: (//li[text()="Item"](3)

        // following-sibling, preceding-subling
        // following-sibling: dùng để lấy thẻ đứng sau
        // VD1: //label/following-sibling::input[@name="username]
        // VD2: (//label/following-sibling::input)[1]

        // preceding-sibling: dùng để lấy thẻ đứng trước
        // VD3: //input/preceding-sibling::label

        // and && or
        // and: thoả mãn hết tất cả các điều kiện đúng
        // VD1: //input[@type="text" and @name="username"]
        // or: thoả mãn 1 trong những điều kiện đúng
        // VD2: //input[@type="text" or @name="username"]

        //normalize-space(): loại bỏ khoảng trắng đầu và cuối để so sánh
        //VD: //button[normalize-space(@text="Login")]
    }
}
