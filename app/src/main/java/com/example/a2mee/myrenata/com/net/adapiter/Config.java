package com.example.a2mee.myrenata.com.net.adapiter;

/**
 * Created by A2mee on 3/15/2018.
 */
public class Config  /*extends Activity*/ {

    //Keys for email and password as   b defined in our $_POST['key'] in login.php
    public static final String mylogin_PREF_NAME = "Login Successfull!!";

    public static final String BASE_URL = "http://192.168.2.8:8091/";
    //If server response is equal to this that means login is successful
    public static final String Register_SUCCESS = "Registration Sucessful!!";
    /* public static final String KEY_conform = "conform_password";*/
    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";
    //This would be used to store the email of
    //
    // current logged in user
    public static final String EMAIL_SHARED_PREF = "email";
    public static final String password_SHARED_PREF = "password";
    //We will use this to store the boolean in sharedpreference to track user is loggedinn or not
    public static final String LOGGEDINN_SHARED_PREF = "loggedinn";
    //static final String BASE_URL = "http://192.168.2.12/roh/";
    // http://parent.api.mydschool.com/app/
    //public static final String BASE_URL = "http://192.168.2.4:8091/";
    // public static String BASE_URL = "http://192.168.2.8:8091/";
    public static String Username_SHARED_PREF = "user_id";

  /*  @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.changeurl);
        super.onCreate(savedInstanceState);
    }

    public void changeIP(View v) {
        EditText editText = findViewById(R.id.editTextIp);
        String changeIp = editText.getText().toString();
        if (changeIp.equals("")) {
            Toast.makeText(getApplicationContext(), "No Data Is Entered" + Config.BASE_URL, Toast.LENGTH_LONG).show();

        } else {
            BASE_URL = "http://" + changeIp + ":8081/";
            Toast.makeText(getApplicationContext(), "Entered Text is " + BASE_URL, Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }*/
}
