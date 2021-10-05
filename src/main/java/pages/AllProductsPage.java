package pages;

import components.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AllProductsPage extends BasePage{
    public AllProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = ".//div[@class='thumbnail-container reviews-loaded']")
    private List<WebElement> AllProducts;

    @FindBy(xpath = ".//a[@class='next js-search-link']")
    private WebElement nextButton;

    @FindBy(xpath = ".//button[@class='btn-unstyle select-title']")
    private WebElement sortByButton;

    @FindBy(xpath = ".//a[contains(text(),'Name, A to Z')]")
    private WebElement sortByNameAtoZOption;

    @FindBy(xpath = ".//a[contains(text(),'Name, Z to A')]")
    private WebElement sortByNameZtoAOption;

    @FindBy(xpath = ".//a[contains(text(),'Price, low to high')]")
    private WebElement sortByPriceLowToHighOption;

    @FindBy(xpath = ".//a[contains(text(),'Price, high to low')]")
    private WebElement sortByPriceHighToLowOption;



    public List<String> getAllProductsNames() {
        log.info("Getting names of all the products");
        List<String> allProductsList= new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='thumbnail-container reviews-loaded']")));
        for (WebElement container : AllProducts) {
            allProductsList.add((new Product(container)).getNameAsString());
        }
//        clickNextButton();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='thumbnail-container reviews-loaded']")));
//        for (WebElement container : AllProducts) {
//            allProductsList.add(new Product(container).getNameAsString());
//        }
        return allProductsList;
    }

    public AllProductsPage clickNextButton(){
        log.info("Clicking Next button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='thumbnail-container reviews-loaded']")));
        nextButton.click();
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product']")));
        return this;
    }

    public AllProductsPage clickSortByButton(){
        log.info("Clicking Sort By button");
        sortByButton.click();
        return this;
    }
    public AllProductsPage chooseSortByNameAtoZOption(){
        log.info("Choosing Sort By Name A to Z option by locator{}",sortByNameAtoZOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='dropdown-menu']")));
        sortByNameAtoZOption.click();
        return this;
    }
    public AllProductsPage chooseSortByNameZtoAOption(){
        log.info("Choosing Sort By Name Z to A option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='dropdown-menu']")));
        sortByNameZtoAOption.click();
        return this;
    }

    public AllProductsPage chooseSortByPriceLowToHighOption(){
        log.info("Choosing Sort By Price Low to High option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='dropdown-menu']")));
        sortByPriceLowToHighOption.click();
        return this;
    }
    public AllProductsPage chooseSortByPriceHighToLowOption(){
        log.info("Choosing Sort By Price High to Low option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='dropdown-menu']")));
        sortByPriceHighToLowOption.click();
        return this;
    }
}
