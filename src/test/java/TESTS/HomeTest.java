package TESTS;

import org.testng.annotations.Test;

public class HomeTest extends Settings {
    @Test
    public void testProductsCatalogue() throws Exception {
        fieldNotesHomePage.productCatalogue();
        fieldNotesHomePage.search("all");
    }
}