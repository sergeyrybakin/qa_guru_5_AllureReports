package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class GitHubIssueSearchSelenide extends TestBase {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "selenide/selenide";
    private static final String SEARCH_CRITERIA = "sergeyrybakin";
    private static final String EXPECTED_RESULT = "Feature request: add Condition attributeContainsValue";

    @Test
    public void issueSelenideSimpleSearch() {
        Selenide.open(BASE_URL);
        //Find repository
        $("input[name=q]").click();
        $("input[name=q]").val(REPOSITORY).submit();

        //Open repository
        $(By.linkText(REPOSITORY)).click();
    }
}
