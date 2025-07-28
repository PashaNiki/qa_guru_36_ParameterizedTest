package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MtsMainPage;

@Tag("regression")
public class TopMenuValueSourceTest extends TestBase {

    MtsMainPage mainPage = new MtsMainPage();

    @ParameterizedTest(name = "Меню содержит пункт: {0}")
    @ValueSource(strings = {"Кредиты", "Карты", "Вклады и счета"})
    void menuItemPresenceTest(String menuItem) {
        mainPage.openPage();
        mainPage.checkMenuItemVisible(menuItem);
    }
}
