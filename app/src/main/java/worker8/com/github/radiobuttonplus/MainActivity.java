package worker8.com.github.radiobuttonplus;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class MainActivity extends AppCompatActivity {
    RadioGroupPlus mRadioGroupPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRadioGroupPlus = (RadioGroupPlus) findViewById(R.id.radio_group_plus);
        mRadioGroupPlus.setOnCheckedChangeListener(new RadioGroupPlus.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroupPlus radioGroupPlus, @IdRes int i) {
                Log.i("RadioGroupPlus", "onCheckedChanged:");
                // Add your logic here
            }
        });

    }

    public void onOrderClicked(View view) {
        if (R.id.rb_latte == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Latte", Toast.LENGTH_SHORT).show();
        } else if (R.id.rb_mocha == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Mocha", Toast.LENGTH_SHORT).show();
        } else if (R.id.rb_americano == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Americano", Toast.LENGTH_SHORT).show();
        } else if (R.id.rb_espresso == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Espresso", Toast.LENGTH_SHORT).show();
        } else if (R.id.rb_orange == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Orange", Toast.LENGTH_SHORT).show();
        } else if (R.id.rb_butter == mRadioGroupPlus.getCheckedRadioButtonId()) {
            Toast.makeText(MainActivity.this, "Butter", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "No Drinks :(", Toast.LENGTH_SHORT).show();
        }
    }
}
