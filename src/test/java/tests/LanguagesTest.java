package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LanguagesTest extends BaseTest {
    @Test
    public void checkTheNumberOfLanguagesInTheLanguageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickLanguageButton();
        List<String> allLanguages = mainPage.getListOfAllLanguages();
        int expectedAmountOfLanguages = 44;
        assertThat(allLanguages.size())
                .as("The amount of languages is not as expected")
                .isEqualTo(expectedAmountOfLanguages);
    }

    @Test
    public void checkThatUkrainianExistsInTheLanguageMenu() {
        MainPage mainPage = new MainPage();
        mainPage.clickLanguageButton();
        String expectedLanguageToBeInTheList = "Українська";
        List<String> allLanguages = mainPage.getListOfAllLanguages();
        assertThat(allLanguages)
                .as("Ukrainian language doesn't exist in the Language Menu")
                .contains(expectedLanguageToBeInTheList);
    }
}
