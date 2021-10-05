package tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LanguagesTest extends BaseTest{
    @Test
    public void checkTheNumberOfLanguagesInTheLanguageMenu(){
        MainPage mainPage = new MainPage();
        mainPage.clickLanguageButton();
        List <WebElement> allLanguages = mainPage.getListOfAllLanguages();
        int expectedResult=44;
        System.out.println(allLanguages.size());
        assertThat(allLanguages.size())
                .as("The amount of languages is not as expected")
                .isEqualTo(expectedResult);
    }

    @Test
    public void checkThatUkrainianExistsInTheLanguageMenu(){
        MainPage mainPage = new MainPage();
        mainPage.clickLanguageButton();
        List <WebElement> allLanguages = mainPage.getListOfAllLanguages();
        List <String> allLanguagesAsString = new ArrayList<>();
        for (int i=0; i<allLanguages.size(); i++) {
                 allLanguagesAsString.add(allLanguages.get(i).getText());
             }
        assertThat(allLanguagesAsString)
                .as("Ukrainian language doesn't exist in the Language Menu")
                .contains("Українська");
    }
}
