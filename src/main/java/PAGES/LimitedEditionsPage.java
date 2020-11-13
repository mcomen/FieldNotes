package PAGES;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import java.io.File;
import java.util.List;

public class LimitedEditionsPage {
    // Properties
    WebDriver driver;
    By title = By.xpath("//*[@id=\"subscription\"]/div[1]/h1");
    By detailText = By.xpath("//*[@id=\"subscription\"]/div[2]/p");
    By limitedEditionProduct = By.xpath("//input[@name='productInfoJson']");
    Logger logger = LogManager.getLogger(LimitedEditionsPage.class);

    // Constructor
    public LimitedEditionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Take screenshot
    public void takeScreenshot(String screenshotName) throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("./FieldNotes/src/main/resources/" + screenshotName + ".png"));
        System.out.println("🟡 Log4J2 Logging...");
        logger.info("screenshot is taken with name → " + screenshotName);
    }

    // Check the image on the the Limited Edition page
    public boolean isTitleDisplayed() throws Exception {
        System.out.println(driver.findElement(title).getText());
        takeScreenshot(driver.findElement(title).getText());
        return driver.findElement(title).isDisplayed();
    }

    public boolean isDetailTextOnDisplayed() throws Exception {
        System.out.println(driver.findElement(detailText).getText());
        logger.error("❌ Detail text is not here...");
        takeScreenshot(driver.findElement(detailText).getText());
        logger.error("❌ Detail text screenshot is not taken...");
        return driver.findElement(detailText).isDisplayed();
    }

    public List<WebElement> limitedEditionProducts() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> allProducts = driver.findElements(limitedEditionProduct);
        logger.info("All the products...");
        System.out.println("🟢 Limited Editions Products → " + allProducts.size());
        for(WebElement element: allProducts) {
            System.out.println(element.getText());
        }
        // Return all products
        return allProducts;
    }
}