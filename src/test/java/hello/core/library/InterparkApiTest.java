package hello.core.library;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class InterparkApiTest {

    @Test
    void interpark(){
        new InterparkScraper();
    }

    static class InterparkScraper {
        public InterparkScraper() {
            execute();
        }


        void execute() {
            String ageOption = "04";
            String genderOption = "08"; // 02 07 08

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user8\\Downloads\\chromedriver_win32\\chromedriver.exe");

            // Selenium
            ChromeDriver driver = new ChromeDriver();

            driver.get("https://mbook.interpark.com/shop/ranking/age");

            // Find the <ul> tag by its ID
            Select select = new Select(driver.findElement(By.id("selectAge")));
            select.selectByValue(ageOption);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rankingListArea")));


            Document doc = Jsoup.parse(element.getAttribute("innerHTML"));
            System.out.println("doc = " + doc);
            List<Element> elements = doc.getElementsByClass("multiTxtEllipsis");
            for (Element e : elements) {
                System.out.println("element = " + e);
            }

        }
    }
}
