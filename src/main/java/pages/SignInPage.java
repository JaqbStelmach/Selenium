package pages;

import dto.PersonalInformation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='SubmitCreate']//*[@type='submit']")
    WebElement createButton;
    @FindBy(id = "submitAccount")
    WebElement registerButton;
    @FindBy(id = "customer_firstname")
    WebElement firstnameInput;
    @FindBy(id = "customer_lastname")
    WebElement lastnameInput;
    @FindBy(id = "passwd")
    WebElement passwordInput;
    @FindBy(className = "alert-success")
    WebElement greenAlertBox;
    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    public void sendEmail() {
        emailInput.sendKeys("polishpierogi@test.com");
        createButton.click();
    }


    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(redAlertBox);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(greenAlertBox);
    }

    public boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }
    public void sendPersonalInformation(PersonalInformation personalInformation) {
        firstnameInput.sendKeys(personalInformation.getFirstname());
        lastnameInput.sendKeys(personalInformation.getLastname());
        passwordInput.sendKeys(personalInformation.getPassword());
        registerButton.click();
    }
}
