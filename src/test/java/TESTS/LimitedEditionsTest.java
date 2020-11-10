package TESTS;

import PAGES.Dispatcher;
import PAGES.LimitedEditionsPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LimitedEditionsTest extends Settings {
    @Test
    public void testLimitedEditionsTest() throws Exception {
        Dispatcher dispatcher = new Dispatcher(driver);
        LimitedEditionsPage limitedEditionsPage = dispatcher.goToLimitedEditionsPage();
        Assert.assertTrue("❌ No, it is not on display...", limitedEditionsPage.isTitleDisplayed());
        Assert.assertTrue("❌ No, it is not on display...", limitedEditionsPage.isDetailTextOnDisplayed());
    }

    @Test
    public void testlimitedEditionProducts() throws Exception {
        Dispatcher dispatcher = new Dispatcher(driver);
        LimitedEditionsPage limitedEditionsPage = dispatcher.goToLimitedEditionsPage();
        limitedEditionsPage.limitedEditionProducts();
    }
}