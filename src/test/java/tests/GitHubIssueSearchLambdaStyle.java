package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssueSearchLambdaStyle extends TestBase {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "selenide/selenide";
    private static final String SEARCH_CRITERIA = "is:issue sergeyrybakin";
    private static final String LINK = "Issues";
    private static final String EXPECTED_RESULT = "Feature request: add Condition attributeContainsValue";

    @Test
    @Owner("sergeyrybakin")
    @Tags({@Tag ("web"),@Tag("critical")})

    @Feature(LINK)
    @Story("Поиск в репозитории " + REPOSITORY + " по критерию " + SEARCH_CRITERIA)
    @DisplayName("Поиск в GitHub репозитории по запросу.")
    public void issueSelenideSimpleSearch() {
        parameter("Repository: ", REPOSITORY);
        parameter("Search criteria: ", SEARCH_CRITERIA);

        step("Открыть страницу \"" + BASE_URL + "\"", ()->{
            Selenide.open(BASE_URL);
        });

        step("Найти репозиторий \"" + REPOSITORY + "\"", ()->{
            $("input[name=q]").click();
            $("input[name=q]").val(REPOSITORY).submit();
        });


        step("Открыть ссылку \"" + REPOSITORY + "\"", ()->{
            $(By.linkText(REPOSITORY)).click();
        });

        step("Кликнуть на \"" + LINK + "\" в верхнем меню", ()->{
            $(withText(LINK)).click();
        });

        step("Сделать поиск по \"" + SEARCH_CRITERIA + "\"", ()->{
            $("#js-issues-search").clear();
            $("#js-issues-search").val(SEARCH_CRITERIA).submit();
        });

        step("Ожидаемый результат \"" + EXPECTED_RESULT + "\" должен появиться.", ()->{
            $$("div.js-navigation-container div").findBy(text(EXPECTED_RESULT)).shouldBe(appear);
        });
    }
}
