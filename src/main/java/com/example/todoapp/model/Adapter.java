package com.example.todoapp.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.todoapp.R;
import com.example.todoapp.bdd.ActivityDAO;
import com.example.todoapp.model.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * create an adapter for a custom listview
 * an list of Activity
 * @author Quentin Le Lan
 */
public class Adapter extends BaseAdapter {

    /**
     * the list of Activity
     */
    private List<Activity> list;

    /**
     * the context
     */
    private Context context;

    /**
     * the layour
     */
    private LayoutInflater layout;

    /**
     * the DAO for interact with the database
     */
    private ActivityDAO act;

    /**
     * the constructor of adapter
     * @param context the context
     */
    public Adapter(Context context) {
        this.context = context;
        this.layout=LayoutInflater.from(this.context);
        this.list=new ArrayList<Activity>();

        this.act=new ActivityDAO(context);
        list=act.findAll();
    }

    /**
     * update the list with the database
     */
    public void update(){

        this.act=new ActivityDAO(context);
        list=this.act.findAll();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;

        if(convertView == null){
            view=(View)this.layout.inflate(R.layout.activity,viewGroup,false);
        }else{
            view=(View)convertView;
        }


        TextView intitule=(TextView) view.findViewById(R.id.listIntitule);
        TextView desc=(TextView) view.findViewById(R.id.listDesc);
        TextView heure=(TextView) view.findViewById(R.id.listHeure);
        TextView date=(TextView) view.findViewById(R.id.listDate);
        TextView lieu=(TextView) view.findViewById(R.id.listLieu);


        intitule.setText(this.list.get(i).getIntitule());
        desc.setText(this.list.get(i).getDescription());
        heure.setText(this.list.get(i).getDateFin()+" à "+this.list.get(i).getHeureFin());
        date.setText(this.list.get(i).getDateDebut()+" à "+this.list.get(i).getHeureDebut());
        lieu.setText(this.list.get(i).getLieu());

        return view;
    }
}
