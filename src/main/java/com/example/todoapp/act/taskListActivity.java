package com.example.todoapp.act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.todoapp.R;
import com.example.todoapp.controller.Controller;
import com.example.todoapp.model.Adapter;

/**
 * create an listView custom for show Activity and a button for add activity
 * @author Quentin Le Lan
 */
public class taskListActivity extends AppCompatActivity {


    /**
     * the adapter
     */
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Controller ctrl=new Controller(this);
        Button ajouter=(Button) findViewById(R.id.ListAjouter);
        ajouter.setOnClickListener(ctrl);
        ListView list = (ListView) findViewById(R.id.listView);
        this.adapter=new Adapter(this);

        list.setAdapter(adapter);
        list.setOnItemClickListener(ctrl);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.adapter.update();
        this.adapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);

    }
}