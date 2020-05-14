package nl.testchamber.mailordercoffeeshop

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import nl.testchamber.mailordercoffeeshop.order.customorder.CustomOrderFragment
import org.junit.Test

class EspressoFragmentScenarioTest {

    @Test
    fun shotCounterShouldIncreaseAfterUpdate() {
        val fragmentArgs: Bundle? = null
        launchFragmentInContainer<CustomOrderFragment>(fragmentArgs, R.style.Theme_MaterialComponents_Light_NoActionBar, null)
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText("0")))
        Espresso.onView(ViewMatchers.withText("+")).perform(ViewActions.click(), ViewActions.click())
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText("2")))
    }
}