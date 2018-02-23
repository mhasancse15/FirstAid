package com.mhasancse.firstaid.netCheck;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "WeatherPref";
    private static final String TEMP_UNIT_C = "false";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createTempSession() {
        editor.putBoolean(TEMP_UNIT_C, false);
        editor.commit();
    }

    public void changeTempUnit(boolean tempUnit) {
        editor.putBoolean(TEMP_UNIT_C, tempUnit);
        editor.commit();
    }

    public boolean getTempUnitC() {
        return Boolean.valueOf(TEMP_UNIT_C);
    }
}