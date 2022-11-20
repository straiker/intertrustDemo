package rait.demo.pageobjects.landingpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rait.demo.pageobjects.weatherdatapage.WeatherDataPageObject;

public class LandingPageObject {
    WebDriver driver;
    Page page;

    // Locators
    By weatherData = By.linkText("Weather Data");
    By errorModal = By.id("errorModal");
    By acceptCookies = By.xpath("//button[contains(text(), 'Accept all cookies')]");

    Locator pwWeatherData;
    Locator pwAcceptCookies;

    public LandingPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPageObject(Page page) {
        this.page = page;
        pwWeatherData = page.getByText("Weather Data").first();
        pwAcceptCookies = page.getByText("Accept all cookies");
    }

    public LandingPageObject handleCookies(){
        driver.findElement(errorModal).isDisplayed();
        driver.findElement(acceptCookies).click();

        return this;
    }

    public WeatherDataPageObject clickWeatherData(){
        driver.findElements(weatherData).get(0).click();
        return new WeatherDataPageObject(driver);
    }

    public LandingPageObject pwHandleCookies(){
        pwAcceptCookies.click();
        return this;
    }

    public WeatherDataPageObject pwClickWeatherData(){
        return new WeatherDataPageObject(page);
    }
}
