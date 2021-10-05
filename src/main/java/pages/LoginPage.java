package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='no-account']//a")
    private WebElement createAccountLink;

    public RegistrationPage clickCreateAccountLink() {
        log.info("Clicking Create Account link");
        createAccountLink.click();
        return new RegistrationPage();
    }
}
