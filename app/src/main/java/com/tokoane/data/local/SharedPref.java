package com.tokoane.data.local;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void SaveId(Context context, String pesanan){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        String cek = getSharedPreference(context).getString("PESANAN", null);
        if(cek!=null){
            editor.remove("PESANAN");
            editor.apply();
            String cek2 = cek.replace(cek.substring(cek.length()-1), "");
            String cek3 = cek2 + "," + pesanan + "]";
            editor.putString("PESANAN", cek3);
            editor.apply();
        }else {
            String ceks = "[" + pesanan + "]";
            editor.putString("PESANAN", ceks);
            editor.apply();
        }
    }
    public static String GetId(Context context){
        return getSharedPreference(context).getString("PESANAN", null);
    }

}

