package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Footer {
    @FindBy(xpath = "//p[@id='block-newsletter-label']")
    private WebElement textByYourEmailAddressField;

    @FindBy(xpath = "//div[@class='col-xs-12']//p")
    private WebElement textUnderEmailField;

    @FindBy(xpath = "//input[@class='btn btn-primary float-xs-right hidden-xs-down']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//a[@id='link-product-page-prices-drop-1']")
    private WebElement pricesDropLink;

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
