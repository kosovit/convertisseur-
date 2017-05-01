package com.example.ziyed.convertisseur;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ziyed.convertisseur.controller.CtrlChText;

/**
 * Created by zna on 17/01/2017.
 */

public class LeWorker extends AsyncTask<Void, Boolean, Void> {
    private CtrlChText ctr;

    public LeWorker(CtrlChText ctr) {
        this.ctr = ctr;
    }

    @Override
    protected Void doInBackground(Void... params) {
        MDD cemdd = new MDD("ceMDD");
        LectureCapteur ceThreadLisCapteur = new LectureCapteur(cemdd, "ceThread listner");
        ceThreadLisCapteur.start();

        Log.e("", "thread worker et thread commence");

        for (int i = 0; i < 50; i++) {
            try {
                boolean value;

                value = cemdd.getvalue();
                publishProgress(value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Boolean... values) { // values c'est un tableau de tableua , le plus recent c'est celui
        if (values[0]) {
            ctr.effacerLesDeuxChamps();
            Log.e("", "value  attended");
        } else Log.e("", "value not attended");

    }
}

