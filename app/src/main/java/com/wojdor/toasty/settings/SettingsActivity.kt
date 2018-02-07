package com.wojdor.toasty.settings

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import com.wojdor.toasty.R

class SettingsActivity : AppCompatActivity(), SettingsContract.View {

    override lateinit var presenter: SettingsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        presenter = SettingsPresenter(this)
        // TODO: Use shared preferences
        PreferenceManager.getDefaultSharedPreferences(this)
    }
}
