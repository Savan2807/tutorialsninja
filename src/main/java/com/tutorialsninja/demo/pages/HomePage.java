package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuTabs;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotebookTab;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundSterling;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    List<WebElement> myAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = topMenuTabs;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuTabs;
        }
        log.info("Click " + menu + " from homepage Top menu  " + topMenuTabs.toString());
    }

    public void mouseHoverAndClickOnDesktopTab() {
        mouseHoverToElementAndClick(desktopTab);
        log.info("Mouse hover on desktops Tab and click " + desktopTab.toString());

    }

    public void mouseHoverAndClickOnLaptopAndNoteBooksTab() {
        mouseHoverToElementAndClick(laptopAndNotebookTab);
        log.info("Mouse hover on laptop And Notebook Tab and click " + laptopAndNotebookTab.toString());

    }

    public void mouseHoverAndClickOnDComponentsTab() {
        mouseHoverToElementAndClick(componentsTab);
        log.info("Mouse hover on components Tab and click " + componentsTab.toString());

    }


    public void clickOnCurrency() {
        clickOnElement(currencyLink);
        log.info("Clicking on Currency on top of page " + currencyLink.toString());
    }

    public void clickOn£PoundSterling() {
        clickOnElement(poundSterling);
        log.info("Clicking on £Pound Sterling on top of page " + poundSterling.toString());
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
        log.info("Select " + option + " from myAccount drop down list " + myAccountOptions.toString());
    }

    public void clickOnMyAccountLink() {
        Reporter.log("Clicking on My Account Link " + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }
}
