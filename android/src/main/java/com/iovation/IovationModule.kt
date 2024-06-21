package com.reactnativeiovation

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.iovation.mobile.android.FraudForceConfiguration
import com.iovation.mobile.android.FraudForceManager

class IovationModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun multiply(a: Double, b: Double): Double {
    return a * b
  }

  val configuration = FraudForceConfiguration.Builder()
	  .subscriberKey("M1WrRSwcjUBQmHamij3DxQJWr00YzfRhXaMkI+zhhiY=")
		.enableNetworkCalls(true)
		.build()

  val context = reactContext.getApplicationContext()

	init {
	  FraudForceManager.initialize(configuration, context)
    FraudForceManager.refresh(context)
	}

  @ReactMethod
  fun getBlackbox(a: Double, b: Double): String {
    val blackbox = FraudForceManager.getBlackbox(context)
    return blackbox
  }

  companion object {
    const val NAME = "Iovation"
  }
}

