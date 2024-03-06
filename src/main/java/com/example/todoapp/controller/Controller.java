package com.example.todoapp.controller;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;

import com.example.todoapp.model.Activity;
import com.example.todoapp.act.MainActivity;
import com.example.todoapp.R;
import com.example.todoapp.bdd.ActivityDAO;
import com.example.todoapp.act.showOnWeb;
import com.example.todoapp.act.taskDescActivity;
import com.example.todoapp.act.taskListActivity;

/**
 * the Controller of the MVC patern
 * @author Quentin Le Lan
 */
public class Controller implements View.OnClickListener, Parcelable, AdapterView.OnItemClickListener {

    /**
     * the mainActivity
     */
    private MainActivity app;

    /**
     * the taskListActivity
     */
    private taskListActivity task;

    /**
     * the taskDescActivity
     */
    private taskDescActivity desc;


    /**
     * the constructor of the Controller
     * @param task the taskListActivity
     */
    public Controller(taskListActivity task) {
        this.task = task;
    }


    /**
     * when the user click on a item
     * @param v the view who was click
     */
    public void onClick(View v){
        //ajouter
        ActivityDAO actDAO=null;
        if(v.getId()== R.id.button){

            actDAO=new ActivityDAO(app);
            actDAO.ajouter(app.getNewActivity());

            app.finish();
            //ajouter sur la list
        }else if(v.getId()==R.id.ListAjouter){
            Intent game=new Intent(task, MainActivity.class);
            game.putExtra("ctrl", (Parcelable) this);
            task.startActivityForResult(game,1);
            //annuler
        }else if(v.getId()==R.id.button2){
            app.finish();
            //retour d'une activité
        }else if(v.getId()==R.id.retourDesc){

            actDAO=new ActivityDAO(desc);
            actDAO.modifier(desc.getAct(),desc.getNewAct());
            desc.finish();
            //supprimer une activité
        }else if(v.getId()==R.id.supprDesc){
            actDAO=new ActivityDAO(desc);
            actDAO.supprimer(desc.getAct());
            desc.finish();
            //regarder le lien dans la webView
        }else if(v.getId()==R.id.voir){
            Intent show=new Intent(desc, showOnWeb.class);
            show.putExtra("url",desc.getLien().getText().toString());
            desc.startActivityForResult(show,5);
        }else if(v.getId()==R.id.button3){
            Intent show=new Intent(app, showOnWeb.class);
            show.putExtra("url",app.getLien().getText().toString());
            app.startActivityForResult(show,5);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Activity selectedItem=(Activity) adapterView.getItemAtPosition(i);
        Intent game=new Intent(task, taskDescActivity.class);
        game.putExtra("ctrl", (Parcelable) this);
        game.putExtra("act",selectedItem);
        task.startActivityForResult(game,1);

    }


    //METHOD FOR PARCELABLE
    protected Controller(Parcel in) {
    }

    public static final Creator<Controller> CREATOR = new Creator<Controller>() {
        @Override
        public Controller createFromParcel(Parcel in) {
            return new Controller(in);
        }

        @Override
        public Controller[] newArray(int size) {
            return new Controller[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public void setApp(MainActivity app){
        this.app=app;
    }

    public void setDesc(taskDescActivity desc){
        this.desc=desc;
    }


}
