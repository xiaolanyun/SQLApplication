package com.example.a24075.sqlapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseActivity extends AppCompatActivity {
    private EditText et1,et2;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et1=(EditText) findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.like);
        b=(Button)findViewById(R.id.add);
        //添加按钮
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String like=et2.getText().toString();
                ContentValues values = new ContentValues();
                //在values中添加内容
                values.put("name",name);
                values.put("hobby",like);
                //实例化数据库类
                DBHelper helper = new DBHelper(getApplicationContext());
                //插入数据
               helper.insert(values);
                //实例化intent
                Intent intent = new Intent(DatabaseActivity.this,displayActivity.class);
                startActivity(intent);
                //启动intent
            }
        });
    }
}
