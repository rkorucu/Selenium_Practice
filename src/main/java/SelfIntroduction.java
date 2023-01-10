
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SelfIntroduction{
    public static void main(String[] args) {




        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Firefox Launch


       driver.get("https://rahulshettyacademy.com/");
       System.out.println(driver.getTitle());
      System.out.println(driver.getCurrentUrl());


    }
}
