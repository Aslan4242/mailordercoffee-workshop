package nl.testchamber.mailordercoffeeshop.test

import android.content.Context
import androidx.test.espresso.intent.rule.IntentsTestRule
import nl.testchamber.mailordercoffeeshop.MainActivity

import nl.testchamber.mailordercoffeeshop.application.AbstractApplication
import org.junit.Rule


open class AbstractApplicationTest <T : AbstractApplication>(val app: T) {

    @Rule
    @JvmField
    val activityTestRule: IntentsTestRule<MainActivity> =
            IntentsTestRule(MainActivity::class.java)
}