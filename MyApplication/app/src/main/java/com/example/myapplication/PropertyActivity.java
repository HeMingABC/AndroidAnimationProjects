package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class PropertyActivity extends AppCompatActivity {

    private Button btn_show;
    private ObjectAnimator objectAnimator;//声明ObjectAimator类
    private LinearLayout ll_root;
    private float rotateDu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        btn_show = findViewById(R.id.attri_show);
        ll_root = findViewById(R.id.attri_root);
    }
    /**
     * 透明度渐变
     *
     */
    public void OnAlpha(View view) {
        objectAnimator = ObjectAnimator.ofFloat(btn_show, "alpha", 1f, 0.8f, 0.7f, 0.2f, 0.1f);//布局，类型，渐变程度
        objectAnimator.setDuration(4000);
        objectAnimator.start();

    }

    /**
     * 缩放
     */
    public void OnScale(View view) {
        objectAnimator = ObjectAnimator.ofFloat(btn_show, "scaleY", 1f, 2f, 3f, 4f, 3f, 2f, 1f);
        objectAnimator.setDuration(4000);
        objectAnimator.start();

    }

    /**
     * 位移
     */
    public void OnTranslate(View view) {
        float width = ll_root.getWidth();//获取当前手机的的屏幕宽高
        objectAnimator = ObjectAnimator.ofFloat(btn_show, "translationX", width / 10, width / 9, width / 4, width / 3, width / 2, width);
        objectAnimator.setDuration(4000);
        objectAnimator.start();

    }

    /**
     * 旋转
     */
    public void OnRotate(View view) {
        objectAnimator = ObjectAnimator.ofFloat(btn_show, "rotation", rotateDu, 360);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(100);//设置动画重复次数
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        objectAnimator.start();
    }

    /**
     * 组合动画
     */
    public void OnSet(View view) {
        float height = ll_root.getHeight();
        ObjectAnimator objectAnimatorRotate = ObjectAnimator.ofFloat(btn_show, "rotation", rotateDu, 360);
        ObjectAnimator objectAnimatorTr = ObjectAnimator.ofFloat(btn_show, "translationY", height, height / 2, height / 3, height / 4, height / 5, height / 6);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(4000);
        animatorSet.play(objectAnimatorRotate).with(objectAnimatorTr);
        animatorSet.start();
    }
}