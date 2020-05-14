package nl.testchamber.mailordercoffeeshop

import android.os.Build
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
import androidx.test.ext.junit.runners.AndroidJUnit4
import nl.testchamber.mailordercoffeeshop.order.customorder.CustomOrderFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import org.robolectric.annotation.TextLayoutMode

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
@TextLayoutMode(TextLayoutMode.Mode.REALISTIC)
@LooperMode(LooperMode.Mode.PAUSED)
class RobolectricEspressoFragmentScenarioTest {

    @Test
    fun shotCounterShouldIncreaseAfterUpdate() {
        val fragmentArgs: Bundle? = null
        launchFragmentInContainer<CustomOrderFragment>(fragmentArgs, R.style.Theme_MaterialComponents_Light_NoActionBar, null)
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText("0")))
        Espresso.onView(ViewMatchers.withText("+")).perform(ViewActions.click(), ViewActions.click())
        onView(withId(R.id.espresso_shot_counter)).check(matches(withText("2")))
    }
}