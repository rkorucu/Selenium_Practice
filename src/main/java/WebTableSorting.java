import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/ramo/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

        driver.findElement(By.xpath("//tr/th[1")).click();
        //capture all of element on list
        List<WebElement> elementList=driver.findElements(By.xpath("//tr/tf[1"));
        //capture text of element s into new list
       List<String>orginaList= elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        // sort in the list of step 3 -> sorted lsit
       List<String>sortlist= orginaList.stream().sorted().collect(Collectors.toList());
        //compare orginal list vs sorted list
        Assert.assertTrue(orginaList.equals(sortlist));

        // scan the name column with getText ->Beans->print the price of the Rice
   List<String>price;
        do
        {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if(price.size()<1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);
    }

    private static String getPriceVeggie(WebElement s) {

      String pricevalue=  s.findElement(By.xpath("followinf-sibling::td[1")).getText();
     return pricevalue;
    }

}
