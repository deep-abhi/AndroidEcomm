package com.softcrylic.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class homepageActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    GridView simpleGrid;
    private ViewFlipper simpleViewFlipper;
    int[] images = {R.drawable.nature_1, R.drawable.nature_2, R.drawable.nature_3};
    int[] logos = {R.drawable.nature_1, R.drawable.nature_2, R.drawable.nature_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        flipper();
       // gridExample();
    }

    public void flipper() {
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);
        for (int i = 0; i < images.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]); // set image in ImageView
            simpleViewFlipper.addView(imageView); // add the created ImageView in ViewFlipper
        }
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);
        // set interval time for flipping between views
        simpleViewFlipper.setFlipInterval(3000);
        // set auto start for flipping between views
        simpleViewFlipper.setAutoStart(true);
    }

   /* public void gridExample() {
        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(homepageActivity.this, SecondActivity.class);
                intent.putExtra("image", logos[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
    } */

}

