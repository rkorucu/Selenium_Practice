import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");


        WebElement table=driver.findElement(By.id("product"));
        System.out.println(table.findElements(By.tagName("tr")).size());
        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> list=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
      int count=0;
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(0).getText());
            System.out.println(list.get(1).getText());
            System.out.println(list.get(2).getText());

        }

    }
}
