package com.stephen.redfindemo.utils

import android.util.Log

var COMMON_TAG = ""

fun Any.verboseLog(message: String) {
    Log.v(COMMON_TAG + this.javaClass.simpleName, message)
}

fun Any.debugLog(message: String) {
    Log.d(COMMON_TAG + this.javaClass.simpleName, message)
}

fun Any.infoLog(message: String) {
    Log.i(COMMON_TAG + this.javaClass.simpleName, message)
}

fun Any.warningLog(message: String) {
    Log.w(COMMON_TAG + this.javaClass.simpleName, message)
}

fun Any.errorLog(message: String) {
    Log.e(COMMON_TAG + this.javaClass.simpleName, message)
}