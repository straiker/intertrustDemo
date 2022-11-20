package rait.demo.tests.ui;

/*
*
*   UI test using MS Playwright
*
* */

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;
import rait.demo.data.TestData;
import rait.demo.pageobjects.landingpage.LandingPageObject;

public class UiTest {
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launch(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @BeforeEach
    void setup(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext(){
        context.close();
    }

    @AfterAll
    static void closeBrowser(){
        playwright.close();
    }

    @Test
    public void searchCityTest(){
        page.navigate(TestData.WEBSITE_URL);

        LandingPageObject lPage = new LandingPageObject(page);

        lPage.pwHandleCookies()
                .pwClickWeatherData()
                .pwEnterLocation(TestData.CITY_NAME)
                .pwClickSearch()
                .pwAssertLocationCorrect(TestData.CITY_NAME);


    }
}
