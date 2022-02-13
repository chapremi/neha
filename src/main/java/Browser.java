import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
class TestClass1 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "latest");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 1");
        Browser r1 = new Browser();
        r1.executeTest(capsHashtable);
    }
}
class TestClass2 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "firefox");
        capsHashtable.put("browser_version", "latest");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 2");
        Browser r2 = new Browser();
        r2.executeTest(capsHashtable);
    }
}
class TestClass3 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "safari");
        capsHashtable.put("browser_version", "latest");
        capsHashtable.put("os", "OS X");
        capsHashtable.put("os_version", "Big Sur");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 3");
        Browser r3 = new Browser();
        r3.executeTest(capsHashtable);
    }
}
public class Browser {
    public static final String USERNAME = "ankitasingh_dz0RhQ";
    public static final String AUTOMATE_KEY = "cJ3pzdCK9iQGWjvboxXE";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        Thread object1 = new Thread(new TestClass1());
        object1.start();
        Thread object2 = new Thread(new TestClass2());
        object2.start();
        Thread object3 = new Thread(new TestClass3());
        object3.start();
    }

    public void executeTest(Hashtable<String, String> capsHashtable) {
        String key;
        DesiredCapabilities caps = new DesiredCapabilities();
        // Iterate over the hashtable and set the capabilities
        Set<String> keys = capsHashtable.keySet();
        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            key = itr.next();
            caps.setCapability(key, capsHashtable.get(key));
        }
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            // Searching for 'BrowserStack' on google.com
            driver.get("https://www.imdb.com/search/title/?genres=drama&groups=top_250&sort=user_rating,desc");
            List<WebElement> Result = driver.findElements(By.xpath("//div[@class=\"lister-item mode-advanced\"]"));
            for (int i = 0; i < Result.size(); i++) {
                System.out.println("Options :" + Result.get(i).getText());
            }
            //Assert.assertEquals(driver.getTitle(), "Drama, IMDb \"Top 250\" (Sorted by IMDb Rating Descending) - IMDb");
            System.out.println("Count of Movies" + Result.size());


            WebElement ScrollBar = driver.findElement(By.xpath("//div[@id=\"rvi-div\"]"));
            jse.executeScript("arguments[0].scrollIntoView();", ScrollBar);


        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        driver.quit();
    }
}




