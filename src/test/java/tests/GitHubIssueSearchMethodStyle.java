package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class GitHubIssueSearchMethodStyle extends TestBase {
    public BaseSteps steps = new BaseSteps();

    @Owner("sergeyrybakin")
    @Tags({@Tag("web"),@Tag("critical")})

    @Feature(LINK)
    @Story("Поиск в репозитории " + REPOSITORY + " по критерию " + SEARCH_CRITERIA)
    @DisplayName("Method style: Поиск в GitHub репозитории по запросу.")
    @Test
    public void searchIssue() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openLink(REPOSITORY);
        steps.clickOnIssuesInTopMenu();
        steps.searchForCriteria(SEARCH_CRITERIA);
        steps.verifyResult(EXPECTED_RESULT);
    }
}
