package com.riftech.bodyfatcalculatoren;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    String type,male,female,men,women,l1,l2,l3,l4,l5,l6;
    SharedPreferences sharedPreferences;
    int selected_index;
TextView txt,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt27,txt29,txt35,txt33,txt36,txt32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


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

        TextView txt1=(TextView)findViewById(R.id.textView3);
        TextView txt2=(TextView)findViewById(R.id.textView6);
//        TextView txt3=(TextView)findViewById(R.id.textView13);
//        TextView txt4=(TextView)findViewById(R.id.textView25);
//        TextView txt5=(TextView)findViewById(R.id.textView24);
//        TextView txt6=(TextView)findViewById(R.id.textView23);
//        TextView txt7=(TextView)findViewById(R.id.textView22);
//        TextView txt8=(TextView)findViewById(R.id.textView20);
        //ImageView img=(ImageView)findViewById(R.id.imageView);
        txt=(TextView)findViewById(R.id.textView);
//        txt12=(TextView)findViewById(R.id.textView12);
        txt14=(TextView)findViewById(R.id.textView14);
        txt15=(TextView)findViewById(R.id.textView15);
        txt16=(TextView)findViewById(R.id.textView16);
        txt17=(TextView)findViewById(R.id.textView17);
        txt18=(TextView)findViewById(R.id.textView18);
        txt19=(TextView)findViewById(R.id.textView19);

        txt27=(TextView)findViewById(R.id.textView27);
        txt29=(TextView)findViewById(R.id.textView29);
        txt35=(TextView)findViewById(R.id.textView35);
        txt33=(TextView)findViewById(R.id.textView33);
        txt36=(TextView)findViewById(R.id.textView36);
        txt32=(TextView)findViewById(R.id.textView32);


        Intent intent = getIntent();
        double bfp = intent.getDoubleExtra("bfp",0.0);
        String gender = intent.getStringExtra("gender");

        changelang();

        if(Objects.equals(gender, male)){

//            txt3.setText(men);
           // img.setImageResource(R.drawable.bfpm);
        }else{
//            txt3.setText(women);
//            txt4.setText(getString(R.string.f1));
//            txt5.setText(getString(R.string.f2));
//            txt6.setText(getString(R.string.f3));
//            txt7.setText(getString(R.string.f4));
//            txt8.setText(getString(R.string.f5));

           // img.setImageResource(R.drawable.bfpf);
        }

        txt1.setText(String.valueOf(bfp)+"%");
        if(Objects.equals(gender, female)){
        if(bfp<15){
            type=l1;
            txt1.setTextColor(Color.parseColor("#FD6B22"));
        } else if (bfp<18) {
            type=l2;
            txt1.setTextColor(Color.parseColor("#E0E1E3"));
        } else if (bfp<22) {
            type=l3;
            txt1.setTextColor(Color.parseColor("#91BF77"));
        } else if (bfp<30) {
            type=l4;
            txt1.setTextColor(Color.parseColor("#62C924"));
        }else if (bfp<40) {
            type=l5;
            txt1.setTextColor(Color.parseColor("#FEAC2E"));
        }else {
            type=l6;
            txt1.setTextColor(Color.parseColor("#FC1424"));
        }}
        if(Objects.equals(gender, male)){
            if(bfp<5){
                type=l1;
                txt1.setTextColor(Color.parseColor("#FD6B22"));
            } else if (bfp<8) {
                type=l2;
                txt1.setTextColor(Color.parseColor("#E0E1E3"));
            } else if (bfp<12) {
                type=l3;
                txt1.setTextColor(Color.parseColor("#91BF77"));
            } else if (bfp<20) {
                type=l4;
                txt1.setTextColor(Color.parseColor("#62C924"));
            }else if (bfp<30) {
                type=l5;
                txt1.setTextColor(Color.parseColor("#FEAC2E"));
            }else {
                type=l6;
                txt1.setTextColor(Color.parseColor("#FC1424"));
            }}
        txt2.setText(type);
        txt14.setText(l1);
        txt15.setText(l2);
        txt16.setText(l3);
        txt17.setText(l4);
        txt18.setText(l5);
        txt19.setText(l6);
    }

    public void changelang() {
        selected_index = sharedPreferences.getInt("index", 0);
        switch (selected_index){
            case 0:

                male=getString(R.string.male);
                female=getString(R.string.female);
                men=getString(R.string.m);
                women=getString(R.string.f);
                l1=getString(R.string.l1);
                l2=getString(R.string.l2);
                l3=getString(R.string.l3);
                l4=getString(R.string.l4);
                l5=getString(R.string.l5);
                l6=getString(R.string.l6);
                txt.setText(getString(R.string.your));
//                txt12.setText(getString(R.string.title));
                txt27.setText(getString(R.string.d1));
                txt29.setText(getString(R.string.d2));
                txt35.setText(getString(R.string.d3));
                txt33.setText(getString(R.string.d4));
                txt36.setText(getString(R.string.d5));
                txt32.setText(getString(R.string.d6));
                this.setTitle(getString(R.string.app_name));
                break;
            case 1:
                male=getString(R.string.male_ind);
                female=getString(R.string.female_ind);
                men=getString(R.string.m_ind);
                women=getString(R.string.f_ind);
                l1=getString(R.string.l1_ind);
                l2=getString(R.string.l2_ind);
                l3=getString(R.string.l3_ind);
                l4=getString(R.string.l4_ind);
                l5=getString(R.string.l5_ind);
                l6=getString(R.string.l6_ind);
                txt.setText(getString(R.string.your_ind));
//                txt12.setText(getString(R.string.title_ind));
                txt27.setText(getString(R.string.d1_ind));
                txt29.setText(getString(R.string.d2_ind));
                txt35.setText(getString(R.string.d3_ind));
                txt33.setText(getString(R.string.d4_ind));
                txt36.setText(getString(R.string.d5_ind));
                txt32.setText(getString(R.string.d6_ind));
                this.setTitle(getString(R.string.app_name_ind));
                break;
            case 2:
                male=getString(R.string.male_sp);
                female=getString(R.string.female_sp);
                men=getString(R.string.m_sp);
                women=getString(R.string.f_sp);
                l1=getString(R.string.l1_sp);
                l2=getString(R.string.l2_sp);
                l3=getString(R.string.l3_sp);
                l4=getString(R.string.l4_sp);
                l5=getString(R.string.l5_sp);
                l6=getString(R.string.l6_sp);
                txt.setText(getString(R.string.your_sp));
//                txt12.setText(getString(R.string.title_sp));
                txt27.setText(getString(R.string.d1_sp));
                txt29.setText(getString(R.string.d2_sp));
                txt35.setText(getString(R.string.d3_sp));
                txt33.setText(getString(R.string.d4_sp));
                txt36.setText(getString(R.string.d5_sp));
                txt32.setText(getString(R.string.d6_sp));
                this.setTitle(getString(R.string.app_name_sp));
                break;
            case 3:
                male=getString(R.string.male_fr);
                female=getString(R.string.female_fr);
                men=getString(R.string.m_fr);
                women=getString(R.string.f_fr);
                l1=getString(R.string.l1_fr);
                l2=getString(R.string.l2_fr);
                l3=getString(R.string.l3_fr);
                l4=getString(R.string.l4_fr);
                l5=getString(R.string.l5_fr);
                l6=getString(R.string.l6_fr);
                txt.setText(getString(R.string.your_fr));
//                txt12.setText(getString(R.string.title_fr));
                txt27.setText(getString(R.string.d1_fr));
                txt29.setText(getString(R.string.d2_fr));
                txt35.setText(getString(R.string.d3_fr));
                txt33.setText(getString(R.string.d4_fr));
                txt36.setText(getString(R.string.d5_fr));
                txt32.setText(getString(R.string.d6_fr));
                this.setTitle(getString(R.string.app_name_fr));
                break;
            case 4:
                male=getString(R.string.male_it);
                female=getString(R.string.female_it);
                men=getString(R.string.m_it);
                women=getString(R.string.f_it);
                l1=getString(R.string.l1_it);
                l2=getString(R.string.l2_it);
                l3=getString(R.string.l3_it);
                l4=getString(R.string.l4_it);
                l5=getString(R.string.l5_it);
                l6=getString(R.string.l6_it);
                txt.setText(getString(R.string.your_it));
//                txt12.setText(getString(R.string.title_it));
                txt27.setText(getString(R.string.d1_it));
                txt29.setText(getString(R.string.d2_it));
                txt35.setText(getString(R.string.d3_it));
                txt33.setText(getString(R.string.d4_it));
                txt36.setText(getString(R.string.d5_it));
                txt32.setText(getString(R.string.d6_it));
                this.setTitle(getString(R.string.app_name_it));
                break;
            case 5:
                male=getString(R.string.male_de);
                female=getString(R.string.female_de);
                men=getString(R.string.m_de);
                women=getString(R.string.f_de);
                l1=getString(R.string.l1_de);
                l2=getString(R.string.l2_de);
                l3=getString(R.string.l3_de);
                l4=getString(R.string.l4_de);
                l5=getString(R.string.l5_de);
                l6=getString(R.string.l6_de);
                txt.setText(getString(R.string.your_de));
//                txt12.setText(getString(R.string.title_de));
                txt27.setText(getString(R.string.d1_de));
                txt29.setText(getString(R.string.d2_de));
                txt35.setText(getString(R.string.d3_de));
                txt33.setText(getString(R.string.d4_de));
                txt36.setText(getString(R.string.d5_de));
                txt32.setText(getString(R.string.d6_de));
                this.setTitle(getString(R.string.app_name_de));
                break;
            case 6:
                male=getString(R.string.male_pt);
                female=getString(R.string.female_pt);
                men=getString(R.string.m_pt);
                women=getString(R.string.f_pt);
                l1=getString(R.string.l1_pt);
                l2=getString(R.string.l2_pt);
                l3=getString(R.string.l3_pt);
                l4=getString(R.string.l4_pt);
                l5=getString(R.string.l5_pt);
                l6=getString(R.string.l6_pt);
                txt.setText(getString(R.string.your_pt));
//                txt12.setText(getString(R.string.title_pt));
                txt27.setText(getString(R.string.d1_pt));
                txt29.setText(getString(R.string.d2_pt));
                txt35.setText(getString(R.string.d3_pt));
                txt33.setText(getString(R.string.d4_pt));
                txt36.setText(getString(R.string.d5_pt));
                txt32.setText(getString(R.string.d6_pt));
                this.setTitle(getString(R.string.app_name_pt));
                break;
            case 7:
                male=getString(R.string.male_ru);
                female=getString(R.string.female_ru);
                men=getString(R.string.m_ru);
                women=getString(R.string.f_ru);
                l1=getString(R.string.l1_ru);
                l2=getString(R.string.l2_ru);
                l3=getString(R.string.l3_ru);
                l4=getString(R.string.l4_ru);
                l5=getString(R.string.l5_ru);
                l6=getString(R.string.l6_ru);
                txt.setText(getString(R.string.your_ru));
//                txt12.setText(getString(R.string.title_ru));
                txt27.setText(getString(R.string.d1_ru));
                txt29.setText(getString(R.string.d2_ru));
                txt35.setText(getString(R.string.d3_ru));
                txt33.setText(getString(R.string.d4_ru));
                txt36.setText(getString(R.string.d5_ru));
                txt32.setText(getString(R.string.d6_ru));
                this.setTitle(getString(R.string.app_name_ru));
                break;
            default:
                male=getString(R.string.male);
                female=getString(R.string.female);
                men=getString(R.string.m);
                women=getString(R.string.f);
                l1=getString(R.string.l1);
                l2=getString(R.string.l2);
                l3=getString(R.string.l3);
                l4=getString(R.string.l4);
                l5=getString(R.string.l5);
                l6=getString(R.string.l6);
                txt.setText(getString(R.string.your));
//                txt12.setText(getString(R.string.title));
                txt27.setText(getString(R.string.d1));
                txt29.setText(getString(R.string.d2));
                txt35.setText(getString(R.string.d3));
                txt33.setText(getString(R.string.d4));
                txt36.setText(getString(R.string.d5));
                txt32.setText(getString(R.string.d6));
                this.setTitle(getString(R.string.app_name));
                break;
        }

    }
}