package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MtsMainPage;

@Tag("smoke")
public class TopMenuCsvTest extends TestBase {

    MtsMainPage mainPage = new MtsMainPage();

    @ParameterizedTest(name = "По клику на \"{0}\" должен открыться заголовок \"{1}\"")
    @CsvSource(value = {
            "Кредиты, Кредиты",
            "Карты, Банковские карты",
            "Вклады и счета, Вклады и счета"
    })
    void topMenuShouldOpenCorrectHeader(String menuItem, String expectedHeader) {
        mainPage.openPage();
        mainPage.clickTopMenuItem(menuItem);
        mainPage.checkHeader(expectedHeader);
    }
}
