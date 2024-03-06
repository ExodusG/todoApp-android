package com.example.todoapp.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.todoapp.model.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * the DAO class for Activity, allow you to make simple request
 * @author Quentin Le Lan
 */
public class ActivityDAO extends DAOBase {

    /**
     * the name of column intitule
     */
    private String intitule="intitule";

    /**
     * the name of column description
     */
    private String description="description";

    /**
     * the name of column lieu
     */
    private String lieu="lieu";

    /**
     * the name of column dateDebut
     */
    private String dateDebut="dateDebut";

    /**
     * the name of column dateFin
     */
    private String dateFin="dateFin";

    /**
     * the name of column heureDebut
     */
    private String heureDebut="heureDebut";

    /**
     * the name of column heureFin
     */
    private String heureFin="heureFin";

    /**
     * the name of column URL
     */
    private String url="url";

    /**
     * the constructor of the ActivityDAO
     * @param pContext the context
     */
    public ActivityDAO(Context pContext) {
        super(pContext);
    }

    /**
     * for add a new value in the databse
     * @param act the activity to add
     */
    public void ajouter(Activity act){
       ContentValues value = new ContentValues();
       value.put(intitule, act.getIntitule());
       value.put(description, act.getDescription());
       value.put(lieu, act.getLieu());
       value.put(dateDebut, act.getDateDebut());
       value.put(dateFin, act.getDateFin());
       value.put(heureDebut,act.getHeureDebut());
       value.put(heureFin, act.getHeureFin());
       value.put(url,act.getUrl());
       this.open();
       mDb.insert("Activity", null, value);
   }

    /**
     * for remove an activity
     * @param act the activity
     */
   public void supprimer(Activity act){
       this.open();
       mDb.delete("Activity", intitule+"=?", new String[] {(act.getIntitule())});
   }

    /**
     * for change an activity
     * @param old the old activity
     * @param newAct the new activity
     */
   public void modifier(Activity old,Activity newAct){
        ContentValues value=new ContentValues();
       value.put(intitule, newAct.getIntitule());
       value.put(description, newAct.getDescription());
       value.put(lieu, newAct.getLieu());
       value.put(dateDebut, newAct.getDateDebut());
       value.put(dateFin, newAct.getDateFin());
       value.put(heureDebut,newAct.getHeureDebut());
       value.put(heureFin, newAct.getHeureFin());
       value.put(url,newAct.getUrl());
        this.open();
       int m=mDb.update("Activity",value, intitule+"=?", new String[] {(old.getIntitule())});
   }

   public Activity selectionner(String intituler){
        return null;
   }

    /**
     * for find all value in the database
     * @return an list with all Activity
     */
    public List<Activity> findAll() {
        List<Activity> list = new ArrayList<Activity>();
        this.open();
        Cursor cursor = mDb.rawQuery( "SELECT * FROM Activity",null);
        if (cursor.moveToFirst()) {
            do {
               Activity act=new Activity();

               act.setIntitule(cursor.getString(1));
                act.setDescription(cursor.getString(2));
                act.setLieu(cursor.getString(3));
                act.setDateDebut(cursor.getString(4));
                act.setDateFin(cursor.getString(5));
                act.setHeureDebut(cursor.getString(6));
                act.setHeureFin(cursor.getString(7));
                act.setUrl(cursor.getString(8));
                list.add(act);

            }
            while (cursor.moveToNext());
        }
        return list;
    }
}
