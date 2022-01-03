package com.example.faceshow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.faceshow.Adapter.TeacherAdapter;
import com.example.faceshow.DAO.Teacher;

/**
 * @Author zmn
 * @Version 1.0
 * @date 2021/12/26 17:57
 */

public class MainActivity extends Activity {

    /**
     * https://blog.csdn.net/It_BeeCoder/article/details/52662142?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164059298616780274175474%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164059298616780274175474&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-52662142.first_rank_v2_pc_rank_v29&utm_term=%E5%AE%89%E5%8D%93%E5%BC%80%E5%8F%91%E5%AE%9E%E4%BE%8B&spm=1018.2226.3001.4187
     *
     * 参考资料
     */

    String msg = "Android : ";

    /** 当活动第一次被创建时调用 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

//        //初始化一个Adapter
        /**
         * 第一个参数是this，表示传入的是当前的Activity
         * 第二个参数是android.R.layout.simple_list_item_1，这是Android系统自带的一个列表元素（即列表中的每一行）布局，只显一串简单的文字
         * 第三个参数是需要显示的所有数据构成的List，即数据源
         *
         */
//        ArrayAdapter<String> teacherAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Teacher.getAllTeachers());
//
//        //通过ID获取listView
//        ListView listView = (ListView) findViewById(R.id.teacher_listView);
//
//        //设置listView的Adapter
//        listView.setAdapter(teacherAdapter);

        TeacherAdapter teacherAdapter = new TeacherAdapter(this, R.layout.teacher_item, Teacher.getAllTeachers());

        ListView listView = (ListView) findViewById(R.id.teacher_listView);

        listView.setAdapter(teacherAdapter);


    }

    /** 当活动即将可见时调用 */
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(msg, "The onStart() event");
//    }
//
//    /** 当活动可见时调用 */
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(msg, "The onResume() event");
//    }
//
//    /** 当其他活动获得焦点时调用 */
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d(msg, "The onPause() event");
//    }
//
//    /** 当活动不再可见时调用 */
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(msg, "The onStop() event");
//    }
//
//    /** 当活动将被销毁时调用 */
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.d(msg, "The onDestroy() event");
//    }
//
//    // Method to start the service
//    public void startService(View view) {
//        startService(new Intent(getBaseContext(), MyService.class));
//    }
//
//    // Method to stop the service
//    public void stopService(View view) {
//        stopService(new Intent(getBaseContext(), MyService.class));
//    }
//
//    // 广播自定义意图
//    public void broadcastIntent(View view){
//        Intent intent = new Intent();
//        intent.setAction("cn.programmer.CUSTOM_INTENT");
//        sendBroadcast(intent);
//    }

}
