package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenActivity extends AppCompatActivity{
    private ImageView img;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        img = findViewById(R.id.tween_img);
    }
    /**
     * 透明度渐变
     */
    public void OnAlpha(View view) {
        animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.it_is_touming);
        img.startAnimation(animation);
    }

    /**
     * 缩放渐变
     */
    public void OnScale(View view) {
        animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.it_is_suofang);
        img.startAnimation(animation);
    }

    /**
     * 位移动画
     */
    public void OnTranslate(View view) {
        animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.it_is_weiyi);
        img.startAnimation(animation);
    }

    /**
     * 旋转动画
     */
    public void OnRotate(View view) {
        animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.it_is_xuanzhuan);
        img.startAnimation(animation);
    }

    /**
     * 组合动画
     */
    public void OnSet(View view) {
        animation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.it_is_all);
        img.startAnimation(animation);
    }
}