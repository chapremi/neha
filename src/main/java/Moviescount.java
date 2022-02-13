import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Moviescount {
    public static void main(String[] args)throws AWTException, InterruptedException {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/search/title/?genres=drama&groups=top_250&sort=user_rating,desc");

        Robot r = new Robot();
        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(2000);
        r.keyRelease(KeyEvent.VK_SPACE);

        System.out.println("Title:" + driver.getTitle());
        System.out.println("current_URL:" + driver.getCurrentUrl());
        List<WebElement> movie = driver.findElements(By.xpath("//div[@class=\"lister-item mode-advanced\"]"));
        for (int i = 0; i < movie.size(); i++) {
            System.out.println(movie.get(i).getText());
        }
        System.out.println("Count  " + movie.size());
    }
}
