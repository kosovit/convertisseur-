package com.example.ziyed.convertisseur.model;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.example.ziyed.convertisseur.LeWorker;
import com.example.ziyed.convertisseur.controller.CtrlChText;
import com.example.ziyed.convertisseur.controller.CtrlGlobal;
import com.example.ziyed.convertisseur.view.VueGlobal;

/**
 * Created by zna on 27/01/2017.
 */

public class ModelGlobal {
    private CtrlGlobal ctrl;
    private VueGlobal vue;
    private CtrlChText ctrlChText;

    public ModelGlobal(VueGlobal vue) {
        this.vue = vue;
        ctrl = new CtrlGlobal(this);
        ctrlChText = vue.getctrlChText();

    }

    public VueGlobal getVue() {
        return vue;
    }

    public CtrlGlobal getCtrl() {
        return ctrl;
    }

    public CtrlChText getctrlChText() {
        return vue.getctrlChText();
    }

    public void setMesListnner() {
        vue.getbtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vue.getSwitchState()) {
                    vue.getctrlChText().convertToDollar();

                } else {
                    vue.getctrlChText().convertToEuro();
                }
            }
        });

        vue.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                vue.getctrlChText().effacerLesDeuxChamps();
                Log.e("", "Longpress detected");
                return false;

            }
        });
        vue.getSwitcheur().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean switchState = vue.getSwitchState();
                Switch switcheur = vue.getSwitcheur();
                CtrlChText ctrlChText = vue.getctrlChText();
                Log.e("", "btn clicked");
                vue.getctrlChText().effacerLesDeuxChamps();
                switchState = switcheur.isChecked();
                Log.e("", String.valueOf(switchState));
                if (switchState) {
                    switcheur.setText("EURO->DOLLAR");
                    ctrlChText.setEuroDollar();
                } else {
                    switcheur.setText("DOLLAR-> EURO");
                    ctrlChText.setDollarEuro();
                }
            }
        });
    }

    public void activateThreadWorker() {
        new LeWorker(getctrlChText()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }
}
