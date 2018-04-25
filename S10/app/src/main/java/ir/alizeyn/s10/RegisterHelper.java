package ir.alizeyn.s10;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ali Zeynali on 4/25/2018.
 */

public class RegisterHelper {

    private static Context context;
    private static RegisterHelper registerHelper;
    private static SharedPreferences registerPref;


    private RegisterHelper() {

    }

    public static RegisterHelper getInstance(Context context) {
        if (registerHelper == null) {
            RegisterHelper.context = context;
            registerHelper = new RegisterHelper();
            registerPref = context.getSharedPreferences("RegPref", Context.MODE_PRIVATE);
        }
        return registerHelper;
    }

    public boolean isRegistered() {
        return registerPref.getBoolean("isReg", false);
    }

    public void setRegister(boolean register) {
        registerPref.edit().putBoolean("isReg", true).apply();
    }

    public void addUser(String firstName, String lastName, String gender) {
        SharedPreferences.Editor editor = registerPref.edit();
        editor.putString("firstName", firstName);
        editor.putString("lastName", lastName);
        editor.putString("gender", gender);
        editor.apply();
    }

    public String getUserName() {
        String name = "";
        name += registerPref.getString("firstName", "null") + " " + registerPref.getString("lastName", "null");
        return name;
    }


}
