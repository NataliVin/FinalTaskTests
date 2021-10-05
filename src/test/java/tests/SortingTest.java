package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;
import java.util.*;

public class SortingTest extends BaseTest{
    @Test
    public void checkThatProductsSortingByNameIsCorrect(){
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        AllProductsPage allProductsPage = mainPage.clickAllProductsButton();
        List<String> expectedSortedByNameProductsList = allProductsPage.getAllProductsNames();
        Collections.sort(expectedSortedByNameProductsList);

        List<String> actualSortedByNameProductsList = allProductsPage
                .clickSortByButton()
                .chooseSortByNameAtoZOption()
                .getAllProductsNames();
        //allProductsPage.clickNextButton();

        softAssertions.assertThat(actualSortedByNameProductsList)
                .as("Sorting by name A to Z is not correct")
                .isEqualTo(expectedSortedByNameProductsList);

//        expectedSortedByNameProductsList.sort(Comparator.reverseOrder());
//
//        List<Product> actualSortedProductsListReversed =allProductsPage
//                .clickSortByButton()
//                .chooseSortByNameZtoAOption()
//                .getAllProducts();
//        List<String> actualSortedProductsListNamesReversed = new ArrayList<>();
//        for (Product product:actualSortedProductsListReversed) {
//            actualSortedProductsListNamesReversed.add(product.getNameAsString());
//        }
//        softAssertions.assertThat(actualSortedProductsListNamesReversed)
//                .as("Sorting by name Z to A is not correct")
//                .isEqualTo(expectedSortedByNameProductsList);
        softAssertions.assertAll();
    }
}
