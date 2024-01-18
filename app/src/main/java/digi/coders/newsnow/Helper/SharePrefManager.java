package digi.coders.newsnow.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import digi.coders.newsnow.Model.SharePrefModel;

public class SharePrefManager {

    public static final String sharedPrefName = "News_app";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE_NO = "Phone_no";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_GENDER = "gender";

   Context context;

   static SharePrefManager prefManager;

    public SharePrefManager(Context context) {
        this.context = context;
    }

    public static SharePrefManager sharePrefManager (Context context){
        if (prefManager==null){
            prefManager = new SharePrefManager(context);
        }
        return prefManager;
    }


    public void InsertUsers(SharePrefModel sharePrefModel){
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPrefName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_ID,sharePrefModel.getIds());
        editor.putString(KEY_NAME,sharePrefModel.getFullnames());
        editor.putString(KEY_EMAIL,sharePrefModel.getEmail());
        editor.putString(KEY_PHONE_NO,sharePrefModel.getPhoneNo());
        editor.putString(KEY_PASSWORD,sharePrefModel.getPassword());
        editor.putBoolean(KEY_GENDER,sharePrefModel.isRadioButtonSelected());

        editor.apply();
    }


    public SharePrefModel getReadUserData(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPrefName,Context.MODE_PRIVATE);

        SharePrefModel sharePrefModel = new SharePrefModel(
                sharedPreferences.getInt(KEY_ID,0),
                sharedPreferences.getString(KEY_NAME,null),
                sharedPreferences.getString(KEY_EMAIL,null),
                sharedPreferences.getString(KEY_PHONE_NO,null),
                sharedPreferences.getString(KEY_PASSWORD,null),
                sharedPreferences.getBoolean(KEY_GENDER,true)
        );
        return sharePrefModel;
    }


}
