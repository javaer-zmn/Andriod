package com.example.faceshow.Activity;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.faceshow.R;

public class TeacherDetailActivity extends AppCompatActivity {


    /*
    * int imageId = getIntent().getIntExtra("teacher_image", 0);
    * 语句中传入的属性名teacher_image一定要写对，和putExtra()方法中的保持一致。
    * 通常我们是通过定义常量的方式来定义这样的字符串名字，这里为了简单处理我们用了硬编码的方式
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detail);

        // 从Intent获取数据
        int imageId = getIntent().getIntExtra("teacher_name", 0);
        String desc = getIntent().getStringExtra("teacher_desc");

        // 获取特定的视图
        ImageView imageView = (ImageView) findViewById(R.id.teacher_large_imageView);
        TextView textView = (TextView) findViewById(R.id.teacher_desc_textView);

        // 根据数据设置视图展现
        imageView.setImageResource(imageId);
        textView.setText(desc);

    }
}