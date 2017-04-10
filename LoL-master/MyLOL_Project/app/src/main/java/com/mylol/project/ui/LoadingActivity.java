package com.mylol.project.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.administrator.mylol_project.R;
import com.mylol.project.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kim
 * on 2017/4/4.
 */
public class LoadingActivity extends Activity {

    @BindView(value = R.id.loading_logo)
    ImageView loadingLogo;
    @BindView(value = R.id.textView)
    TextView textView;
    @BindView(value = R.id.loading_bottom)
    ImageView loadingBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laoding);
        ButterKnife.bind(this);
        initImageView();

    }

    private void initImageView() {
        //构建一个动画
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(3000);
        loadingLogo.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
                startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
