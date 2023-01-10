import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/");

    driver.findElement(By.linkText("Multiple Windows")).click();

    driver.findElement(By.linkText("Click Here")).click();
        driver.findElement(By.tagName("h3")).getText();

        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentId= it.next();;
        String childID=it.next();
        driver.switchTo().window(childID);
        driver.findElement(By.tagName("h3")).getText();
        System.out.println( driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().window(parentId);
        driver.findElement(By.tagName("h3")).getText();
        System.out.println( driver.findElement(By.tagName("h3")).getText());

    }
}
