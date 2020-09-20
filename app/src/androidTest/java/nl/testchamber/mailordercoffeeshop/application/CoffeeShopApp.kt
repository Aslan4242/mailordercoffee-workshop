package nl.testchamber.mailordercoffeeshop.application

import android.content.Intent
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.util.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher
import org.junit.Assert


class CoffeeShopApp : AbstractApplication("nl.testchamber.mailordercoffeeshop") {

    fun clickOnMenuButton() {
        byStringText("MENU").waitFindObject().click()
    }

    fun clickOnCloseButton() {
        byStringRes("close_button").waitFindObject().click()
    }

    fun clickOnPlusButton(count: Int = 1) {
        for (i in 1..count) {
            byStringText("+").waitFindObject().click()
        }

    }

    fun clickOnMinusButton() {
        byStringText("-").waitFindObject().click()
    }

    fun clickOnChocolateButton() {
        byStringText("Chocolate").waitFindObject().click()
    }

    fun clickOnMilkTypeButton() {
        byStringRes("milk_type").waitFindObject().click()
    }

    fun checkToastMessage(text: String) {
        onView(withText(text)).inRoot(ToastMatcher())
                .check(ViewAssertions.matches(isDisplayed()))
    }

    fun chooseMilkType(text: String) {
        byStringText(text).waitFindObject().click()
    }



    fun clickOnReviewOrderButton() {
        onView(withText(R.string.review_order_button)).perform(scrollTo()).perform(click());
        //byStringText("REVIEW ORDER").waitFindObject().click()
    }

    fun choosePercentage(percent: Int) {
        onView(withId(R.id.simpleSeekBar)).perform(setProgress(percent));
    }
   private fun setProgress(progress: Int): ViewAction? {

        return object : ViewAction {
            override fun perform(uiController: UiController?, view: View) {
                val seekBar = view as SeekBar
                seekBar.progress = progress
            }

            override fun getDescription(): String {
                return "Set a progress on a SeekBar"
            }

            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(SeekBar::class.java)
            }
        }
    }

    fun clickOnSubmitOrderButton() {
        byStringText("SUBMIT ORDER").waitFindObject().click()
    }

    fun clickCoffeeItem(text: String) {
        onView(withId(R.id.beverage_recycler_view))
                .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(ViewMatchers.hasDescendant(withText(text)), ViewActions.click()))
        // byStringText(text).waitFindObject().click()

    }

    fun checkEmptyNameMessage(text: String) {
        Assert.assertEquals(
                text,
                byStringText("Enter your name please").getMessageValue().text
        )
    }

    fun checkEmptyCustomNameMessage(text: String) {
        Assert.assertEquals(
                text,
                byStringText("Please enter a name for your order").getMessageValue().text
        )
    }
    fun checkOrder(text: String) {
        Assert.assertEquals(
                text,
                byStringRes("beverage_detail_ingredients").getMessageValue().text
        )
    }
    fun checkMailOrderSubject(name: String, coffee: String) {
        intended(allOf(
                hasAction(equalTo(Intent.ACTION_SENDTO)),
                hasExtra(Intent.EXTRA_SUBJECT, "Order: $name - $coffee")))
    }
    fun checkMailOrderText(text: String) {
        intended((hasExtra(Intent.EXTRA_TEXT, text)))
    }

    fun typeName(text: String) {
        byStringText("Enter your name").waitFindObject().text = text
    }

    fun typeCustomName(text: String) {
        byStringText("Give your custom order a name").waitFindObject().text = text
    }


}