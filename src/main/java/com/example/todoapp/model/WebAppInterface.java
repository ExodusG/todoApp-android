package com.example.todoapp.model;

import android.content.Context;
import android.widget.Toast;

/**
 * create an webApp interface
 * @author Quentin Le Lan
 */
public class WebAppInterface {

    /**
     * the context
     */
    Context context;

    /**
     * the constructor
     * @param c the context
     */
    public WebAppInterface(Context c){
        this.context=c;
    }

    /**
     * for show a toast
     * @param toast the message to show
     */
    public void showToast(String toast){

        Toast.makeText(this.context,toast,Toast.LENGTH_SHORT).show();
    }
}

