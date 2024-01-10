package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".right-block .price")
    List<WebElement> productPrice;


    public List<String> getProductPrice() {
        List<String> productPrice = this.productPrice.stream()
                .map(e -> e.getText())
                .map(e -> e.replace("$", ""))
                .collect(Collectors.toList());
        return productPrice;
    }
}
