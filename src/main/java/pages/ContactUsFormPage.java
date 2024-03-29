package pages;

import dto.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ContactUsFormPage extends BasePage {
    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;
    @FindBy(className = "alert-danger")
    WebElement redAlertBox;
    @FindBy(id = "id_contact")
    WebElement subjectSelect;
    @FindBy(id = "email")
    WebElement emailInut;
    @FindBy(id = "id_order")
    WebElement orderReferenceInput;
    @FindBy(id = "message")
    WebElement messageArea;
    @FindBy(className = "alert-success")
    WebElement greenAlertBox;
    public void  clickOnSendButton() {
        sendButton.click();
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
    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInut.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageArea.sendKeys(message.getMessage());
        sendButton.click();
    }
}
