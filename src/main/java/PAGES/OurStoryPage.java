package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OurStoryPage {

    // Properties
    WebDriver driver;
    public By title = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div[2]/div/h1");
    public By vintageNotebooksImages = By.xpath("l-from-seed__item");

    public OurStoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleDisplayed(){
        return driver.findElement(title).isDisplayed();
    }

    public List<WebElement> allVintageBooks() {
        List<WebElement> notebooks = driver.findElements(vintageNotebooksImages);
        for(WebElement eles: notebooks) {
            System.out.println(eles.getText());
        }
        notebooks.stream().forEach(System.out::println);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return notebooks;
    }
}
