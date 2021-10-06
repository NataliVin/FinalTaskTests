package pages;

import components.Footer;
import components.Header;
import components.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MainPage extends BasePage {
    Footer footer;
    Header header;
    Actions actions = new Actions(getDriver());

    @FindBy(xpath = "//div[@class='product']")
    private List<WebElement> containers;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductsButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        footer = new Footer(getDriver());
        header = new Header(getDriver());
    }

    public String getTextFromTheSubscriptionSectionNearEmailField() {
        log.info("Getting text from the subscription section near email field");
        return footer.getTextByYourEmailAddressField().getText();
    }

    public String getTextFromTheSubscriptionSectionUnderEmailField() {
        log.info("Getting text from the subscription section under email field");
        return footer.getTextUnderEmailField().getText();
    }

    public String getNameFromTheSubscribeButton() {
        log.info("Getting name from the subscribe button");
        return footer.getSubscribeButton().getAttribute("value");
    }

    public boolean isNameOfTheSubscribeButtonInUppercase() {
        log.info("Getting information whether the name of the subscribe button is in uppercase");
        return footer.getSubscribeButton().getCssValue("text-transform").equalsIgnoreCase("uppercase");
    }

    public void clickLanguageButton() {
        log.info("Clicking the language button");
        header.getLanguageButton().click();
    }

    public List<WebElement> getListOfAllLanguages() {
        log.info("Getting a list of all languages");
        List<WebElement> listOfAllLanguages = header.getMenuWithAllLanguages()
                .findElements(By.xpath(".//li"));
        return listOfAllLanguages;
    }

    public LoginPage clickSignInButton() {
        log.info("Clicking the Sign In button");
        header.getSignInButton().click();
        return new LoginPage();
    }

    public MainPage moveMouseToClothesCategory() {
        log.info("Hovering mouse over Clothes category");
        waitUntilVisible(By.xpath("//li[@id='category-3']"),3);
        actions.moveToElement(header.getClothesLink()).build().perform();
        return this;
    }

    public MainPage moveMouseToAccessoriesCategory() {
        log.info("Hovering mouse over Accessories category");
        waitUntilVisible(By.xpath("//li[@id='category-6']"), 3);
        actions.moveToElement(header.getAccessoriesLink()).build().perform();
        return this;
    }

    public MainPage moveMouseToArtCategory() {
        log.info("Hovering mouse over Art category");
        actions.moveToElement(header.getArtLink()).build().perform();
        return this;
    }

    public List<String> getAllElementsFromSubMenu(String category) {
        switch (category) {
            case "Clothes":
                log.info("Getting all elements from Clothes submenu");
                waitUntilVisible(By.xpath("//li[@id='category-3']//li"),5);
                return header.getClothesSubMenu().stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            case "Accessories":
                log.info("Getting all elements from Accessories submenu");
                waitUntilVisible(By.xpath("//li[@id='category-6']//li"),5);
                return header.getAccessoriesSubMenu().stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            case "Art":
                log.info("Getting all elements from Art submenu");
                return header.getArtSubMenu().stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            default:
                throw new IllegalStateException("Wrong category");
        }
    }

    public List<Product> getAllPopularProducts() {
        log.info("Getting all popular products");
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts;
    }

    public OnSalePage clickPricesDropLink() {
        log.info("Clicking Price Drop link");
        footer.getPricesDropLink().click();
        return new OnSalePage();
    }

    public AllProductsPage clickAllProductsButton() {
        log.info("Clicking All Products button");
        allProductsButton.click();
        return new AllProductsPage();
    }
}
