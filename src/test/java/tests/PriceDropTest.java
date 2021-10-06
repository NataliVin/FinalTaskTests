package tests;

import components.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class PriceDropTest extends BaseTest {
    @Test
    public void checkThatEveryProductHasOldPriceAndCorrectNewPrice() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        double expectedPromoPrice;

        List<Product> actualOnSaleProductsList = mainPage
                .clickPricesDropLink()
                .getAllOnSaleProducts();
        for (Product product : actualOnSaleProductsList) {
            expectedPromoPrice = product.getOldPriceAsDouble() - (product.getOldPriceAsDouble() / 100 * product.getDiscount());

            softAssertions.assertThat(product.getPrice())
                    .as("Product doesn't have a new price")
                    .isNotNull();
            softAssertions.assertThat(product.getOldPrice())
                    .as("Product doesn't have an old price")
                    .isNotNull();
            softAssertions.assertThat(product.getPriceAsDouble())
                    .as("Promo price is not correct")
                    .isEqualTo(Math.floor(expectedPromoPrice * 1e2) / 1e2);
            softAssertions.assertAll();
        }
    }
}
