package DarazUniversity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DU_Teardown {
    public DU_Teardown(WebDriver driver) {
        DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void browserclose (WebDriver driver) throws InterruptedException
    {
        driver.close();
        driver.quit();
    }
}
