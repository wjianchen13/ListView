package com.example.listview.visiblestate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.R;

import java.util.ArrayList;
import java.util.List;

public class StateActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvTest1;
    private List<String> datas = new ArrayList<>();
    private StateAdapter adapter;
    private ListView lvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        tvTest1 = (TextView) findViewById(R.id.tv_test1);
        tvTest1.setOnClickListener(this);
        initListView();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "visible position: " + lvTest.getFirstVisiblePosition(), Toast.LENGTH_SHORT).show();
        View child = lvTest.getChildAt(0);
        if (child == null) {
            return ;
        }
        int firstVisiblePosition = lvTest.getFirstVisiblePosition();
         int top = child.getTop();
        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = 750;
        }
        int height =  -top + firstVisiblePosition * child.getHeight() + headerHeight;
        int b = 2;
    }

    protected int getScrollYOfListView(AbsListView view) {
        View child = view.getChildAt(0);
        if (child == null) {
            return 0;
        }

        int firstVisiblePosition = view.getFirstVisiblePosition();
        int top = child.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
//            headerHeight = mHeaderHeight;
        }

        return -top + firstVisiblePosition * child.getHeight() + headerHeight;
    }

    public void initListView(){
        lvTest = (ListView)findViewById(R.id.lv_test);
        View placeHolderView = LayoutInflater.from(this).inflate(R.layout.header_placeholder, lvTest, false);
        lvTest.addHeaderView(placeHolderView);
        String s1 = "test1";
        datas.add(s1);
        String s2 = "test2";
        datas.add(s2);
        String s3 = "test3";
        datas.add(s3);
        String s4 = "test4";
        datas.add(s4);
        String s5 = "test5";
        datas.add(s5);
        String s6 = "test6";
        datas.add(s6);
        String s7 = "test7";
        datas.add(s7);
        String s8 = "test8";
        datas.add(s8);
        String s9 = "test9";
        datas.add(s9);
        String s10 = "test10";
        datas.add(s10);
        String s11 = "test11";
        datas.add(s11);
        String s12 = "test12";
        datas.add(s12);
        String s13 = "test13";
        datas.add(s13);
        String s14 = "test14";
        datas.add(s14);
        String s15 = "test15";
        datas.add(s15);

        adapter = new StateAdapter(datas);
        lvTest.setAdapter(adapter);
    }
}
