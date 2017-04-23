package com.androidworld.msjo.usefulsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tvOne)
    TextView tvOne;
    @BindView(R.id.btnOne)
    Button btnOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @OnClick(R.id.btnOne)
    void onClick() {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
    }
}
