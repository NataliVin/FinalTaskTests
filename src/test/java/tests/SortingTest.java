package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTest extends BaseTest {
    @Test
    public void checkThatProductsSortingByNameWorksCorrectly() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        int amountOfPages = 2;
        AllProductsPage allProductsPage = mainPage.clickAllProductsButton();
        List<String> expectedSortedByNameProductsList = allProductsPage.getAllProductsNames(amountOfPages);
        Collections.sort(expectedSortedByNameProductsList);
        List<String> actualSortedByNameProductsList = allProductsPage
                .clickSortByButton()
                .chooseSortByNameAtoZOption()
                .getAllProductsNames(amountOfPages);
        softAssertions.assertThat(actualSortedByNameProductsList)
                .as("Sorting by name A to Z is not correct")
                .isEqualTo(expectedSortedByNameProductsList);

        expectedSortedByNameProductsList.sort(Comparator.reverseOrder());

        List<String> actualReversedSortedByNameProductsList = allProductsPage
                .clickSortByButton()
                .chooseSortByNameZtoAOption()
                .getAllProductsNames(amountOfPages);

        softAssertions.assertThat(actualReversedSortedByNameProductsList)
                .as("Sorting by name Z to A is not correct")
                .isEqualTo(expectedSortedByNameProductsList);
    }

    @Test
    public void checkThatProductsSortingByPriceWorksCorrectly() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        int amountOfPages = 2;
        AllProductsPage allProductsPage = mainPage.clickAllProductsButton();
        List<Double> expectedSortedByPriceProductsList = allProductsPage.getAllProductsPrices(amountOfPages);
        Collections.sort(expectedSortedByPriceProductsList);
        List<Double> actualSortedByPriceProductsList = allProductsPage
                .clickSortByButton()
                .chooseSortByPriceLowToHighOption()
                .getAllProductsPrices(amountOfPages);
        softAssertions.assertThat(actualSortedByPriceProductsList)
                .as("Sorting by price low to high is not correct")
                .isEqualTo(expectedSortedByPriceProductsList);

        expectedSortedByPriceProductsList.sort(Comparator.reverseOrder());

        List<Double> actualReversedSortedByPriceProductsList = allProductsPage
                .clickSortByButton()
                .chooseSortByPriceHighToLowOption()
                .getAllProductsPrices(amountOfPages);
        softAssertions.assertThat(actualReversedSortedByPriceProductsList)
                .as("Sorting by price low to high is not correct")
                .isEqualTo(expectedSortedByPriceProductsList);

        softAssertions.assertAll();

    }
}
