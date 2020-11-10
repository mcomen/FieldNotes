package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

public class DispatchPage {
    // Properties
    WebDriver driver;
    By featuredArticleTitle = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div[1]/div/div/a");
    By featuredArticleDetailText = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div[1]/div/p");
    By recentEntries = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/div[2]");
    By categoryDropdownButton = By.cssSelector(".dropdown-filter__title.js-blog-filter-toggle");
    By articles = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/div[3]/div/ul/li");
    By articleTitles = By.cssSelector(".heading-d2.blog-teaser__title");

    public DispatchPage(WebDriver driver) {
        this.driver = driver;
    }
    // Get Title
    public String getFeaturedArticleTitle() {
        return driver.findElement(featuredArticleTitle).getText();
    }
    // Get detail text
    public String getFeaturedArticleDetailText() {
        return driver.findElement(featuredArticleDetailText).getText();
    }
    // Get Recent entries
    public String getRecentEntriesTitle() {
        return driver.findElement(recentEntries).getText();
    }

    // Dropdown
    public void select(String option) {
        // Open the dropdown so the options are visible
        driver.findElement(categoryDropdownButton).click();
        // Get all of the options
        List<WebElement> options = driver.findElements(By.cssSelector(".js-blog-filter-category"));
        for(int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        System.out.println("Option count in dropdown → " + options.size());
        // Loop through the options and select the one that matches
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("Can't find " + option + " in dropdown");
    }

    public void selectFromDropdown() {
        select("FIELD NEWS");
    }

    public List<WebElement> getAllArticles() {
        System.out.println("Articles → " + driver.findElements(articles).size());
        List<WebElement> arts = driver.findElements(articles);
        List<WebElement> articleTits = driver.findElements(articleTitles);
        for(WebElement ele: articleTits) {
            System.out.println(ele.getText());
        }
        articleTits.stream().forEach(System.out::println);
        return driver.findElements(articles);
    }
}