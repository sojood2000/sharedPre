package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String Name= "Name";
    public static final String Pass= "Password";
    public static final String Flag= "Flag";
    private EditText editText1;
    private EditText editText2;
    private CheckBox check;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //prepare the shared preference
        setUpSharedPreference();
        setUpViews();
        checkShared();

    }

    private void  checkShared(){
        boolean flag= sharedPreferences.getBoolean(Flag, false);

        if(flag){
            String name= sharedPreferences.getString(Name, "");
            String pass= sharedPreferences.getString(Pass, "");
            editText1.setText(name);
            editText2.setText(pass);
            check.setChecked(true);
        }

    }

    private void setUpViews() {
        editText1= findViewById(R.id.edt1);
        editText2= findViewById(R.id.edt2);
        check= findViewById(R.id.checkBox);
    }

    private void setUpSharedPreference() {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor= sharedPreferences.edit();
    }

    public void btnOnClick(View view) {
        String name= editText1.getText().toString();
        String pass= editText2.getText().toString();

        if(check.isChecked()){
            editor.putString(Name, name);
            editor.putString(Pass, pass);
            editor.putBoolean(Flag, true);
            //should write commit to save it rather than will  remain in memory
            editor.commit();

        }
    }
}