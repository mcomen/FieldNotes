package PAGES;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Films {
    // Properties
    WebDriver driver;
    public By titleInFilms = By.cssSelector("h1.heading-a.u-align-center");
    public static Logger logger = LogManager.getLogger(Films.class.getName());

    public Films(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleDisplayed() {
        logger.info("Title is here...");
        return driver.findElement(titleInFilms).isDisplayed();
    }
}
