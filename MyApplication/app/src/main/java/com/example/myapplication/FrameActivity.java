package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start;
    private Button stop;
    private ImageView view;
    private AnimationDrawable animationDrawable;//声明AnimationDrawable类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        initView();
    }

    private void initView(){
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        view = findViewById(R.id.view);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        // 通过逐帧动画的资源文件获得AnimationDrawable示例
        animationDrawable=(AnimationDrawable) getResources().getDrawable(R.drawable.frame_animation);
        // 把AnimationDrawable设置为ImageView的背景
        view.setBackgroundDrawable(animationDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                start();
                break;
            case R.id.stop:
                stop();
                break;
        }
    }

    protected void start() {
        if (animationDrawable != null && !animationDrawable.isRunning()) {//判断
            animationDrawable.start();
        }
    }

    protected void stop() {
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }

    }
}