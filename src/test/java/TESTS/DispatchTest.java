package TESTS;

import PAGES.DispatchPage;
import PAGES.Dispatcher;
import org.testng.annotations.Test;

public class DispatchTest extends Settings {
    @Test
    public void testFeaturedArticle() {
        Dispatcher dispatcher = new Dispatcher(driver);
        DispatchPage dispatchPage = dispatcher.goToDispatchPage();
        dispatchPage.getFeaturedArticleTitle();
        dispatchPage.getFeaturedArticleDetailText();
        dispatchPage.getAllArticles();
        dispatchPage.selectFromDropdown();
    }
}