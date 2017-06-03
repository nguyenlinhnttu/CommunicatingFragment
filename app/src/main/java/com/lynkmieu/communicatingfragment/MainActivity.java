package com.lynkmieu.communicatingfragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnSelectedListener {
    private TextView tvValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvValue = (TextView) findViewById(R.id.tv_value);

        replaceFragment();
    }

    private void replaceFragment() {
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content, fragmentOne);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onSelected(String value) {
        tvValue.setText(value);
    }
}
