package PAGES;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.util.List;

public class LimitedEditionsPage {
    // Properties
    WebDriver driver;
    By title = By.xpath("//*[@id=\"subscription\"]/div[1]/h1");
    By detailText = By.xpath("//*[@id=\"subscription\"]/div[2]/p");
    By limitedEditionProduct = By.cssSelector(".h2.colors-edition__title");

    // Constructor
    public LimitedEditionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Take screenshot
    public void takeScreenshot(String screenshotName) throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("./FieldNotes/src/main/resources/" + screenshotName + ".png"));
    }

    // Check the image on the the Limited Edition page
    public boolean isTitleDisplayed() throws Exception {
        System.out.println(driver.findElement(title).getText());
        takeScreenshot(driver.findElement(title).getText());
        return driver.findElement(title).isDisplayed();
    }

    public boolean isDetailTextOnDisplayed() throws Exception {
        System.out.println(driver.findElement(detailText).getText());
        takeScreenshot(driver.findElement(detailText).getText());
        return driver.findElement(detailText).isDisplayed();
    }

    public List<WebElement> limitedEditionProducts() {
        List<WebElement> allProducts = driver.findElements(limitedEditionProduct);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("🟢 Limited Editions Products → " + allProducts.size());
        for(WebElement element: allProducts) {
            System.out.println(element.getText());
        }
        // Return all products
        return allProducts;
    }
}