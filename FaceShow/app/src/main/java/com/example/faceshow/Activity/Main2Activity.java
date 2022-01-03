package com.example.faceshow.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.faceshow.DataBase.DBHelpler;
import com.example.faceshow.R;

import java.util.ArrayList;

/**
 * @Author zmn
 * @Version 1.0
 * @date 2022/1/3 19:43
 */

public class Main2Activity extends AppCompatActivity {

    //https://blog.csdn.net/Deniece_X/article/details/78625532


    private SQLiteDatabase db;
    EditText ed_name;
    EditText ed_height;
    EditText ed_age;
    EditText ed_id;
    ListView listView = null;
    ArrayList al = new ArrayList();
    ArrayAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_activity);
    }
    public void insert(View view){
        /**
         * 添加数据
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        //获取插入的值
        ed_name = (EditText)findViewById(R.id.name_ed);
        ed_age = (EditText)findViewById(R.id.age_ed);
        ed_height = (EditText)findViewById(R.id.id_ed);
        //使用ContentValues类型来传值
        ContentValues newvalues = new ContentValues();
        newvalues.put("name",ed_name.getText().toString());
        newvalues.put("age",ed_age.getText().toString());
        newvalues.put("height",ed_height.getText().toString());
        //调用系统方法写入数据库的表中
        db.insert("Student",null,newvalues);
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
    }
    public void showall(View view){
        /**
         * 全部显示
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        //使用游标进行挨个查找  rawQuery方法就是一种逐行查找的方法
        Cursor cursor = db.rawQuery("select * from Student",new String[]{});
        clearshow(view);
        while (cursor.moveToNext()){
            listView = (ListView)findViewById(R.id.ListView);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            int height = cursor.getInt(3);
            al.add("ID: "+id+"--姓名："+name+"--年龄:"+age+"--身高:"+height);
        }
        ad  = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        listView.setAdapter(ad);
    }
    public void clearshow(View view){
        /**
         * 清除显示
         */
        listView = (ListView)findViewById(R.id.ListView);
        al.clear();
        ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        listView.setAdapter(ad);
    }
    public void deleteall(View view){
        /**
         * 全部删除
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        //系统删除方法
        db.delete("Student",null,null);
        clearshow(view);
        Toast.makeText(this,"全部删除",Toast.LENGTH_SHORT).show();
    }
    public void deleteId(View view){
        /**
         * ID删除
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        ed_id = (EditText)findViewById(R.id.checkid_ed);
        String id = ed_id.getText().toString();
        db.delete("Student","id=?",new String[]{id});
        Toast.makeText(this,id+"删除成功",Toast.LENGTH_SHORT).show();
        clearshow(view);
    }
    public void selectId(View view){
        /**
         * ID查询
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        //获取输入的ID值
        ed_id = (EditText)findViewById(R.id.checkid_ed);
        String id0 = ed_id.getText().toString();
        //使用游标进行逐行查找
        Cursor cursor = db.rawQuery("select * from Student where id = ?",new String[]{id0});
        clearshow(view);
        while (cursor.moveToNext()){
            listView = (ListView)findViewById(R.id.ListView);
            int id = cursor.getInt(0);
            if (id == Integer.parseInt(id0)){
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                int height = cursor.getInt(3);
                al.add("ID: "+id+"--姓名："+name+"--年龄:"+age+"--身高:"+height);
            }
        }
        ad  = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        listView.setAdapter(ad);
    }
    public void updateId(View view){
        /**
         * ID更新
         */
        //连接数据库
        DBHelpler dbHelpler = new DBHelpler(this);
        db = dbHelpler.getWritableDatabase();
        //获取插入的值
        ed_name = (EditText)findViewById(R.id.name_ed);
        ed_age = (EditText)findViewById(R.id.age_ed);
        ed_height = (EditText)findViewById(R.id.id_ed);
        //获取输入的ID值
        ed_id = (EditText)findViewById(R.id.checkid_ed);
        String id0 = ed_id.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",ed_name.getText().toString());
        contentValues.put("age",ed_age.getText().toString());
        contentValues.put("height",ed_height.getText().toString());
        db.update("Student",contentValues,"id=?",new String[]{id0});
    }
    protected void onStop() {
        super.onStop();
        if(db!=null)
        {
            db.close();
        }
    }

}
