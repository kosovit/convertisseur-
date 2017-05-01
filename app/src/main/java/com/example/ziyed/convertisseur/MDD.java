package com.example.ziyed.convertisseur;

/**
 * Created by zna on 17/01/2017.
 */

public class MDD {

    private String nommdd;
    private boolean aBoolean;

    public MDD(String nommdd) {
        this.nommdd = nommdd;
    }

    public String getNommdd() {
        return nommdd;
    }

    public synchronized void setvalues(boolean e) {
        aBoolean = e;
    }

    public synchronized boolean getvalue() {

        return aBoolean;
    }


}
