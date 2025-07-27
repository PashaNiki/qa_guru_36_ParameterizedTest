package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MtsMainPage;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.Arguments;

@Tag("regression")
public class TopMenuMethodSourceTest extends TestBase {

    MtsMainPage mainPage = new MtsMainPage();

    static Stream<Arguments> menuDataProvider() {
        return Stream.of(
                arguments("Кредит", "Кредиты"),
                arguments("Карты", "Банковские карты")
        );
    }

    @ParameterizedTest(name = "Клик по {0} — заголовок {1}")
    @MethodSource("menuDataProvider")
    void menuMethodSourceTest(String menuItem, String expectedHeader) {
        mainPage.openPage();
        mainPage.clickTopMenuItem(menuItem);
        mainPage.checkHeader(expectedHeader);
    }
}
