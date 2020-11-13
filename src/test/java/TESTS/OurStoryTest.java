package TESTS;

import PAGES.Dispatcher;
import PAGES.OurStoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OurStoryTest extends Settings {
    @Test
    public void testTitle(){
        logger.info("🏁 Our Story test started...");
        Dispatcher dispatcher = new Dispatcher(driver);
        OurStoryPage ourStoryPage = dispatcher.goToOurStoryPage();
        ourStoryPage.isTitleDisplayed();
        logger.info("Title is here...");
        Assert.assertEquals("WE KNOW WHERE WE’RE FROM", "WE KNOW WHERE WE’RE FROM");
        System.out.println("Here is the Our Story Page Title 🌲 → " + driver.findElement(ourStoryPage.title).getText());
        logger.info("Title test is over...🔚");
    }

    @Test
    public void testAllVintageBooks() {
        Dispatcher dispatcher = new Dispatcher(driver);
        OurStoryPage ourStoryPage = dispatcher.goToOurStoryPage();
        ourStoryPage.allVintageBooks();
    }
}