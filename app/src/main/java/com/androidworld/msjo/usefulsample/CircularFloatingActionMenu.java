package com.androidworld.msjo.usefulsample;

import android.app.Activity;
import android.graphics.Color;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by jomyeongsu on 2017. 10. 10..
 */

public class CircularFloatingActionMenu {

    public static void showCircularFloatingActionMenu(final Activity a) {
        // in Activity Context
        ImageView iconBlack = new ImageView(a); // Create an icon
        iconBlack.setBackgroundColor(Color.BLACK);

        /////
//        FloatingActionButton.LayoutParams params =
//                new FloatingActionButton.LayoutParams(
//                        FloatingActionButton.LayoutParams.WRAP_CONTENT,
//                        FloatingActionButton.LayoutParams.WRAP_CONTENT);
//
        /////

        FloatingActionButton actionButton = new FloatingActionButton.Builder(a)
                .setBackgroundDrawable(R.drawable.button_action_dark)
                .setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER)
//                .setLayoutParams(params)
                .build();

        // Create Menu items
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(a);

        // repeat many times:
        ImageView imgSubRed = new ImageView(a);
        imgSubRed.setImageDrawable(a.getResources().getDrawable(R.drawable.button_action_touch));
        SubActionButton button1 = itemBuilder.setContentView(imgSubRed).build();

        // repeat many times:
        ImageView imgSubGreen = new ImageView(a);
        imgSubGreen.setBackgroundColor(Color.GREEN);
        SubActionButton button2 = itemBuilder.setContentView(imgSubGreen).build();

        // repeat many times:
        ImageView imgSubBlue = new ImageView(a);
        imgSubGreen.setBackgroundColor(Color.BLUE);
        SubActionButton button3 = itemBuilder.setContentView(imgSubBlue).build();

        // repeat many times:
        ImageView imgSubSilver = new ImageView(a);
        imgSubGreen.setBackgroundColor(Color.BLUE);
        SubActionButton button4 = itemBuilder.setContentView(imgSubSilver).build();

        // repeat many times:

        ImageView imgSubBlack = new ImageView(a);

        imgSubGreen.setBackgroundColor(Color.BLUE);

        SubActionButton button5 = itemBuilder.setContentView(imgSubBlack).build();


        // Create Menu With the items
        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(a)
                .setRadius(360) // 서브원 퍼지는거
                .setStartAngle(-40)
                .setEndAngle(-140)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .addSubActionView(button5)
                .attachTo(actionButton)
                .build();
    }
}
