import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice");
        driver.switchTo().newWindow(WindowType.TAB);
 /// switch window
        Set<String> handlers=driver.getWindowHandles();
        Iterator<String> it= handlers.iterator();
        String parentChild=it.next();
        String childWindow=it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p'] "))
                .get(1).getText();
        driver.switchTo().window(parentChild);
      WebElement name= driver.findElement(By.cssSelector("[name='name']"));
      name.sendKeys(courseName);
    // screeen shot
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));

        /// get  heigth & width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }
}
