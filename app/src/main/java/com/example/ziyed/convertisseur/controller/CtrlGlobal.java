package com.example.ziyed.convertisseur.controller;

import com.example.ziyed.convertisseur.model.ModelGlobal;
import com.example.ziyed.convertisseur.view.VueGlobal;

/**
 * Created by zna on 27/01/2017.
 */

public class CtrlGlobal {
    private ModelGlobal model;
    private VueGlobal vue;

    public CtrlGlobal(final ModelGlobal m) {
        this.model = m;
        this.vue = m.getVue();

    }

    public CtrlChText getctrlChText() {
        return model.getctrlChText();
    }

    public void setLesListnner() {
        model.setMesListnner();


    }

    public void runThreadWorker() {
        model.activateThreadWorker();
    }
}
