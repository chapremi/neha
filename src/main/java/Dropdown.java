//import java.util.Iterator;
//import java.util.Set;
//public class Dropdown {
//    public void executeTest2(Hashtable<String, String> capsHashtable) {
//        String key;
//        DesiredCapabilities caps = new DesiredCapabilities();
//        // Iterate over the hashtable and set the capabilities
//        Set<String> keys = capsHashtable.keySet();
//        Iterator<String> itr = keys.iterator();
//        while (itr.hasNext()) {
//            key = itr.next();
//            caps.setCapability(key, capsHashtable.get(key));
//        }
//        WebDriver driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL(URL), caps);
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            // Searching for 'BrowserStack' on google.com
//            driver.get("http://demo.guru99.com/test/newtours/register.php");
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            Select country = new Select(driver.findElement(By.name("country")));
//            country.selectByVisibleText("INDIA");
//            System.out.println(driver.getTitle());
//            Assert.assert
//
//        }
//    }
//}
