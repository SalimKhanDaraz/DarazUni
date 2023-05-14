package DarazUniversity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;


public class DU_Setup {

    public DU_Setup(WebDriver driver) {
        DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
}
