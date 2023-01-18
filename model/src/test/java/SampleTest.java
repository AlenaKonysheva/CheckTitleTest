import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    private ConfigProperty cfg = ConfigFactory.create(ConfigProperty.class);
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage() {
        driver.get(cfg.otusUrl());
        logger.info("Открыта страница otus");
        checkTitle();
    }


    public void checkTitle() {
        //driver.navigate().to("https://otus.ru/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        Assert.assertEquals(actualTitle, expectedTitle);
        logger.info("Проверка title завершена");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер завершил работу");
        }
    }

}
