import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class FluentWaitTest {
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();
        // fluent wait
        Wait<WebDriver>wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);


        WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if( driver.findElement(By.id("[id='finish'] h4")).isDisplayed()) {
                    return  driver.findElement(By.cssSelector("[id='finish'] h4"));
                }else{
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());



    }
}
