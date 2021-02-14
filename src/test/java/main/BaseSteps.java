package main;

import io.qameta.allure.Step;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseSteps {
    private static final String BASE_URL = "https://github.com";
    private static final String LINK = "Issues";

    @Step("Открыть страницу")
    public void openMainPage() {
        Selenide.open(BASE_URL);
    }

    @Step("Найти репозиторий \"{repository}\"")
    public void searchForRepository(final String repository) {
        $("input[name=q]").click();
        $("input[name=q]").val(repository).submit();
    }

    @Step("Открыть ссылку \"{repository}\"")
    public void openLink(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Кликнуть на \"" + LINK + "\" в верхнем меню")
    public void clickOnIssuesInTopMenu() {
        $(withText(LINK)).click();
    }

    @Step("Сделать поиск по \"{criteria}\"")
    public void searchForCriteria(final String criteria) {
        $("#js-issues-search").clear();
        $("#js-issues-search").val(criteria).submit();
    }

    @Step("Ожидаемый результат \"{expectedResult}\" должен появиться.")
    public void verifyResult(final String expectedResult) {
        $$("div.js-navigation-container div").findBy(text(expectedResult)).shouldBe(appear);
    }
}
