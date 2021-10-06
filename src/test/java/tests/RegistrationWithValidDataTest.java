package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.UserPage;
import utilities.FakeData;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationWithValidDataTest extends BaseTest {
    @Test
    public void checkThatUsersNameAppearsAfterRegistration() {
        MainPage mainPage = new MainPage();
        FakeData fakeData = new FakeData();
        String expectedResult = fakeData.getFirstName() + " " + fakeData.getLastName();
        UserPage userPage =
                ((UserPage) mainPage.clickSignInButton()
                        .clickCreateAccountLink()
                        .enterFirstName(fakeData.getFirstName())
                        .enterLastName(fakeData.getLastName())
                        .enterEmail(fakeData.getEmail())
                        .enterPassword(fakeData.getPassword())
                        .clickOnCustomerDataPrivacyCheckBox()
                        .clickOnAgreePrivacyPolicyCheckBox()
                        .clickSaveButton(true));
        String actualName = userPage.getUserNameAsString();
        assertThat(actualName)
                .as("User name is not as registered")
                .isEqualTo(expectedResult);
    }
}
