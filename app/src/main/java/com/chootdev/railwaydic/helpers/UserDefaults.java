package com.chootdev.railwaydic.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Choota on 10/15/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class UserDefaults {
    public static boolean isDBUpdated(Context context){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREF, Context.MODE_PRIVATE);
        return pref.getBoolean(Constants.PREF_ISINIT,false);
    }

    public static void updateInit(Context context, boolean status){
        SharedPreferences pref = context.getSharedPreferences(Constants.PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(Constants.PREF_ISINIT, status);
        editor.commit();
    }
}
