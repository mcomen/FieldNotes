package TESTS;

import PAGES.FieldNotesHomePage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
// FFC66D

public class Settings {
    // Properties
    WebDriver driver;
    FieldNotesHomePage fieldNotesHomePage;
    Logger logger = LogManager.getLogger(Settings.class.getName());

    @BeforeSuite
    public void setUp() throws IOException {
        // Properties
        Properties configs = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/muhammedcomen/IdeaProjects/FieldNotes/src/main/java/Utils/Configs.properties");

        // Browser setup
        configs.load(fileInputStream);
        String browser = configs.getProperty("browser");

        // Multile Browser setup
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/muhammedcomen/IdeaProjects/FieldNotes/src/main/resources/chromedriver");
            configs.load(fileInputStream);
            driver = new ChromeDriver();
            logger.info("Browser name is → " + browser);
        } if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/muhammedcomen/IdeaProjects/FieldNotes/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
            logger.info("Browser name is → " + browser);
        }

        // Browser initial actions
        driver.get(configs.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        fieldNotesHomePage = new FieldNotesHomePage(driver);
        logger.info("I am home!");

        // Actions
        Actions actions = new Actions(driver);
        // Logger
        logger.info("Before Suite is running!");
    }

    // Screenshot
    public static void takeScreenShot(WebDriver driver, String filename) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            logger.info("Do not forget to push your code to Github.");
            driver.quit();
        }
    }
}