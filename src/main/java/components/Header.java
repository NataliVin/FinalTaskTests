package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
public class Header {
    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='material-icons expand-more']")
    private WebElement languageButton;

    @FindBy(xpath = "//a[@data-iso-code]")
    private List<WebElement> menuWithAllLanguages;

    @FindBy(xpath = "//div[@class='user-info']//a")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down']")
    private WebElement userName;

    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement clothesLink;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesLink;

    @FindBy(xpath = "//li[@id='category-9']//a")
    private WebElement artLink;

    @FindBy(xpath = "//li[@id='category-3']//li")
    private List<WebElement> clothesSubMenu;

    @FindBy(xpath = "//li[@id='category-6']//li")
    private List<WebElement> accessoriesSubMenu;

    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> artSubMenu;
}
