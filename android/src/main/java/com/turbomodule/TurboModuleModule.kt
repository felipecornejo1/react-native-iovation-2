package com.turbomodule

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.iovation.mobile.android.FraudForceConfiguration
import com.iovation.mobile.android.FraudForceManager

class TurboModuleModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
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
  fun getBlackbox(a: Double, b: Double, promise: Promise) {
    val blackbox = FraudForceManager.getBlackbox(context)
    promise.resolve(blackbox)
  }

  companion object {
    const val NAME = "TurboModule"
  }
}

