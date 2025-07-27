package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MtsMainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

@Tag("regression")
public class TopMenuValueSourceTest extends TestBase {

    MtsMainPage mainPage = new MtsMainPage();

    @ParameterizedTest(name = "Меню содержит пункт: {0}")
    @ValueSource(strings = {"Кредит", "Карты", "Вклады"})
    void menuItemPresenceTest(String menuItem) {
        mainPage.openPage();
        $$(".header__main-nav a").findBy(text(menuItem)).shouldBe(visible);
    }
}