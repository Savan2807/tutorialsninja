package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement clickOnSortBy;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList1;


    public String getDesktopText() {
        log.info("Verify the text ‘Desktops’" + desktopText.toString());
        return getTextFromElement(desktopText);
    }

    public ArrayList expectedList() {

        List<WebElement> products = productsList1;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }

        return originalProductsName;
    }

    public ArrayList getSortedProductList() {

        Collections.reverse(expectedList());
        List<WebElement> products = productsList;


        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        return afterSortByZToAProductsName;
    }

    public void selectFilter(String text) {
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        log.info("Select option product sorted by " + text + "from sort by options " + clickOnSortBy.toString());
    }

    public void clickOnProduct(String productName) {
        List<WebElement> products = productsList1;
        for (WebElement e : products) {
            if (e.getText().equalsIgnoreCase(productName)) {
                e.click();
                log.info("Clicking on " + productName + " " + e.toString());
                break;
            }
        }
    }
}
