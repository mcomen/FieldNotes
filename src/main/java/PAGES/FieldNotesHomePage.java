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
    // Footer
    By madeInUSAInFooter = By.cssSelector(".footer-eyebrow.footer-eyebrow--left");
    By durableMaterialInFooter = By.cssSelector(".footer-eyebrow.footer-eyebrow--right");
    By logoInFooter = By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/a");
    By mottoInFooter = By.cssSelector(".motto.motto--footer");
    By navsOnTheLeftOfFooter = By.cssSelector(".footer-nav__item.js-navigation-link-footer");
    By emailFieldInFooter = By.cssSelector(".footer-signup__input");
    By emailSubmitButton = By.cssSelector(".footer-signup__button");
    // Logger
    Logger logger = LogManager.getLogger(FieldNotesHomePage.class.getName());

    public FieldNotesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void seeProducts() {
        driver.findElement(productsLinkOnHome).click();
    }

    public List<WebElement> productCatalogue() {
        logger.info("About to click see products.");
        seeProducts();
        List<WebElement> allProducts = driver.findElements(products);
        logger.error("There is no product here...");
        System.out.println("🟢 Products on home page → " + allProducts.size());
        for(WebElement element: allProducts) {
            logger.info("Here is the list...");
            System.out.println(element.getText());
            logger.debug("📢 A message from the logger...");
        }
        // Return all products
        return allProducts;
    }

    public void search(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
        List<WebElement> searchResultProductList = driver.findElements(searchResultProducts);
        System.out.println("Total product/s for this search → " + searchResultProductList.size());
        searchResultProductList.stream().forEach(WebElement::getText);
        logger.error("Not found ❌");
    }

    // Footer Confirmation
    public boolean confirmTheLogoInFooter() {
        System.out.println(driver.findElement(logoInFooter).getText());
        logger.debug(logoInFooter);
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
    // Left Navigation in the footer
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