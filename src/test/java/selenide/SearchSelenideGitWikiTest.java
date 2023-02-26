package selenide;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideGitWikiTest {

    @Test
    void findSelenide() {
        Selenide.open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").pressEnter();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").shouldHave(text("SoftAssertions"));
        // Откройте страницу SoftAssertions
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        // На странице SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".markdown-body ol li").last().$("code").shouldHave(text("junit5"));
    }
}