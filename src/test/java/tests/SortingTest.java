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
    public void checkThatProductsSortingByNameIsCorrect() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        int amountOfPages=2;
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

        List<String> actualReversedSortedByNameProductsList =allProductsPage
                .clickSortByButton()
                .chooseSortByNameZtoAOption()
                .getAllProductsNames(amountOfPages);

        softAssertions.assertThat(actualReversedSortedByNameProductsList)
                .as("Sorting by name Z to A is not correct")
                .isEqualTo(expectedSortedByNameProductsList);
        softAssertions.assertAll();
    }
}
