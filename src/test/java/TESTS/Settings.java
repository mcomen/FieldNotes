package TESTS;

import PAGES.FieldNotesHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
// FFC66D

public class Settings {
    // Properties
    WebDriver driver;
    FieldNotesHomePage fieldNotesHomePage;

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        // Properties
        Properties configs = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/muhammedcomen/IdeaProjects/FieldNotes/src/main/java/Utils/Configs.properties");
        System.setProperty("webdriver.chrome.driver", "/Users/muhammedcomen/IdeaProjects/FieldNotes/src/main/resources/chromedriver");
        configs.load(fileInputStream);
        String browser = configs.getProperty("browser");
        driver = new ChromeDriver();
        driver.get(configs.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        fieldNotesHomePage = new FieldNotesHomePage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}