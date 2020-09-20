@file:JvmName("Selectors")

package nl.testchamber.mailordercoffeeshop.util



import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import nl.testchamber.mailordercoffeeshop.R


private val timeout = 3000L

fun byRes(@IdRes resId: Int): BySelector = By.res(targetContext.resources.getResourceName(resId))


fun byPackage(packageName: String): BySelector = By.pkg(packageName)

fun byStringRes(resString: String): BySelector = By.res(getPackage(), resString)

fun byStringText(text: String): BySelector = By.text(text)



fun BySelector.waitFindObject(): UiObject2 {
  return getDevice().wait(Until.findObject(this), timeout)
}




fun BySelector.getMessageValue() : UiObject2 {
  return  getDevice().wait(Until.findObject(this), timeout)

}

fun BySelector.waitHasObject(): Boolean =
    getDevice().wait(Until.hasObject(this), timeout)


