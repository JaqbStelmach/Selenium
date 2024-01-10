package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BestSellersSectionPage extends BasePage{
    public BestSellersSectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-name")
    List<WebElement> productNames;

    public List<String> getProductNames() {
        return productNames.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
