package com.example.truthndare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.YuvImage;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageview;
    private Random mRandomnumber = new Random();
    private int lastDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageview = findViewById(R.id.imageView);
        final Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newDirection = mRandomnumber.nextInt(3600)+360;
                float pivoitX = (float) mImageview.getWidth()/2;
                float pivoitY = (float) mImageview.getHeight()/2;

                Animation rotate = new RotateAnimation(lastDirection,newDirection, pivoitX,pivoitY);
                rotate.setDuration(2000);
                rotate.setFillAfter(true);

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mButton.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mButton.setEnabled(true);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                lastDirection = newDirection;

                mImageview.startAnimation(rotate);
            }
        });

    }
}