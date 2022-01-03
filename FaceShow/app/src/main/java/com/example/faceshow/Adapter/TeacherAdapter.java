package com.example.faceshow.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.faceshow.Activity.TeacherDetailActivity;
import com.example.faceshow.DAO.Teacher;
import com.example.faceshow.R;

import java.util.List;

/**
 * @Author zmn
 * @Version 1.0
 * @date 2022/1/2 20:33
 */

public class TeacherAdapter extends ArrayAdapter<Teacher> {

    public TeacherAdapter(Context context, int resource, List<Teacher> objects) {
        super(context, resource, objects);
    }

    /*
    * getView()方法的重载实现，我们通过重载这个方法就能够让listView根据我们的要求来生成每一个列表元素了。而这个方法做了四件事情：

        获取老师的数据，getItem(position)会把poistion位置的Teacher对象返回给你，这件事情Adapter会帮你处理好，你只管调用就好了。

        创建布局，View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_item, parent, false);
        这条语句大家照着写就好了，你只需要知道这是根据Layout文件生成一个布局（布局也是一个View的子类）。

        获取ImageView和TextView

        最后根据老师数据设置ImageView和TextView的展现
* */


    /*
    * Intent的putExtra方法就是用来传递参数的，我们只需在初始化Intent对象之后把老师的数据传递进去即可。

需要注意的一点是，为了访问teacher变量，需要在申明的时候加上final修饰符
* */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 获取老师的数据
        Teacher teacher = getItem(position);

        // 创建布局
        View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_item, parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneTeacherView.findViewById(R.id.teacher_small_imageView);
        TextView textView = (TextView) oneTeacherView.findViewById(R.id.teacher_name_textView);

        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(teacher.getImageId());
        textView.setText(teacher.getName());


        oneTeacherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  初始化一个准备跳转到TeacherDetailActivity的Intent
                Intent intent = new Intent(getContext(), TeacherDetailActivity.class);


                // 往Intent中传入Teacher相关的数据，供TeacherDetailActivity使用
                intent.putExtra("teacher_image", teacher.getImageId());
                intent.putExtra("teacher_desc", teacher.getDesc());

                // 初始化一个准备跳转到TeacherDetailActivity的Intent
                getContext().startActivity(intent);
            }
        });

        return oneTeacherView;
    }

}
