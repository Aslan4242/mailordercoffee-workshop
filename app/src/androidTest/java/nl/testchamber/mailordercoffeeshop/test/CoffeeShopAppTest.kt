package nl.testchamber.mailordercoffeeshop.test

import androidx.test.runner.AndroidJUnit4
import nl.testchamber.mailordercoffeeshop.application.CoffeeShopApp
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoffeeShopAppTest : AbstractApplicationTest<CoffeeShopApp>(CoffeeShopApp()) {

    @Test
    fun testNotOrderAnyShots() {
        app.clickOnCloseButton()
        app.clickOnReviewOrderButton()
        app.checkToastMessage("A minimum of 1 Espresso shot is required for each order")
    }

    @Test
    fun testTryChooseZeroAmountOfShots() {
        app.clickOnCloseButton()
        app.clickOnMinusButton()
        app.checkToastMessage("You can't order less than zero espresso shots")
    }

    @Test
    fun testNameField() {
        app.clickOnCloseButton()
        app.clickOnMenuButton()
        app.clickCoffeeItem("ESPRESSO")
        app.clickOnSubmitOrderButton()
        app.checkEmptyNameMessage("Enter your name please")
        app.typeName("Aslan")
        app.clickOnSubmitOrderButton()
    }

    @Test
    fun testMailOrder() {
        app.clickOnCloseButton()
        app.clickOnMenuButton()
        app.clickCoffeeItem("ESPRESSO")
        app.typeName("Aslan")
        app.clickOnSubmitOrderButton()
        app.checkMailOrderSubject("Aslan", "Espresso")
        app.checkMailOrderText("Ingredients:\n" +
                "1 shot of espresso")
    }

    @Test
    fun testEmptyNameAndCustomNameField() {
        app.clickOnCloseButton()
        app.clickOnPlusButton(2)
        app.clickOnReviewOrderButton()
        app.clickOnSubmitOrderButton()
        app.checkEmptyNameMessage("Enter your name please")
        app.checkEmptyCustomNameMessage("Please enter a name for your order")
        app.typeName("Aslan")
        app.clickOnSubmitOrderButton()
        app.checkEmptyCustomNameMessage("Please enter a name for your order")
        app.typeCustomName("ASLN")
        app.clickOnSubmitOrderButton()
    }

    @Test
    fun testOrderCustomShot() {
        app.clickOnCloseButton()
        app.clickOnPlusButton()
        app.clickOnChocolateButton()
        app.clickOnMilkTypeButton()
        app.chooseMilkType("Custom %")
        app.choosePercentage(40)
        app.clickOnReviewOrderButton()
        app.checkOrder("Ingredients:\n1 shot of espresso\nChocolate\n Cheese")
    }

}