import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it=window.iterator();
        String parentID=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
