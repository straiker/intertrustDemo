package rait.demo.pageobjects.weatherdatapage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rait.demo.pageobjects.weatherhistorypage.WeatherHistoryPageObject;

public class WeatherDataPageObject {
    WebDriver driver;
    Page page;

    By searchField = By.xpath("//input[@placeholder='Enter a location']");
    By searchButton = By.xpath("//button[contains(text(), 'Search')]");

    Locator pwSearchField;
    Locator pwSearchButton;

    public WeatherDataPageObject(WebDriver driver){
        this.driver = driver;
    }

    public WeatherDataPageObject(Page page){
        this.page = page;
        pwSearchField = page.getByPlaceholder("Enter a location");
        pwSearchButton = page.getByText("Search");
    }

    public WeatherDataPageObject enterLocation(String location){
        driver.findElement(searchField).sendKeys(location);
        return this;
    }

    public WeatherHistoryPageObject clickSearch(){
        driver.findElement(searchButton).click();
        return new WeatherHistoryPageObject(driver);
    }

    public WeatherDataPageObject pwEnterLocation(String location){
        pwSearchField.fill(location);
        return this;
    }

    public WeatherHistoryPageObject pwClickSearch(){
        pwSearchButton.click();
        return new WeatherHistoryPageObject(page);
    }
}
