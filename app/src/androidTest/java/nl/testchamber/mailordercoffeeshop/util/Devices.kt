@file:JvmName("Devices")

package nl.testchamber.mailordercoffeeshop.util

import android.content.Context
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.platform.app.InstrumentationRegistry

import androidx.test.uiautomator.UiDevice


val targetContext: Context
    get() = InstrumentationRegistry.getInstrumentation().targetContext

val context: Context
    get() = InstrumentationRegistry.getInstrumentation().context

fun getDevice(): UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
fun getPackage(): String = InstrumentationRegistry.getInstrumentation().targetContext.packageName