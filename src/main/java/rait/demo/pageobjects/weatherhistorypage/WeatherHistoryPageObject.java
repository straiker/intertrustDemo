package rait.demo.pageobjects.weatherhistorypage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherHistoryPageObject {
    WebDriver driver;
    Page page;

    By h1Header = By.xpath("//h1");

    Locator pwH1Header;

    public WeatherHistoryPageObject(WebDriver driver){
        this.driver = driver;
    }

    public WeatherHistoryPageObject(Page page){
        this.page = page;
        pwH1Header = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setLevel(1));
    }

    public WeatherHistoryPageObject assertLocationCorrect(String location){
        assertTrue(driver.findElement(h1Header).getText().contains(location));
        assertTrue(driver.findElement(By.linkText(location)).isDisplayed());
        return this;
    }

    public WeatherHistoryPageObject pwAssertLocationCorrect(String location){
        assertTrue(pwH1Header.innerText().contains(location));
        assertTrue(page.getByText(location).isVisible());
        return this;
    }
}
