package com.stephen.redfindemo.view

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.stephen.redfindemo.R
import com.stephen.redfindemo.base.appContext
import com.stephen.redfindemo.utils.debugLog
import com.stephen.redfindemo.utils.infoLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        infoLog("===========>onCreate<============")
        setContentView(R.layout.activity_main)

        getAppList()

        findViewById<TextView>(R.id.id_battery).text = getBatteryValue()
    }

    private fun getAppList() {
        val packageManager = appContext.packageManager
        val appInfoList = packageManager.getInstalledApplications(0)
        appInfoList.filter { it.name != null }
            .sortedBy { it.loadLabel(packageManager).toString() }
            .forEach {
                debugLog("appItem: packageName: ${it.packageName}, name: ${it.name}")
            }
    }

    private fun getBatteryValue(): String {
        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batterystatus = appContext.registerReceiver(null, ifilter)!!
        val level = batterystatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batterystatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = scale / level * 100
        infoLog("battery: scale:$scale, level:$level , batteryPct:$batteryPct%")
        return batteryPct.toString()
    }

    override fun onStop() {
        super.onStop()
        infoLog("===========>onStop<===========")
    }

    override fun onDestroy() {
        super.onDestroy()
        infoLog("============>onDestory<==========")
    }

}