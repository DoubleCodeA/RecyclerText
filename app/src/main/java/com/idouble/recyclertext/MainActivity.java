package com.idouble.recyclertext;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Num> numList = new ArrayList<> ();
    private RecyclerView recyclerView;
    private MyAdapter   adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow ().getDecorView ();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility (option);
            getWindow ().setStatusBarColor (Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar ();
        actionBar.hide ();
//        YSTEM_UI_FLAG_LAYOUT_FULLSCREEN和SYSTEM_UI_FLAG_LAYOUT_STABLE，
//        注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间，
//        最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
        initNum();
        recyclerView = (RecyclerView)findViewById (R.id.recycle_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager (this,3) ;
        recyclerView.setLayoutManager (layoutManager);
        adapter = new MyAdapter (numList);
        recyclerView.setAdapter (adapter);
    }

    private void initNum() {
        for (int i = 0; i < 21; i++ ){
            Num num = new Num ("廊坊");
            numList.add (num);
        }
    }
}
