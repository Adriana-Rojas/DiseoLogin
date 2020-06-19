package com.example.juliocesar.diseologin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.juliocesar.diseologin.adapter.BlogAdapter;
import com.example.juliocesar.diseologin.adapter.BlogCustomAdapter;
import com.example.juliocesar.diseologin.database.DataHelper;

import java.util.ArrayList;
import java.util.List;

public class CrudUsuario  extends AppCompatActivity {




    private SQLiteDatabase getdata;
    protected Cursor cursor;
    protected BlogCustomAdapter blogAdapter;
    private List<BlogAdapter> blogList;
    DataHelper dataHelper;
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    public static CrudUsuario ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_usuario);

        ma = this;

        dataHelper = new DataHelper(this);
        getdata = dataHelper.getReadableDatabase();

        //
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        blogList = new ArrayList<>();
        blogAdapter = new BlogCustomAdapter(blogList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(blogAdapter);

        //

        getBlog();

        Button btn = (Button) findViewById(R.id.addData);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                startActivity(new Intent(CrudUsuario.this, AddBlog.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        blogList.clear();
        getBlog();
        blogAdapter.notifyDataSetChanged();
    }

    public void getBlog(){
        cursor     = getdata.rawQuery("SELECT id,nombre,telefono,correo,contraseña FROM tb_blog ORDER BY id DESC", null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            BlogAdapter blog = new BlogAdapter(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));

            blogList.add(blog);



        }
    }
}
