package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MtsMainPage {
    public void openPage() {
        open("/");
    }

    public void clickTopMenuItem(String menuItem) {
        $$("a[data-testid='link']").findBy(text(menuItem)).shouldBe(visible).click();
    }

    public void checkHeader(String expectedHeader) {
        $("h1").shouldHave(text(expectedHeader));
    }
}