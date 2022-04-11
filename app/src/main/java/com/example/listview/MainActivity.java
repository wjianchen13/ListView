package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.visiblestate.StateActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest = (TextView) findViewById(R.id.tv_test);
    }

    /**
     * 显示状态
     * @param
     * @return
     */
    public void onState(View v) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, StateActivity.class);
        startActivity(it);
    }

    /**
     * 测试
     * @param
     * @return
     */
    public void onTest(View v) {
        btnTest.setText(getNormalText("你已经成功加入帮会#花火"));
    }

    /**
     * 获取普通文本富文本
     * @param
     * @return
     */
    private SpannableStringBuilder getNormalText(String content) {
        String str1 = content.substring(0, content.indexOf("#"));
        String str2 = content.substring(content.indexOf("#") + 1, content.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str1  + " ");
        SpannableString spannableString = getForegroundColorSpan(str2, 0xffd6b118);
        spannableStringBuilder.append(spannableString);
        return spannableStringBuilder;
    }

    /**
     * 获取富文本
     * @param
     * @return
     */
    private SpannableString getForegroundColorSpan(String str, int color) {
        SpannableString spanString = new SpannableString(str);
        ForegroundColorSpan span = new ForegroundColorSpan(color);
        spanString.setSpan(span, 0, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


//    /**
//     * 测试
//     * @param
//     * @return
//     */
//    public void onTest(View v) {
//        String time1 = getMsgSystemTime(1526629649);
//        String time2 = getMsgSystemTime(1526543249);
//        String time3 = getMsgSystemTime(1526456849);
//        String time4 = getMsgSystemTime(1526629649);
//        String time5 = getMsgSystemTime(1526629649);
//    }

    /**
     * 获取时间分组
     * @param
     * @return
     */
    private String getMsgSystemTime1(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date nowDate = null;
        Date rDate = new Date(time * 1000) ;
        try {
            date = formatter.parse(formatter.format(rDate));
            nowDate = formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(date.getTime() == nowDate.getTime()) { // 今天
            return new SimpleDateFormat("HH:mm").format(rDate);
        } else if(date.getTime() == nowDate.getTime() - 86400000) { // 昨天
            return "昨天" + new SimpleDateFormat("HH:mm").format(rDate);
        } else { // 其他
            return new SimpleDateFormat("MM-dd HH:mm").format(rDate);
        }
    }

    private String getMsgSystemTime(long time) {
        try {
            SimpleDateFormat formatter;
            Date date = new Date(time * 1000);
            if (TimeUtils.isToday(date)) {
                formatter = new SimpleDateFormat("HH:mm");
                return formatter.format(date);
            } else if (TimeUtils.judgeYesterday(date)) {
                formatter = new SimpleDateFormat("HH:mm");
                return "昨天 " + formatter.format(date);
            } else {
                formatter = new SimpleDateFormat("MM-dd HH:mm");
                return formatter.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
