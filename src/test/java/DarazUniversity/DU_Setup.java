package DarazUniversity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static DarazUniversity.DU_Wait.driver;


public class DU_Setup {


    // Testing


    public DU_Setup(WebDriver driver) {
        //DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver driver() throws IOException, InterruptedException {

        String os = System.getProperty("os.name").toLowerCase();

        System.out.println("\n\nCurrent OS is: "+os+"\n\n");
        if(os.equalsIgnoreCase("mac os x")){
            WebDriverManager.chromedriver().setup();
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--headless","--remote-allow-origins=*");
            driver = new ChromeDriver(service, options);
        }
        else if (os.equalsIgnoreCase("windows 10")) {
            WebDriverManager.chromedriver().setup();
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--headless","--remote-allow-origins=*");
            driver = new ChromeDriver(service, options);
        }
        else {

            Runtime.getRuntime().exec("sudo apt-get install xvfb");
            WebDriverManager.chromedriver().setup();
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.setBinary("/usr/bin/google-chrome");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("disable-dev-shm-usage"); // recommended for running in Docker
            options.addArguments("no-sandbox"); // recommended for running in Docker
            options.addArguments("start-maximized"); // recommended for running in Docker
            options.addArguments("disable-gpu"); // recommended for running in Docker
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-component-update", "disable-default-apps", "disable-popup-blocking"));
          //  Runtime.getRuntime().exec("xvfb-run -a -s \"-screen 0 1920x1080x24\" google-chrome");
            driver = new ChromeDriver(service, options);

        }
        driver.manage().window().maximize();
        // mainPage = new MainPageObjects(driver);

        return driver;



/*
    public WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "/Users/salim/Downloads/chromedriver");

        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        ChromeDriver driver = new ChromeDriver(options);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://university.daraz.pk/");

        return driver;
    }

 */

}}
