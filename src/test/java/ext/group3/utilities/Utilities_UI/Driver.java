package ext.group3.utilities.Utilities_UI;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

/*
    Creating the private constructor so this class's object is not reachable from outside
     */

//    private Driver(){}
//
//    /*
//    making driver instance private
//    static - run before everything else and use ins static method
//     */
//
//    //private static WebDriver driver;
//    // implement threadLocal to achieve multi thread locally
//    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();
//
//    /*
//    reusable method that will return the same driver instance everytime called
//     */
//
//    /**
//     * singleton patter
//     * author anna
//     * @return
//     */
//    public static WebDriver getDriver(){
//        if(driverPool.get()==null){
//            String browserType = ConfigurationReader.getProperties("browser");
//            switch (browserType.toLowerCase()){
//                case "chrome":
//                    driverPool.set(new ChromeDriver());
//                    //driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
//                    break;
//                case "firefox":
//                    driverPool.set(new FirefoxDriver());
//                    //driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
//                    break;
//                case "safari":
//                    driverPool.set(new SafariDriver());
//                    //driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
//                    break;
//                case "headless": //it will still run but will not open Chrome
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--headless");
//                    driverPool.set(new ChromeDriver(options));
//                    //driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
//            }
//            driverPool.get().manage().window().maximize();
//            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperties("timeouts"))));
//        }
//        return driverPool.get();
//    }
//
//    /**
//     * closing driver
//     * @author anna
//     */
//    public static void closeDriver(){
//        if(driverPool.get() !=null){
//            driverPool.get().quit();
//            //driver = null;
//            driverPool.remove();
//        }
//    }

    static String browser;

    private Driver() {
    }

    private static WebDriver driver;
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;

    private static DesiredCapabilities desiredCapabilities;

    public static WebDriver getDriver() {
        if (driver == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperties("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            switch (browser) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.242.161.207";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.242.161.207";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); // Enable headless mode
                    //options.addArguments("start-maximized"); // maximize
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "firefox-headless":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    FirefoxOptions options2 = new FirefoxOptions();
                    options2.addArguments("--headless"); // Enable headless mode
                    //options.addArguments("start-maximized"); // maximize
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(options2);
                    break;

                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;


                /**
                 * These added because of EC@2 Jenkins on Linux was not running the ones above because of graphical issues.
                 */
                case "chrome-linux":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "remote-chrome-linux":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.242.161.207";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        desiredCapabilities.merge(chromeOptions);
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "firefox-linux":
                    WebDriverManager.firefoxdriver().setup();
                    firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--disable-gpu");
                    firefoxOptions.addArguments("--no-sandbox");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "remote-firefox-linux":
                    try {
                        // assign your grid server address
                        String gridAddress = "3.92.199.191";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--disable-gpu");
                        firefoxOptions.addArguments("--no-sandbox");
                        desiredCapabilities.merge(firefoxOptions);
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
