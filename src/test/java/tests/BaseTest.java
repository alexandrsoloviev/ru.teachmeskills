package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://teachmeskills.ru/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "117.0";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {
            {
                put("enableVNC", true);
                put("enableVideo", true);
            }
        });
        Configuration.browserCapabilities = capabilities;


    }

    public String getVideoStorageUrl() {
        return "http://localhost:4444/video/";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        Attach.browserConsoleLogs();


        Attach.addVideo(getVideoStorageUrl());


    }
}
