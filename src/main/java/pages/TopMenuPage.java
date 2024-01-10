package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(linkText = "Women")
    WebElement womenLink;
    @FindBy(className = "login")
    WebElement signInLink;
    @FindBy(className = "blockbestsellers")
    WebElement bestSellersLink;

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnWomenLink() {
        womenLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public void clickOnBestSellersLink() {
        bestSellersLink.click();
    }
}
