import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Robot_class {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.guru99.com/");

        Robot r = new Robot();

        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(2000);
        r.keyRelease(KeyEvent.VK_SPACE);

        //Release Enter

    }
}
