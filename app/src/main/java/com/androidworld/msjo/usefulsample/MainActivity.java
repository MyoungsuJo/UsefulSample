package com.androidworld.msjo.usefulsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tvOne)
    TextView tvOne;
    @BindView(R.id.btnOne)
    Button btnOne;
    @BindView(R.id.btnTwo)
    Button btnTwo;

    @BindView(R.id.imgOne)
    ImageView imgOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PermissionSample.testPermission(this);

        ButterKnife.bind(this);

        Picasso.with(this).load("https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png").into(imgOne);


        CircularFloatingActionMenu.showCircularFloatingActionMenu(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @OnClick({R.id.btnOne, R.id.btnTwo})
    void onClick() {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
    }
}
