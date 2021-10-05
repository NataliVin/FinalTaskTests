package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
public class Product {
    private WebElement name;
    private String nameAsString;
    private WebElement price;
    private double priceAsDouble;
    private WebElement oldPrice;
    private double oldPriceAsDouble;
    private int discount;
    private String discountAsString;

    public Product(WebElement container) {
        this.name = container.findElement(By.xpath("//*[@class='h3 product-title']"));
        this.nameAsString = name.getText();
        if (!container.findElement(By.xpath("//span[@class='regular-price']")).isDisplayed()) {
            this.oldPrice = null;
            this.oldPriceAsDouble=0.00;
        } else {
            this.oldPrice = container.findElement(By.xpath("//span[@class='regular-price']"));
            this.oldPriceAsDouble = Double.parseDouble(oldPrice.getText().replace("€", ""));

        }
        this.price = container.findElement(By.xpath("//span[@class='price']"));
        this.priceAsDouble = Double.parseDouble(price.getText().replace("€", ""));
        if(container.findElements(By.xpath("//li[@class='product-flag discount']")).size()>0){
            this.discountAsString = container
                    .findElement(By.xpath("//li[@class='product-flag discount']"))
                    .getText()
                    .replace("-", "")
                    .replace("%", "");
            this.discount = Integer.parseInt(discountAsString);
        } else {
            discount = 0;
        }
    }
}