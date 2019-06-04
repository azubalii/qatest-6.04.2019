package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//td/a[contains(text(),'2')]")
    private WebElement navigationButton2;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return !searchResults.isEmpty();
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public boolean isSearchTermPresent(String searchTerm) {
        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
                return false;
            }
        }
        return true;

    }

    public GoogleResultsPage getSecondResultsPage() {
        navigationButton2.click();
        return new GoogleResultsPage(driver);
    }

}
