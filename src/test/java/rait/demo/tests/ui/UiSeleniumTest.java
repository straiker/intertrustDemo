package rait.demo.tests.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import rait.demo.data.TestData;
import rait.demo.pageobjects.landingpage.LandingPageObject;

public class UiSeleniumTest {

    LandingPageObject lPage;
    WebDriver driver;

    @BeforeEach
    void setUp(){
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void cleanUp(){
        driver.quit();
    }

    @Test
    public void uiTest(){
        driver.get(TestData.WEBSITE_URL);
        lPage = new LandingPageObject(this.driver);
        lPage.handleCookies()
                .clickWeatherData()
                .enterLocation(TestData.CITY_NAME)
                .clickSearch()
                .assertLocationCorrect(TestData.CITY_NAME);
    }

}
