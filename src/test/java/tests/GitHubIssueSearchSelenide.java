package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubIssueSearchSelenide extends TestBase {

    @Test
    public void issueSelenideSimpleSearch() {
        Selenide.open(BASE_URL);
        //Find repository
        $("input[name=q]").click();
        $("input[name=q]").val(REPOSITORY).submit();

        //Open repository
        $(By.linkText(REPOSITORY)).click();

        //Click on Issues in top menu
        $(withText("Issues")).click();

        //Find my request
        $("#js-issues-search").clear();
        $("#js-issues-search").val(SEARCH_CRITERIA).submit();

        //Expected result:
        $$("div.js-navigation-container div").findBy(text(EXPECTED_RESULT)).shouldBe(appear);
    }
}
