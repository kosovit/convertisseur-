package com.example.ziyed.convertisseur.model;

import com.example.ziyed.convertisseur.controller.CtrlChText;
import com.example.ziyed.convertisseur.view.VueChText;

/**
 * Created by zna on 26/01/2017.
 */

public class ModelChText {

    private final double change = 1.07;
    private CtrlChText ctrl;
    private VueChText vue;


    public ModelChText(VueChText vue) {
        this.vue = vue;
        ctrl = new CtrlChText(this);
    }

    public CtrlChText getCtrl() {
        return ctrl;
    }


    public VueChText getVue() {
        return vue;
    }

    public void setVue(final VueChText v) {
        vue = v;
    }

    public void setEuro(String d) {
        if (isDouble(d)) {
            this.vue.getEditText2().setText(String.valueOf(Double.valueOf(d) * (1 / change)));

        }
    }

    public void setDollar(String e) {
        if (isDouble(e)) {
            this.vue.getEditText2().setText(String.valueOf(Double.valueOf(e) * change));
        }
    }

    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void getValChamp() {

    }

    public void setValChamp1(final String v) {

    }

    public void setValChamp2(final String v) {

    }


    public void evtChamVide() {
    }

    public void effecerLesCh() {
        vue.getEditText1().setText("");
        vue.getEditText2().setText("");
    }
}
