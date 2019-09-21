package com.fsx.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fsx.myapplication.view.MyChartView;
import com.fsx.myapplication.view.MyChartView2;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String[] strings = new String[]{};
    float[] floats = new float[]{};
    String[] strings2 = new String[]{"第一个", "第二个", "第三个", "第四个",
            "第五个", "第六个", "第七个", "第八个", "第九个", "第十个", "11", "12"};
    float[] floats2;
    private int curItem = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floats2 = new float[]{100, 300, 100, 200, 400, 150, 100, 300, 100, 200, 400, 150};
        initView();
        initView2();
    }

    MyChartView myChartView;
    GridLayout gridLayout;
    MyChartView2 myChartView2;

    private void initView() {
        LinearLayout ll_myChartView = findViewById(R.id.ll_myChartView);
        gridLayout = findViewById(R.id.gl);
        double[] doubles = new double[]{0, 1, 0, 10, 0, 0, 0, 20, 30, 10};
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < doubles.length; i++) {
            TextView textView = (TextView) inflater.inflate(R.layout.textview_003, null);
            gridLayout.addView(textView);
        }
        myChartView = new MyChartView(this, doubles);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        myChartView.setLayoutParams(params);
        myChartView.setBackgroundResource(R.color.white);//不设置背景 不显示折线
        ll_myChartView.addView(myChartView);
        for (int i = 0; i < doubles.length; i++) {
            final int cur = i;
            myChartView.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myChartView.setVisibility(cur);
                    ((TextView) gridLayout.getChildAt(cur)).setTextColor(Color.RED);
                    ((TextView) gridLayout.getChildAt(curItem)).setTextColor(Color.BLUE);
                    curItem = cur;

                    if (cur % 2 == 0) {
                        myChartView2.updateView(floats, strings);
                    } else {
                        myChartView2.updateView(floats2, strings2);
                    }
                }
            });
        }
        //获取系统的日期
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);//年
        int month = calendar.get(Calendar.MONTH) + 1;//月
        int year0;
        int month0;
        int helf = 0;
        if (doubles.length % 2 == 0) {
            helf = doubles.length / 2;
        } else {
            helf = doubles.length / 2 - 1;

        }
//        int[] months = new int[doubles.length];
        for (int i = -helf; i < helf - 1; i++) {
            if (month + i < 0) {
                year0 = year - 1;
                month0 = 12 - (month + i);
            } else if (month + i > 12) {
                year0 = year + 1;
                month0 = month + i - 12;
            } else {
                year0 = year;
                month0 = month + i;
            }
//            months[i + helf] = month0;

            if (i == 0) {
                ((TextView) gridLayout.getChildAt(i + helf)).setText("当月");
            } else {
                String time = month0 + "月\n" + year0;
                ((TextView) gridLayout.getChildAt(i + helf)).setText(time);
            }
        }
    }
//    private void initView() {
//        LinearLayout ll_myChartView = findViewById(R.id.ll_myChartView);
//        gridLayout = findViewById(R.id.gl);
//        double[] doubles = new double[]{0, 1, 0, 10, 0, 0, 0};
//        myChartView = new MyChartView(this, doubles);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        myChartView.setLayoutParams(params);
//        myChartView.setBackgroundResource(R.color.white);//不设置背景 不显示折线
//        ll_myChartView.addView(myChartView);
//        for (int i = 0; i < doubles.length; i++) {
//            final int cur = i;
//            myChartView.getChildAt(i).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    myChartView.setVisibility(cur);
//                    ((TextView) gridLayout.getChildAt(cur)).setTextColor(Color.parseColor("#333333"));
//                    ((TextView) gridLayout.getChildAt(curItem)).setTextColor(Color.parseColor("#666666"));
//                    curItem = cur;
//                    if (cur % 2 == 0) {
//                        myChartView2.updateView(floats, strings);
//                    } else {
//                        myChartView2.updateView(floats2, strings2);
//                    }
//                }
//            });
//        }
//        //获取系统的日期
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);//年
//        int month = calendar.get(Calendar.MONTH) + 1;//月
//        int year0;
//        int month0;
//        for (int i = -3; i < 4; i++) {
//            if (month + i < 0) {
//                year0 = year - 1;
//                month0 = 12 - (month + i);
//            } else if (month + i > 12) {
//                year0 = year + 1;
//                month0 = month + i - 12;
//            } else {
//                year0 = year;
//                month0 = month + i;
//            }
//            months[i + 3] = month0;
//
//            if (i == 0) {
//                ((TextView) gridLayout.getChildAt(i + 3)).setText("当月");
//            } else {
//                String time = month0 + "月\n" + year0;
//                ((TextView) gridLayout.getChildAt(i + 3)).setText(time);
//            }
//        }
//    }


    private void initView2() {
        LinearLayout ll_myChartView2 = findViewById(R.id.ll_myChartView2);
        myChartView2 = new MyChartView2(this, floats2, strings2);
        ll_myChartView2.addView(myChartView2);
    }
}
