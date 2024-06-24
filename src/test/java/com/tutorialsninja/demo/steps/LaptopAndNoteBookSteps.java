package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CheckOutPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class LaptopAndNoteBookSteps {
    @Then("I should see product arrange in price high to low order successfully")
    public void iShouldSeeProductArrangeInPriceHighToLowOrderSuccessfully() {
        //1.4 Verify the Product price will arrange in High to Low order.
        List<Double> expectedList = new LaptopsAndNotebooksPage().priceHighToLow();
        List<Double> actualList = new LaptopsAndNotebooksPage().getPriceHighToLow();
        Assert.assertEquals(actualList, expectedList);
    }

    @And("I select product {string} from laptop and notebook page")
    public void iSelectProductFromLaptopAndNotebookPage(String product) {
        //2.4 Select Product “HpLp”
        new LaptopsAndNotebooksPage().clickOnProductHpLp(product);
    }

    @And("I should navigate to {string} product")
    public void iShouldNavigateToProduct(String product) {
        Assert.assertEquals(new ProductPage().getProductText(), product);

    }

    @And("I click on shopping cart link into message")
    public void iClickOnShoppingCartLinkIntoMessage() {
        new ProductPage().clickOnShoppingCartButtonOnTop();
    }

    @And("I change quantity {string} for product")
    public void iChangeQuantityForProduct(String product) {
        new ShoppingCartPage().changeQuantityForProduct("2");
    }

    @And("I click on update quantity")
    public void iClickOnUpdateQuantity() {
        new ShoppingCartPage().clickOnUpdateQuantity();
    }

    @And("I should see cart modified message")
    public void iShouldSeeCartModifiedMessage() {
        Assert.assertEquals(new ShoppingCartPage().getUpdateSuccessfullyText().substring(0, 46), "Success: You have modified your shopping cart!");
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckoutButton();
    }

    @And("I should see the shopping text message")
    public void iShouldSeeTheShoppingTextMessage() {
        Assert.assertEquals(new ShoppingCartPage().getShoppingCartText().substring(0, 13), "Shopping Cart");

    }

    @And("I should navigate to checkout page")
    public void iShouldNavigateToCheckoutPage() {
        Assert.assertEquals(new CheckOutPage().getCheckoutText(), "Checkout");
    }

    @And("I should see new customer text")
    public void iShouldSeeNewCustomerText() {
        Assert.assertEquals(new CheckOutPage().getNewCustomerText(), "New Customer");

    }

    @And("I click on guest checkout button")
    public void iClickOnGuestCheckoutButton() {
        new CheckOutPage().clickOnGuestCheckOutRadioButton();
    }

    @And("I click on continue button of guest checkout page")
    public void iClickOnContinueButtonOfGuestCheckoutPage() {
        new CheckOutPage().clickOnContinueButton();
    }

    @And("I filled all mandatory field of checkout page")
    public void iFilledAllMandatoryFieldOfCheckoutPage() throws InterruptedException {
        new CheckOutPage().enterFirstName("Savan");
        new CheckOutPage().enterLastName("Kakadiya");
        new CheckOutPage().enterEmailId("savan");
        new CheckOutPage().enterTelephone("07979087904");
        new CheckOutPage().enterAddressLine1("70 buller road");
        new CheckOutPage().enterCity("Leicester");
        new CheckOutPage().enterPostCode("LE45GA");
        new CheckOutPage().selectRegion("London");

    }

    @And("I click on continue after fill all detail on checkout page")
    public void iClickOnContinueAfterFillAllDetailOnCheckoutPage() throws InterruptedException {
        new CheckOutPage().clickOnContinue();

    }

    @And("I add comments to text area about product order")
    public void iAddCommentsToTextAreaAboutProductOrder() {
        new CheckOutPage().addCommentsToTextArea("I wanted s macbook");

    }


    @And("I click on continue of checkout")
    public void iClickOnContinueOfCheckout() throws InterruptedException {
        new CheckOutPage().clickContinue();

    }

    @And("I click checkbox of terms and condition")
    public void iClickCheckboxOfTermsAndCondition() throws InterruptedException {
        new CheckOutPage().checkTermsAndConditionCheckBox();
        new CheckOutPage().clickOnLastContinue();
    }


    @Then("I should see warning message regarding Payment method")
    public void iShouldSeeWarningMessageRegardingPaymentMethod() throws InterruptedException {
//        Assert.assertEquals(new CheckOutPage().getWarningMessage(), "Warning: Payment method required!");
    }
}
