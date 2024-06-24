package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class DesktopSteps {
    @And("I select product sort by {string}")
    public void iSelectProductSortBy(String filter) {
        //1.3 Select Sort By position "Name: Z to A"
        new DesktopPage().selectFilter(filter);
    }

    @Then("I should see product arrange in alphabetical order successfully")
    public void iShouldSeeProductArrangeInAlphabeticalOrderSuccessfully() {
        //1.4 Verify the Product will arrange in Descending order.
        List<String> actualList = new DesktopPage().getSortedProductList();
        List<String> expectedList = new DesktopPage().expectedList();
        Assert.assertEquals(actualList, expectedList);
    }

    @When("I mouse hover and click on currency dropdown")
    public void iMouseHoverAndClickOnCurrencyDropdown() {
        //2.1 Mouse hover on Currency Dropdown and click
        new HomePage().clickOnCurrency();
    }

    @And("I mouse hover and click on  £ Pound Sterling")
    public void iMouseHoverAndClickOn£PoundSterling() {
        //2.2 Mouse hover on £Pound Sterling and click
        new HomePage().clickOn£PoundSterling();
    }

    @And("I select product {string}")
    public void iSelectProduct(String product) {
        //2.6 Select product “<product>”
        new DesktopPage().clickOnProduct(product);
    }

    @And("I should see product text {string}")
    public void iShouldSeeProductText(String product) {
        //2.7 Verify the Text "<product>"
        Assert.assertEquals(new ProductPage().getProductText(), product);
    }

    @And("I select qty {int}")
    public void iSelectQty(int arg0) {
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        //2.9 Click on “Add to Cart” button
        new ProductPage().clickOnAddToCartButton();
    }

    @And("I should see the message Success: You have added {string} to your shopping cart!")
    public void iShouldSeeTheMessageSuccessYouHaveAddedToYourShoppingCart(String product) {
        //2.10 Verify the Message “Success: You have added “<product>” to your shopping cart!”
        String expectedMessage = "Success: You have added " + product + " to your shopping cart!";
        Assert.assertEquals(new ProductPage().getProductSuccessText().substring(0, expectedMessage.length()), expectedMessage);

    }

    @And("I click on shopping cart link into success message")
    public void iClickOnShoppingCartLinkIntoSuccessMessage() {
        //2.11 Click on link “shopping cart” display into success message
        new ProductPage().clickOnShoppingCartButton();
    }

    @And("I should see the shopping text")
    public void iShouldSeeTheShoppingText() {
        //2.12 Verify the text "Shopping Cart"
        Assert.assertEquals(new ShoppingCartPage().getShoppingCartText().substring(0, 13), "Shopping Cart");
    }

    @And("I should see the product name {string}")
    public void iShouldSeeTheProductName(String productName) {
        //2.13 Verify the Product name "<product>"
        Assert.assertEquals(new ShoppingCartPage().getAllProductText(), productName);

    }

    @And("I should see the model {string}")
    public void iShouldSeeTheModel(String model) {
        //2.14 Verify the Model "<model>"
        Assert.assertEquals(new ShoppingCartPage().getModelText(), model);

    }

    @Then("I should see the total {string}")
    public void iShouldSeeTheTotal(String total) {
        //2.15 Verify the Total "<price>"
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), total);
    }


}
