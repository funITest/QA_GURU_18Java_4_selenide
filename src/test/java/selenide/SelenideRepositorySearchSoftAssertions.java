package selenide;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearchSoftAssertions {

    @Test
    void shouldFindSelenide() {

        // Откройте страницу Selenide в Github
        Selenide.open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").pressEnter();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").shouldHave(text("SoftAssertions"));
        //sleep(5000);
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        // Откройте страницу SoftAssertions $(".details-reset .Truncate").click();
        //$(".details-reset").$(" a.Truncate-text").click();  $(withText("ull tex")).click();
        //Selenide.open("/SoftAssertions");
        //sleep(5000);
        // На странице SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".markdown-body ol li").last().shouldHave(text("JUnit5"));
        $(".markdown-body ol li:last-child").$("code").exists();

    }
}