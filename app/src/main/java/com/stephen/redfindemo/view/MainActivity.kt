package com.stephen.redfindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stephen.redfindemo.R
import com.stephen.redfindemo.base.appContext
import com.stephen.redfindemo.utils.infoLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        infoLog("===========>onCreate<============")
        setContentView(R.layout.activity_main)

        getAppList()
    }

    private fun getAppList() {
        val packageManager = appContext.packageManager
        val appInfoList = packageManager.getInstalledApplications(0)
        appInfoList.sortedBy { it.loadLabel(packageManager).toString() }
            .forEach {
                infoLog("appItem: packageName: ${it.packageName}, name: ${it.name}")
            }
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