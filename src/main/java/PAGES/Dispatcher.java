package PAGES;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class Dispatcher {
    // Properties
    WebDriver driver;

    // Main menu links
    By limitedEditionProducts = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/nav/div[2]/a[2]");
    By dispatches = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/nav/div[2]/a[3]");

    // Constructor
    public Dispatcher(WebDriver driver) {
        this.driver = driver;
    }

    // Take screenshot
    public void takeScreenshot(String screenshotName) throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("./screenshots/" + screenshotName + ".png"));
    }

    // Go to Limited Editions Page
    public LimitedEditionsPage goToLimitedEditionsPage() {
        driver.findElement(limitedEditionProducts).click();
        return new LimitedEditionsPage(driver);
    }

    // Go to Dispatch Page
    public DispatchPage goToDispatchPage() {
        driver.findElement(dispatches).click();
        return new DispatchPage(driver);
    }
}