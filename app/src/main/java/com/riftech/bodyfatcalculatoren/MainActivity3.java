package com.riftech.bodyfatcalculatoren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    int selected_index;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

// Storing data into SharedPreferences
        sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        if(!sharedPreferences.contains("index")) {
// Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putInt("index",0);

// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.apply();
        }


        txt1=(TextView) findViewById(R.id.textView11);

        changelang();
    }

    public void changelang() {
        selected_index = sharedPreferences.getInt("index", 0);
        switch (selected_index){
            case 0:


                txt1.setText(getString(R.string.about));
                this.setTitle(getString(R.string.app_name));
                break;
            case 1:
                txt1.setText(getString(R.string.about_ind));
                this.setTitle(getString(R.string.app_name_ind));
                break;
            case 2:
                txt1.setText(getString(R.string.about_sp));
                this.setTitle(getString(R.string.app_name_sp));
                break;
            case 3:
                txt1.setText(getString(R.string.about_fr));
                this.setTitle(getString(R.string.app_name_fr));
                break;
            case 4:
                txt1.setText(getString(R.string.about_it));
                this.setTitle(getString(R.string.app_name_it));
                break;
            case 5:
                txt1.setText(getString(R.string.about_de));
                this.setTitle(getString(R.string.app_name_de));
                break;
            case 6:
                txt1.setText(getString(R.string.about_pt));
                this.setTitle(getString(R.string.app_name_pt));
                break;
            case 7:
                txt1.setText(getString(R.string.about_ru));
                this.setTitle(getString(R.string.app_name_ru));
                break;
            default:
                txt1.setText(getString(R.string.about));
                this.setTitle(getString(R.string.app_name));
                break;
        }

    }
}