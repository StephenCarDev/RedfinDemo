package com.stephen.redfindemo.data

import android.graphics.drawable.Drawable

data class AppInfoModel(
    val appIcon: Drawable,
    val appLabel: String,
    val appVersion: String?,
    val packageName: String
)
