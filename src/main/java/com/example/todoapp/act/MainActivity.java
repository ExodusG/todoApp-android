package com.example.todoapp.act;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.todoapp.R;
import com.example.todoapp.controller.Controller;
import com.example.todoapp.model.Activity;

/**
 * the mainActivity is for create a new Activity on the list
 * @author Quentin Le Lan
 */
public class MainActivity extends AppCompatActivity {



    /**
     * the editText of the end of date
     */
    private EditText finDate;

    /**
     * the editText of the begin of date
     */
    private EditText debutDate;

    /**
     * the editText of the end of the hour
     */
    private EditText finHeure;

    /**
     * the editText of the begin of hour
     */
    private EditText debutHeure;

    /**
     * the editText of description
     */
    private EditText description;

    /**
     * the editText of the name
     */
    private EditText intitule;

    /**
     * the editText of the place
     */
    private EditText lieu;

    /**
     * the editText of the lien
     */
    private EditText lien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle=getIntent().getExtras();
        Controller ctr =null;
        if(bundle.containsKey("ctrl")){
           ctr=(Controller)bundle.getParcelable("ctrl");
           ctr.setApp(this);
        }
        Button ajouter =(Button)findViewById(R.id.button);
        ajouter.setOnClickListener(ctr);

        Button annuler=(Button)findViewById(R.id.button2);
        annuler.setOnClickListener(ctr);

        Button lien =(Button)findViewById(R.id.button3);
        lien.setOnClickListener(ctr);

        finDate=(EditText)findViewById(R.id.dateFin);
        debutDate=(EditText)findViewById(R.id.dateDebut);
        finHeure=(EditText)findViewById(R.id.heureFin);
        debutHeure=(EditText)findViewById(R.id.heureDebut);
        description=(EditText)findViewById(R.id.description);
        intitule=(EditText)findViewById(R.id.intitule);
        lieu=(EditText)findViewById(R.id.lieu);
        this.lien=(EditText)findViewById(R.id.ajoutLien);
    }

    /**
     * for finish this activity
     */
    public void finish(){
        Intent returnIntent = new Intent();
        setResult(1,returnIntent);
        super.finish();
    }

    /**
     * create an activity with all information put by the user
     * @return new activity
     */
    public Activity getNewActivity(){
        Activity act= new Activity();
        act.setDateFin(this.finDate.getText().toString());
        act.setDateDebut(this.debutDate.getText().toString());
        act.setDescription(this.description.getText().toString());
        act.setHeureDebut(this.debutHeure.getText().toString());
        act.setHeureFin(this.finHeure.getText().toString());
        act.setLieu(this.lieu.getText().toString());
        act.setIntitule(this.intitule.getText().toString());
        act.setUrl(this.lien.getText().toString());
        return act;
    }

    /**
     * the getteur of editText Lien
     * @return editText lien
     */
    public EditText getLien() {
        return lien;
    }
}