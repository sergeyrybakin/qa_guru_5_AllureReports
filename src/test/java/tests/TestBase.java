package tests;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }
}
