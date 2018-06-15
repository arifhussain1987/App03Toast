package com.example.arif.app03_toast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class ToastActivity extends AppCompatActivity {

    Button btnnormaltoast, btnnormaltoastwithgravity, btncustomtoastusinginflator, getBtncustomtoastusinglibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void process(View view)
    {
        switch (view.getId())
        {
            case R.id.btnnormaltoast:
                /*
                    One way to add toast
                Toast toast = new Toast(this);
                toast.setText("This is a normal Toast");
                toast.show();
                */
                // second method of adding toast
                Toast.makeText(getApplicationContext(), "This is a normal Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnnormaltoastwithgravity:
                Toast toast = Toast.makeText(this, "Hi", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP , 100, 0);
                toast.show();
                break;
            case R.id.btncustomtoastwithowncolor:
                /*
                To create a custom toast by using layoutinflator class follow the steps:
                Step1:   Goto layout folder -> New ->layout resource file -> name it as "customtoastlayout"
                Step2:   Create an imageview and insert an image.
                Step3:   Create a textview and align imageview and textview properly
                */
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.customtoastlayout, (ViewGroup)findViewById(R.id.root_layout));

                Toast toast1 = new Toast(getApplicationContext());
                toast1.setDuration(Toast.LENGTH_SHORT);
                toast1.setView(layout);
                toast1.show();
                break;
            case R.id.btncustomtoastusinglibrary:
                /*
                    To add library copy and paste this in your dependensies
                    implementation 'com.muddzdev:styleabletoast:2.1.2'

                    you can also read detail in https://github.com/Muddz/StyleableToast
                    Step1:  goto style folder and some styles and then apply in your toast
                */
                //StyleableToast.makeText(this, "Message from StyleableToast Library", R.style.mytoast).show();

                // if you don't want to create seperate style then do the following code
                new StyleableToast.Builder(this)
                        .text("Message from StyleableToast Library")
                        .textColor(Color.rgb(255, 255, 255))
                        .backgroundColor(Color.BLUE)
                        .iconStart(R.drawable.bulbimg)
                        .show();
                break;
        }
    }
}
