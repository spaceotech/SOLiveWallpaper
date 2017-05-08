package com.spaceo.livewallpaperdemo;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class MyPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

        // add a validator to the "numberofCircles" preference so that it only
        // accepts numbers
        Preference circlePreference = getPreferenceScreen().findPreference("numberOfCircles");

        // add the validator
        circlePreference.setOnPreferenceChangeListener(numberCheckListener);
    }

    /**
     * Checks that a preference is a valid numerical value
     */
    Preference.OnPreferenceChangeListener numberCheckListener = new Preference.OnPreferenceChangeListener() {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            // check that the string is an integer
            if (newValue != null && newValue.toString().length() > 0
                    && newValue.toString().matches("\\d*")) {
                return true;
            }
            // If now create a message to the user
            Toast.makeText(MyPreferencesActivity.this, "Invalid Input",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    };
}