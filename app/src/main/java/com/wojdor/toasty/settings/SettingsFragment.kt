package com.wojdor.toasty.settings

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.wojdor.toasty.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }
}
