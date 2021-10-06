package tests;

import components.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class PopularProductTest extends BaseTest {
    @Test
    public void checkThatPopularProductsHaveNameAndPriceAndCheckTheirAmount() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        int expectedAmountOfPopularProducts = 8;
        List<Product> actualPopularProductsList = mainPage
                .getAllPopularProducts();
        softAssertions.assertThat(actualPopularProductsList)
                .as("Actual amount of Popular Products is not as expected")
                .hasSize(expectedAmountOfPopularProducts);
        softAssertions.assertAll();
        for (Product product : actualPopularProductsList) {
            softAssertions.assertThat(product.getNameAsString())
                    .as("Product doesn't have a name")
                    .isNotEmpty();
            softAssertions.assertThat(product.getPriceAsDouble())
                    .as("Product price is not bigger than 0,00")
                    .isGreaterThan(0.00);
            softAssertions.assertThat(product.getPrice())
                    .as("Product doesn't have a price")
                    .isNotNull();
        }
    }
}
