package com.example.busticket.busticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class AnimatonActivity extends AppCompatActivity {

    LinearLayout view1;
    Animation alpha,combine,rotate,scale,translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaton);

        view1 = (LinearLayout) findViewById(R.id.view1);
        combine = AnimationUtils.loadAnimation(this,R.anim.combine);
        rotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        scale = AnimationUtils.loadAnimation(this,R.anim.scale);
        translate = AnimationUtils.loadAnimation(this,R.anim.translate);
        alpha = AnimationUtils.loadAnimation(this,R.anim.alpha);

        view1.startAnimation(alpha);
        view1.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(AnimatonActivity.this, MainActivity.class));
                finish();

            }
        },5000);
       /* alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(AnimatonActivity.this,MainActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
    }
}
