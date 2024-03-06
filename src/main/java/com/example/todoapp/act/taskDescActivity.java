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
 * the description of one activity
 * @author Quentin Le Lan
 */
public class taskDescActivity extends AppCompatActivity {

    /**
     * the editText of lien
     */
    private EditText lien;

    /**
     * the activity to show
     */
    private Activity act;

    /**
     * the editText of the description
     */
    private EditText desc;

    /**
     * the editText of the lieu
     */
    private EditText lieu;

    /**
     * the editText of begin date
     */
    private EditText dateD;

    /**
     * the editText of the begin hour
     */
    private EditText heureD;

    /**
     * the editText of end date
     */
    private EditText dateF;

    /**
     * the editText of end hour
     */
    private EditText heureF;

    /**
     * the editText of the intitule
     */
    private EditText intitule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_desc);

        Bundle bundle=getIntent().getExtras();
        Controller ctr=null;
        if(bundle.containsKey("ctrl")){
            ctr=(Controller)bundle.getParcelable("ctrl");
            ctr.setDesc(this);
        }

        Button retour=(Button)findViewById(R.id.retourDesc);
        retour.setOnClickListener(ctr);

        Button suppr=(Button)findViewById(R.id.supprDesc);
        suppr.setOnClickListener(ctr);

        Button voir=(Button)findViewById(R.id.voir);
        voir.setOnClickListener(ctr);

        act=null;
        if(bundle.containsKey("act")){
            act=(Activity) bundle.getParcelable("act");
        }

        desc=(EditText)findViewById(R.id.modifDesc);
        lieu=(EditText)findViewById(R.id.modifLieu);
        dateD=(EditText)findViewById(R.id.modifDateD);
        heureD=(EditText)findViewById(R.id.modifHeureD);
        dateF=(EditText)findViewById(R.id.modifDateF);
        heureF=(EditText)findViewById(R.id.modifHeureF);
        intitule=(EditText)findViewById(R.id.modifInt);
        lien=(EditText)findViewById(R.id.modifLien);

        desc.setText(act.getDescription());
        lieu.setText(act.getLieu());
        dateD.setText(act.getDateDebut());
        heureD.setText(act.getHeureDebut());
        dateF.setText(act.getDateFin());
        heureF.setText(act.getHeureFin());
        intitule.setText(act.getIntitule());
        lien.setText(act.getUrl());

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
     * get the EditText lien
     * @return
     */
    public EditText getLien() {
        return lien;
    }

    /**
     * get the activity to show
     * @return the activity
     */
    public Activity getAct() {
        return act;
    }

    /**
     * get a new Activity if the user change the param
     * @return new activity
     */
    public Activity getNewAct() {

        Activity newAct = new Activity();
        newAct.setIntitule(this.intitule.getText().toString());
        newAct.setLieu(this.lieu.getText().toString());
        newAct.setHeureDebut(this.heureD.getText().toString());
        newAct.setDateDebut(this.dateD.getText().toString());
        newAct.setDateFin(this.dateF.getText().toString());
        newAct.setHeureFin(this.heureF.getText().toString());
        newAct.setDescription(this.desc.getText().toString());
        newAct.setUrl(this.lien.getText().toString());
        return newAct;
    }
}