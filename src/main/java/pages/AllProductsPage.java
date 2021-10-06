package pages;

import components.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AllProductsPage extends BasePage {
    public AllProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> AllProducts;

    @FindBy(xpath = "//a[@class='next js-search-link']")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement sortByButton;

    @FindBy(xpath = "//a[contains(text(),'Name, A to Z')]")
    private WebElement sortByNameAtoZOption;

    @FindBy(xpath = "//a[contains(text(),'Name, Z to A')]")
    private WebElement sortByNameZtoAOption;

    @FindBy(xpath = "//a[contains(text(),'Price, low to high')]")
    private WebElement sortByPriceLowToHighOption;

    @FindBy(xpath = "//a[contains(text(),'Price, high to low')]")
    private WebElement sortByPriceHighToLowOption;

    @FindBy(xpath = "//ul[@class='category-top-menu']//a[@class='text-uppercase h6']")
    private WebElement homeButton;

    public List<String> getAllProductsNames(int pageCount) {
        log.info("Getting names of all the products");
        List<String> allProductsList = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            waitUntilVisible(By.xpath("//div[@class='thumbnail-container reviews-loaded']"), 5);
            for (WebElement container : AllProducts) {
                allProductsList.add((new Product(container)).getNameAsString());
            }
            if (i + 1 < pageCount) {
                clickNextButton();
            } else {
                clickHomeButton();
            }
        }
        return allProductsList;
    }

    public List<Double> getAllProductsPrices(int pageCount) {
        log.info("Getting prices of all the products");
        List<Double> allProductsList = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            waitUntilVisible(By.xpath("//div[@class='thumbnail-container reviews-loaded']"), 5);
            for (WebElement container : AllProducts) {
                allProductsList.add((new Product(container)).getPriceAsDouble());
            }
            if (i + 1 < pageCount) {
                clickNextButton();
            } else {
                clickHomeButton();
            }
        }
        return allProductsList;
    }

    public AllProductsPage clickNextButton() {
        log.info("Clicking Next button");
        waitUntilClicable(By.xpath("//a[@class='next js-search-link']"), 3);
        nextButton.click();
        waitingForSpinner();
        return this;
    }

    public AllProductsPage clickHomeButton() {
        log.info("Clicking Home button");
        waitUntilClicable(By.xpath("//ul[@class='category-top-menu']//a[@class='text-uppercase h6']"), 3);
        homeButton.click();
        return this;
    }

    public AllProductsPage clickSortByButton() {
        log.info("Clicking Sort By button");
        waitUntilClicable(By.xpath("//button[@class='btn-unstyle select-title']"), 3);
        sortByButton.click();
        return this;
    }

    public AllProductsPage chooseSortByNameAtoZOption() {
        log.info("Choosing Sort By Name A to Z option by locator{}", sortByNameAtoZOption);
        waitUntilVisible(By.xpath("//div[@class='dropdown-menu']"), 3);
        sortByNameAtoZOption.click();
        waitingForSpinner();
        return this;
    }

    public AllProductsPage chooseSortByNameZtoAOption() {
        log.info("Choosing Sort By Name Z to A option");
        waitUntilVisible(By.xpath("//div[@class='dropdown-menu']"), 3);
        sortByNameZtoAOption.click();
        waitingForSpinner();
        return this;
    }

    public AllProductsPage chooseSortByPriceLowToHighOption() {
        log.info("Choosing Sort By Price Low to High option");
        waitUntilVisible(By.xpath("//div[@class='dropdown-menu']"), 3);
        sortByPriceLowToHighOption.click();
        waitingForSpinner();
        return this;
    }

    public AllProductsPage chooseSortByPriceHighToLowOption() {
        log.info("Choosing Sort By Price High to Low option");
        waitUntilVisible(By.xpath("//div[@class='dropdown-menu']"), 3);
        sortByPriceHighToLowOption.click();
        waitingForSpinner();
        return this;
    }

    public void waitingForSpinner() {
        waitUntilVisible(By.xpath("//span[@class='spinner']"), 5);
        waitUntilInvisible(By.xpath("//span[@class='spinner']"), 5);
    }
}
