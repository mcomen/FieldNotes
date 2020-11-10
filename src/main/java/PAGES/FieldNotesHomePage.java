package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FieldNotesHomePage {
    // Properties
    WebDriver driver;
    By productsLinkOnHome = By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/nav/div[2]/a[1]");
    By products = By.xpath("//*[@id=\"products\"]/div/div[4]/ul/li");

    public FieldNotesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void seeProducts() {
        driver.findElement(productsLinkOnHome).click();
    }

    public List<WebElement> productCatalogue() {
        seeProducts();
        List<WebElement> allProducts = driver.findElements(products);
        System.out.println("🟢 Products on home page → " + allProducts.size());
        for(WebElement element: allProducts) {
            System.out.println(element.getText());
        }
        // Return all products
        return allProducts;
    }
}