package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input[@type='text']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//i[@class = 'fa fa-refresh']")
    WebElement updateButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement updateSuccessText;
    @CacheLookup
    @FindBy(css = "a.btn.btn-primary")
    WebElement checkoutButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;

    public String getShoppingCartText() {
        log.info(" Verify the text Shopping Cart " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String getAllProductText() {
        log.info("Verify the Product name " + productNameText.toString());
        return getTextFromElement(productNameText);
    }

    public String getModelText() {
        log.info("Getting model details in shopping cart : " + modelText.toString());
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        log.info("Getting total amount in shopping cart : " + totalText.toString());
        return getTextFromElement(totalText);
    }

    public void changeQuantityForProduct(String text) {
        quantityField.clear();
        sendTextToElement(quantityField, text);
        log.info("Change Quantity " + text + " to quantity field " + quantityField.toString());
    }

    public void clickOnUpdateQuantity() {
        clickOnElement(updateButton);
        log.info(" Click on “Update” Tab " + updateButton.toString());
    }

    public String getUpdateSuccessfullyText() {
        log.info("Getting welcome back text " + updateSuccessText.toString());
        return getTextFromElement(updateSuccessText);
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
        log.info("Click on “Checkout” button " + checkoutButton.toString());
    }
}