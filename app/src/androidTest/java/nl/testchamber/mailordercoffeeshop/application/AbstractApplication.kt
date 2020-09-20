 package nl.testchamber.mailordercoffeeshop.application

import android.content.Intent
import androidx.test.espresso.intent.rule.IntentsTestRule
import nl.testchamber.mailordercoffeeshop.MainActivity
import nl.testchamber.mailordercoffeeshop.util.*
import nl.testchamber.mailordercoffeeshop.util.byPackage
import nl.testchamber.mailordercoffeeshop.util.context
import org.junit.Rule


 open class AbstractApplication(val packageName: String) {


    /*open fun open() {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        byPackage(packageName).waitHasObject()

    }*/
}