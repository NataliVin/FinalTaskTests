package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class RegistrationPage extends BasePage {
    public RegistrationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='input-group js-parent-focus']//input")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyCheckBox;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='psgdpr']")
    private WebElement agreePrivacyPolicyCheckBox;

    @FindBy(xpath = "//footer[@class='form-footer clearfix']//button")
    private WebElement saveButton;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement warningMessage;

    public RegistrationPage enterFirstName(String firstName) {
        log.info("Entering first name{}", firstName);
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        log.info("Entering last name{}", lastName);
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        log.info("Entering email{}", email);
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        log.info("Entering password{}", password);
        passwordField.sendKeys(password);
        return this;
    }

    public RegistrationPage clickOnCustomerDataPrivacyCheckBox() {
        log.info("Clicking on customer data privacy checkbox");
        customerDataPrivacyCheckBox.click();
        return this;
    }

    public RegistrationPage clickOnAgreePrivacyPolicyCheckBox() {
        log.info("Clicking on agree privacy policy checkbox");
        agreePrivacyPolicyCheckBox.click();
        return this;
    }

    public BasePage clickSaveButton(Boolean isRegistratedSuccesful) {
        log.info("Clicking on Save button");
        if (isRegistratedSuccesful) {
            saveButton.click();
            return new UserPage();
        }
        saveButton.click();
        return this;
    }

    public String getColorOfFirstNameFieldBorderWhenInvalidName() {
        log.info("Getting color of the invalid first name field border");
        return firstNameField.getCssValue("outline");
    }

    public String getWarningMessage() {
        log.info("Getting warning message when invalid data is used during registration");
        return warningMessage.getText();
    }
}
