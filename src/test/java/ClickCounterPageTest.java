import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ClickCounterPageTest {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "PATH_TO_CHROMEDRIVER");

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the Click Counter page
        driver.get("https://qaclickcounter.ccbp.tech/");

        // Find the "Click Me!" button
        WebElement clickButton = driver.findElement(By.xpath("//button[contains(text(), 'Click Me!')]"));

        // Find the count span element
        WebElement counter = driver.findElement(By.xpath("//span[contains(@class, 'counter')]"));

        for (int i = 1; i <= 100; i++) {

            // Click the "Click Me!" button
            clickButton.click();

            // Get the text from count span element
            String countStr = counter.getText();
            int count = Integer.parseInt(countStr);

            if (count != i) {
                System.out.println("Count Mismatch");
                break;
            }
            if(i == 100) {
                System.out.println("Click Counter App: Working as expected");
            }
        }

        // Quit the WebDriver instance
        driver.quit();

    }
}
