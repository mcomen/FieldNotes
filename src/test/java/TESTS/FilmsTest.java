package TESTS;

import PAGES.Dispatcher;
import PAGES.Films;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilmsTest extends Settings {
    @Test
    public void testTitle() {
        Dispatcher dispatcher = new Dispatcher(driver);
        Films films = dispatcher.goToFilmArchive();
        films.isTitleDisplayed();
        Assert.assertTrue(films.isTitleDisplayed(), "Could not found!");
    }
}
