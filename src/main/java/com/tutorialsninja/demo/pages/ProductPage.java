package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartButtonOnTop;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calenderButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker-days']//table//th[@class='picker-switch']")
    WebElement monthYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]//table//th[normalize-space()='›']")
    WebElement nextButtonOfCalender;
    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']//table//td")
    List<WebElement> dayText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement quantityField;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement getSuccessText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement productText;

    public String getProductText() {
        log.info("Verify Product name : " + productText.toString());
        return getTextFromElement(productText);
    }

    public void selectDate(String year, String month, String date) {
        clickOnElement(calenderButton);
        log.info("Select " + year + month + date + " to date field " + calenderButton.toString());
        while (true) {
            String monthAndYear = monthYearText.getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOfCalender);
            }
        }
        List<WebElement> allDates = dayText;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }


    public void clickOnAddToCartButton() {
        mouseHoverToElementAndClick(addToCartButton);
        log.info("Clicking on Login Button " + addToCartButton.toString());
    }

    public String getProductSuccessText() {
        log.info("Verify the Message “Success: You have added product to your shopping cart!” " + getSuccessText.toString());
        return getTextFromElement(getSuccessText);
    }

    public void clickOnShoppingCartButtonOnTop() {
        clickOnElement(shoppingCartButtonOnTop);
        log.info("Clicking on shopping cart Button " + shoppingCartButtonOnTop.toString());
    }


    public void clickOnShoppingCartButton() {
        mouseHoverToElementAndClick(shoppingCartButton);
        log.info("Click on link “shopping cart” display into success message " + shoppingCartButton.toString());
    }
}
