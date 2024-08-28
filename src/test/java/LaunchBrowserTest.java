
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserTest {
    static Logger logger = Logger.getLogger(LaunchBrowserTest.class);
    private WebDriver d;
    //TRACE DEBUG INFO WARN ERROR FATAL
    @BeforeClass
    public static void init(){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("performing initialisation");
        WebDriverManager.chromedriver().setup();
        logger.trace("This is TRACE");
        logger.debug("This is DEBUG");
        logger.info("This is INFO");
        logger.warn("This is WARN");
        logger.error("This is ERROR");
        logger.fatal("This is FATAL");
    }

    @Test
    public void launchBrowser(){
        logger.info("Launching Browser");

        d = new ChromeDriver();
        d.get("https://www.bbc.com");
    }

    @After
    public void cleanUp(){
        logger.info("Performing clean up");
        d.quit();
    }
}
