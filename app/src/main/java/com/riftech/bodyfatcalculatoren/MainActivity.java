package com.riftech.bodyfatcalculatoren;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String h_unit,w_unit,gender,wi_unit,n_unit,p_unit,male,female;
    double height,weight,bmi,waist,neck,hip,bfp;
    AlertDialog.Builder builder;
    AlertDialog customAlertDialog;
    SharedPreferences sharedPreferences;
    String selected_lang,st,tost;
TextView txt10,txt2,txt4,txt5,txt7,txt9,txt8;
    Button button;
    String[] countries;
    int selected_index;
    RadioButton r1,r2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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

        /*ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
        bar.setTitle(Html.fromHtml("<font color='#000000'>"+getString(R.string.app_name)+"</font>"));*/

        button=(Button)findViewById(R.id.button);
        ProgressBar pgsBar = (ProgressBar) findViewById(R.id.pBar);
        Spinner dropdown = findViewById(R.id.spinner);
        Spinner dropdown1 = findViewById(R.id.spinner3);
        Spinner dropdown2 = findViewById(R.id.spinner4);
        Spinner dropdown3 = findViewById(R.id.spinner6);

        Spinner dropdown5 = findViewById(R.id.spinner8);
        EditText editText1 = (EditText)findViewById(R.id.editTextNumberDecimal3);
        EditText editText2 = (EditText)findViewById(R.id.editTextNumberDecimal5);
        EditText editText3 = (EditText)findViewById(R.id.editTextNumberDecimal6);
        EditText editText4 = (EditText)findViewById(R.id.editTextNumberDecimal8);
        EditText editText5 = (EditText)findViewById(R.id.editTextNumberDecimal10);
        txt10=(TextView)findViewById(R.id.textView10);
        txt2=(TextView)findViewById(R.id.textView2);
        txt8=(TextView)findViewById(R.id.textView8);
        txt4=(TextView)findViewById(R.id.textView4);
        txt5=(TextView)findViewById(R.id.textView5);
        txt9=(TextView)findViewById(R.id.textView9);
        txt7=(TextView)findViewById(R.id.textView7);
        r1=(RadioButton)findViewById(R.id.radioButton3);
        r2=(RadioButton)findViewById(R.id.radioButton4);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        //dropdown.setPopupBackgroundResource(R.drawable.spinner);
        //ConstraintLayout main=(ConstraintLayout) findViewById(R.id.main);
        //RelativeLayout rl=(RelativeLayout)findViewById(R.id.progressLayout);
        changelang();

        //create a list of items for the spinner.
        String[] items = new String[]{getString(R.string.ft), getString(R.string.cm)};
        String[] items1 = new String[]{getString(R.string.kg), getString(R.string.lbs)};

        String[] items3 = new String[]{getString(R.string.in), getString(R.string.cm)};

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown1.setAdapter(adapter1);
        dropdown2.setAdapter(adapter4);
        dropdown3.setAdapter(adapter3);
        dropdown5.setAdapter(adapter5);


        txt10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                pgsBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {



                        pgsBar.setVisibility(View.GONE);
                        startActivity(intent);

                        //main.setVisibility(View.VISIBLE);
                    }
                }, 2000);

            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {




                // click handling code
                h_unit = dropdown.getSelectedItem().toString();
                w_unit = dropdown1.getSelectedItem().toString();
                wi_unit = dropdown2.getSelectedItem().toString();
                n_unit = dropdown3.getSelectedItem().toString();
                p_unit = dropdown5.getSelectedItem().toString();

                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")|| editText3.getText().toString().equals("")|| editText4.getText().toString().equals("")|| editText5.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    int radioButtonID = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(radioButtonID);
                    gender = radioButton.getText().toString();
                    pgsBar.setVisibility(View.VISIBLE);
                    weight = Float.parseFloat(editText2.getText().toString());
                    height = Float.parseFloat(editText1.getText().toString());
                    waist = Float.parseFloat(editText3.getText().toString());
                    neck = Float.parseFloat(editText4.getText().toString());
                    hip = Float.parseFloat(editText5.getText().toString());
                    if (Objects.equals(h_unit, getString(R.string.ft))) {
                        height = height * 30.48;
                    }

                    if (Objects.equals(w_unit, getString(R.string.lbs))) {
                        weight = weight * 0.45359237;
                    }
                    if (Objects.equals(wi_unit, getString(R.string.in))) {
                        waist = waist * 2.54;
                    }
                    if (Objects.equals(n_unit, getString(R.string.in))) {
                        neck = neck * 2.54;
                    }
                    if (Objects.equals(p_unit, getString(R.string.in))) {
                        hip = hip * 2.54;
                    }
if(Objects.equals(gender, r1.getText().toString())){
    bfp=(495/(1.0324-(0.19077*Math.log10(waist-neck))+(0.15456*Math.log10(height))))-450;
}else{
    bfp=(495/(1.29579-(0.35004*Math.log10(waist+hip-neck))+(0.22100*Math.log10(height))))-450;
}

                    bfp = Math.round(bfp * 10.0) / 10.0;

                    /*Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(bfp), Toast.LENGTH_SHORT);
                    toast.show();*/
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("bfp", bfp);
                    intent.putExtra("gender", gender);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {



                            pgsBar.setVisibility(View.GONE);
                            startActivity(intent);

                            //main.setVisibility(View.VISIBLE);
                        }
                    }, 2000);

                }
            }
        });

        //get the spinner from the xml.


    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.change, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            // do something here
            // single item array instance to store which element is selected by user initially
            // it should be set to zero meaning none of the element is selected by default
            selected_index = sharedPreferences.getInt("index", 0);
            final int[] checkedItem = {selected_index};

            // AlertDialog builder instance to build the alert dialog
            builder = new AlertDialog.Builder(MainActivity.this);

            // set the custom icon to the alert dialog
            builder.setIcon(R.drawable.lang);

            // title of the alert dialog
            builder.setTitle("Change Language:");

            // list of the items to be displayed to the user in the
            // form of list so that user can select the item from
            final String[] listItems = new String[]{"English","Indonesian", "Español", "Français", "Italiano","Deutsch","Português","Русский"};


            // the function setSingleChoiceItems is the function which
            // builds the alert dialog with the single item selection
            builder.setSingleChoiceItems(listItems, checkedItem[0], (dialog, which) -> {
                // update the selected item which is selected by the user so that it should be selected
                // when user opens the dialog next time and pass the instance to setSingleChoiceItems method
                checkedItem[0] = which;

                // now also update the TextView which previews the selected item
                //tvSelectedItemPreview.setText("Selected Item is : " + listItems[which]);




                SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
                myEdit.putInt("index",which);

// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
                myEdit.apply();

                changelang();
                // when selected an item the dialog should be closed with the dismiss method
                dialog.dismiss();


            });

            // set the negative button if the user is not interested to select or change already selected item
            builder.setNegativeButton("Cancel", (dialog, which) -> {

            });

            // create and build the AlertDialog instance with the AlertDialog builder instance
            customAlertDialog = builder.create();

            // show the alert dialog when the button is clicked
            customAlertDialog.show();
        }
        if (id == R.id.action_share) {
            // do something here
            // single item array instance to store which element is selected by user initially
            // it should be set to zero meaning none of the element is selected by default
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Love Calculator");
                String shareMessage= "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName() +"\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch(Exception e) {
                //e.toString();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public void changelang() {
        selected_index = sharedPreferences.getInt("index", 0);
        switch (selected_index){
            case 0:

                button.setText(getText(R.string.Calculate));
                txt10.setText(getString(R.string.how));
                txt2.setText(getString(R.string.height));
                txt4.setText(getString(R.string.Weight));
                txt5.setText(getString(R.string.Waist));
                txt7.setText(getString(R.string.Neck));
                txt9.setText(getString(R.string.Hip));
                txt8.setText(getString(R.string.Gender));
                tost=getString(R.string.toast);
                r1.setText(getString(R.string.male));
                r2.setText(getString(R.string.female));
                this.setTitle(getString(R.string.app_name));
                break;
            case 1:
                button.setText(getText(R.string.Calculate_ind));
                txt10.setText(getString(R.string.how_ind));
                txt2.setText(getString(R.string.height_ind));
                txt4.setText(getString(R.string.Weight_ind));
                txt5.setText(getString(R.string.Waist_ind));
                txt7.setText(getString(R.string.Neck_ind));
                txt9.setText(getString(R.string.Hip_ind));
                txt8.setText(getString(R.string.Gender_ind));
                tost=getString(R.string.toast_ind);
                r1.setText(getString(R.string.male_ind));
                r2.setText(getString(R.string.female_ind));
                this.setTitle(getString(R.string.app_name_ind));
                break;
            case 2:
                button.setText(getText(R.string.Calculate_sp));
                txt10.setText(getString(R.string.how_sp));
                txt2.setText(getString(R.string.height_sp));
                txt4.setText(getString(R.string.Weight_sp));
                txt5.setText(getString(R.string.Waist_sp));
                txt7.setText(getString(R.string.Neck_sp));
                txt9.setText(getString(R.string.Hip_sp));
                txt8.setText(getString(R.string.Gender_sp));
                tost=getString(R.string.toast_sp);
                r1.setText(getString(R.string.male_sp));
                r2.setText(getString(R.string.female_sp));
                this.setTitle(getString(R.string.app_name_sp));
                break;
            case 3:
                button.setText(getText(R.string.Calculate_fr));
                txt10.setText(getString(R.string.how_fr));
                txt2.setText(getString(R.string.height_fr));
                txt4.setText(getString(R.string.Weight_fr));
                txt5.setText(getString(R.string.Waist_fr));
                txt7.setText(getString(R.string.Neck_fr));
                txt9.setText(getString(R.string.Hip_fr));
                txt8.setText(getString(R.string.Gender_fr));
                tost=getString(R.string.toast_fr);
                r1.setText(getString(R.string.male_fr));
                r2.setText(getString(R.string.female_fr));
                this.setTitle(getString(R.string.app_name_fr));
                break;
            case 4:
                button.setText(getText(R.string.Calculate_it));
                txt10.setText(getString(R.string.how_it));
                txt2.setText(getString(R.string.height_it));
                txt4.setText(getString(R.string.Weight_it));
                txt5.setText(getString(R.string.Waist_it));
                txt7.setText(getString(R.string.Neck_it));
                txt9.setText(getString(R.string.Hip_it));
                txt8.setText(getString(R.string.Gender_it));
                tost=getString(R.string.toast_it);
                r1.setText(getString(R.string.male_it));
                r2.setText(getString(R.string.female_it));
                this.setTitle(getString(R.string.app_name_it));
                break;
            case 5:
                button.setText(getText(R.string.Calculate_de));
                txt10.setText(getString(R.string.how_de));
                txt2.setText(getString(R.string.height_de));
                txt4.setText(getString(R.string.Weight_de));
                txt5.setText(getString(R.string.Waist_de));
                txt7.setText(getString(R.string.Neck_de));
                txt9.setText(getString(R.string.Hip_de));
                txt8.setText(getString(R.string.Gender_de));
                tost=getString(R.string.toast_de);
                r1.setText(getString(R.string.male_de));
                r2.setText(getString(R.string.female_de));
                this.setTitle(getString(R.string.app_name_de));
                break;
            case 6:
                button.setText(getText(R.string.Calculate_pt));
                txt10.setText(getString(R.string.how_pt));
                txt2.setText(getString(R.string.height_pt));
                txt4.setText(getString(R.string.Weight_pt));
                txt5.setText(getString(R.string.Waist_pt));
                txt7.setText(getString(R.string.Neck_pt));
                txt9.setText(getString(R.string.Hip_pt));
                txt8.setText(getString(R.string.Gender_pt));
                tost=getString(R.string.toast_pt);
                r1.setText(getString(R.string.male_pt));
                r2.setText(getString(R.string.female_pt));
                this.setTitle(getString(R.string.app_name_pt));
                break;
            case 7:
                button.setText(getText(R.string.Calculate_ru));
                txt10.setText(getString(R.string.how_ru));
                txt2.setText(getString(R.string.height_ru));
                txt4.setText(getString(R.string.Weight_ru));
                txt5.setText(getString(R.string.Waist_ru));
                txt7.setText(getString(R.string.Neck_ru));
                txt9.setText(getString(R.string.Hip_ru));
                txt8.setText(getString(R.string.Gender_ru));
                tost=getString(R.string.toast_ru);
                r1.setText(getString(R.string.male_ru));
                r2.setText(getString(R.string.female_ru));
                this.setTitle(getString(R.string.app_name_ru));
                break;
            default:
                button.setText(getText(R.string.Calculate));
                txt10.setText(getString(R.string.how));
                txt2.setText(getString(R.string.height));
                txt4.setText(getString(R.string.Weight));
                txt5.setText(getString(R.string.Waist));
                txt7.setText(getString(R.string.Neck));
                txt9.setText(getString(R.string.Hip));
                txt8.setText(getString(R.string.Gender));
                tost=getString(R.string.toast);
                r1.setText(getString(R.string.male));
                r2.setText(getString(R.string.female));
                this.setTitle(getString(R.string.app_name));
                break;
        }

    }
}