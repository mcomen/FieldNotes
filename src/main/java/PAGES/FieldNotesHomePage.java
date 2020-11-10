package PAGES;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FieldNotesHomePage {
    // Properties
    WebDriver driver;
    By productsLinkOnHome = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/nav/div[2]/a[1]");
    By products = By.xpath("//*[@id=\"products\"]/div/div[4]/ul/li");
    By searchField = By.xpath("//input[@type='search']");
    By searchResultProducts = By.cssSelector(".product-grid__item");
    Logger logger = LogManager.getLogger(FieldNotesHomePage.class);

    public FieldNotesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void seeProducts() {
        driver.findElement(productsLinkOnHome).click();
        logger.info("🍥 This is a message from the logger!");
    }

    public List<WebElement> productCatalogue() {
        seeProducts();
        List<WebElement> allProducts = driver.findElements(products);
        System.out.println("🟢 Products on home page → " + allProducts.size());
        for(WebElement element: allProducts) {
            System.out.println(element.getText());
            logger.info("🛋 Here is the all products...");
            logger.error("⚠️ Could not find any products...");
            logger.debug("Please, give me something...");
        }
        // Return all products
        return allProducts;
    }

    public void search(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
        List<WebElement> searchResultProductList = driver.findElements(searchResultProducts);
        System.out.println("Total product/s for this search → " + searchResultProductList.size());
        searchResultProductList.stream().forEach(WebElement::getText);
        logger.info("🏔 Here is/are Field Notes searched products...");
        logger.debug("Where is my log file...");
    }
}