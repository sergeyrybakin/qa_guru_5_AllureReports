package tests;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {
    static final String BASE_URL = "https://github.com";
    static final String REPOSITORY = "selenide/selenide";
    static final String LINK = "Issues";
    static final String SEARCH_CRITERIA = "is:issue sergeyrybakin";
    static final String EXPECTED_RESULT = "Feature request: add Condition attributeContainsValue";

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }
}
