package pages;

import components.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class OnSalePage extends BasePage {
    public OnSalePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='thumbnail-container reviews-loaded']")
    private List<WebElement> onSaleProducts;

    public List<Product> getAllOnSaleProducts() {
        log.info("Getting all on sale products");
        List<Product> allOnSaleProducts = new ArrayList<>();
        for (WebElement container : onSaleProducts) {
            allOnSaleProducts.add(new Product(container));
        }
        return allOnSaleProducts;
    }
}
