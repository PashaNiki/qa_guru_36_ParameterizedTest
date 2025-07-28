package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import pages.MtsMainPage;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("regression")
public class TopMenuMethodSourceTest extends TestBase {

    MtsMainPage mainPage = new MtsMainPage();

    static Stream<Arguments> topMenuItemsWithHeaders() {
        return Stream.of(
                arguments("Кредиты", "Кредиты"),
                arguments("Карты", "Банковские карты"),
                arguments("Вклады и счета", "Вклады и счета")
        );
    }

    @ParameterizedTest(name = "Клик по \"{0}\" — заголовок должен быть \"{1}\"")
    @MethodSource("topMenuItemsWithHeaders")
    void menuNavigationShouldOpenExpectedHeader(String menuItem, String expectedHeader) {
        mainPage.openPage();
        mainPage.clickTopMenuItem(menuItem);
        mainPage.checkHeader(expectedHeader);
    }
}
