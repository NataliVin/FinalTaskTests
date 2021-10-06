package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import utilities.FakeData;

public class RegistrationWithInvalidDataTest extends BaseTest {
    @Test
    public void checkThatInvalidDataHighlightedRedAndWarningAppears() {
        MainPage mainPage = new MainPage();
        FakeData fakeData = new FakeData();
        SoftAssertions softAssertions = new SoftAssertions();
        String invalidFirstName = "James8";
        String expectedBorderColor = "rgb(255, 76, 76)";
        String expectedWarningMessage = "Invalid format.";
        RegistrationPage registrationPage =
                ((RegistrationPage) mainPage.clickSignInButton()
                        .clickCreateAccountLink()
                        .enterFirstName(invalidFirstName)
                        .enterLastName(fakeData.getLastName())
                        .enterEmail(fakeData.getEmail())
                        .enterPassword(fakeData.getPassword())
                        .clickOnCustomerDataPrivacyCheckBox()
                        .clickOnAgreePrivacyPolicyCheckBox()
                        .clickSaveButton(false));
        String actualBorderColor = registrationPage.getColorOfFirstNameFieldBorderWhenInvalidName();
        softAssertions.assertThat(actualBorderColor)
                .as("Border Color is not as expected")
                .contains(expectedBorderColor);
        softAssertions.assertThat(registrationPage.getWarningMessage())
                .as("Warning Message is not as expected")
                .isEqualTo(expectedWarningMessage);
        softAssertions.assertAll();
    }
}
