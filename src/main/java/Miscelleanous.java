import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Miscelleanous {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().deleteCookieNamed("asdf");
    driver.get("http://google.com");

    File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshot.png");
        file.renameTo(destination);

    }
}
