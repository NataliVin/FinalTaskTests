package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubMenuTest extends BaseTest {
    @Test
    public void checkSubMenuOfTheCategories() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> expectedClothesSubmenu = new ArrayList<>((Arrays.asList("MEN", "WOMEN")));
        List<String> expectedAccessoriesSubmenu = new ArrayList<>((Arrays.asList("STATIONERY", "HOME ACCESSORIES")));
        List<String> actualClothesSubmenu = mainPage
                .moveMouseToClothesCategory()
                .getAllElementsFromSubMenu("Clothes");
        List<String> actualAccessoriesSubmenu = mainPage
                .moveMouseToAccessoriesCategory()
                .getAllElementsFromSubMenu("Accessories");
        List<String> actualArtSubmenu = mainPage
                .moveMouseToArtCategory()
                .getAllElementsFromSubMenu("Art");
        softAssertions.assertThat(actualClothesSubmenu)
                .as("Actual Clothes submenu is not as expected")
                .isEqualTo(expectedClothesSubmenu);
        softAssertions.assertThat(actualAccessoriesSubmenu)
                .as("Actual Accessories submenu is not as expected")
                .isEqualTo(expectedAccessoriesSubmenu);
        softAssertions.assertThat(actualArtSubmenu)
                .as("Actual Art submenu is not as expected")
                .hasSize(0);
        softAssertions.assertAll();
    }
}
