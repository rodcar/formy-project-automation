import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandler = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        driver.switchTo().window(originalHandler);

        driver.quit();
    }
}
