package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscribeSectionTest extends BaseTest {

    @Test
    public void checkThatTextNearTheEmailFieldAsExpected() {
        MainPage mainPage = new MainPage();
        String expectedResult = "Get our latest news and special sales";
        String actualResult = mainPage.getTextFromTheSubscriptionSectionNearEmailField();
        assertThat(actualResult)
                .as("Message is not as expected")
                .isEqualTo(expectedResult);
    }

    @Test
    public void checkThatTextUnderEmailFieldAsExpected() {
        MainPage mainPage = new MainPage();
        String expectedResult = "You may unsubscribe at any moment. For that purpose, please find my contact info in the legal notice.";
        String actualResult = mainPage.getTextFromTheSubscriptionSectionUnderEmailField();
        assertThat(actualResult)
                .as("Message is not as expected")
                .isEqualTo(expectedResult);
    }

    @Test
    public void checkThatSubscribeButtonIsInUpperCase() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        String expectedResult = "Subscribe";
        String actualResult = mainPage.getNameFromTheSubscribeButton();
        softAssertions.assertThat(actualResult)
                .as("Actual text is not as expected")
                .isEqualTo(expectedResult);
        softAssertions.assertThat(mainPage.isNameOfTheSubscribeButtonInUppercase())
                .as("Text on the subscribe button is not in uppercase")
                .isEqualTo(true);
        softAssertions.assertAll();
    }
}
