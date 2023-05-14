package DarazUniversity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DU_Wait {

    public static WebDriver driver;
    //public static WebDriverWait wait =null;
    public static WebDriverWait waitforelement()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
