package TESTS;

import org.junit.Assert;
import org.testng.annotations.Test;

public class HomeTest extends Settings {
    @Test
    public void testProductsCatalogue() {
        fieldNotesHomePage.productCatalogue();
        fieldNotesHomePage.search("all");
    }
    @Test
    public void testLogoInFooter() {
        Assert.assertTrue(fieldNotesHomePage.confirmTheLogoInFooter());
        fieldNotesHomePage.confirmTheLogoInFooter();
    }
    @Test
    public void testConfirmMadeInUSAInFooter() {
        Assert.assertTrue("Made in USA is not here...", fieldNotesHomePage.confirmMadeInUSAInFooter());
        fieldNotesHomePage.confirmMadeInUSAInFooter();
    }
    @Test
    public void testConfirmDurableMaterialInFooter() {
        fieldNotesHomePage.confirmDurableMaterialInFooter();
    }
    @Test
    public void testConfirmMottoInFooter() {
        fieldNotesHomePage.confirmMottoInFooter();
    }
    @Test
    public void testConfirmLeftNavsInFooter() {
        fieldNotesHomePage.confirmLeftNavsInFooter();
    }
    @Test
    public void testSubscribeTheNewsletter() {
        fieldNotesHomePage.subscribeTheNewsletter();
        System.out.println("You subscribed the newsletter.📰 ✳️");
    }
}