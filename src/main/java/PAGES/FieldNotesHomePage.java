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

    // Footer
    By madeInUSAInFooter = By.cssSelector(".footer-eyebrow.footer-eyebrow--left");
    By durableMaterialInFooter = By.cssSelector(".footer-eyebrow.footer-eyebrow--right");
    By logoInFooter = By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/a");
    By mottoInFooter = By.cssSelector(".motto.motto--footer");
    By navsOnTheLeftOfFooter = By.cssSelector(".footer-nav__item.js-navigation-link-footer");
    By emailFieldInFooter = By.cssSelector(".footer-signup__input");
    By emailSubmitButton = By.cssSelector(".footer-signup__button");

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

    // Footer Confirmation
    public boolean confirmTheLogoInFooter() {
        System.out.println(driver.findElement(logoInFooter).getText());
        return driver.findElement(logoInFooter).isDisplayed();
    }
    // Made in USA
    public boolean confirmMadeInUSAInFooter() {
        System.out.println(driver.findElement(madeInUSAInFooter).getText());
        return driver.findElement(madeInUSAInFooter).isDisplayed();
    }
    // Durable Material tag
    public boolean confirmDurableMaterialInFooter() {
        System.out.println(driver.findElement(durableMaterialInFooter).getText());
        return driver.findElement(durableMaterialInFooter).isDisplayed();
    }
    // Motto
    public boolean confirmMottoInFooter() {
        System.out.println(driver.findElement(mottoInFooter).getText());
        return driver.findElement(mottoInFooter).isDisplayed();
    }
    // Left Navs in the footer
    public boolean confirmLeftNavsInFooter() {
        List<WebElement> leftNavsInFooter = driver.findElements(navsOnTheLeftOfFooter);
        System.out.println("🪖 Navigation links in footer → " + leftNavsInFooter.size());
        leftNavsInFooter.stream().forEach(WebElement::getText);
        return driver.findElement(navsOnTheLeftOfFooter).isDisplayed();
    }
    // Subscribe email
    public void subscribeTheNewsletter() {
        driver.findElement(emailFieldInFooter).sendKeys("mcomentr@yahoo.com");
        driver.findElement(emailSubmitButton).submit();
    }
}