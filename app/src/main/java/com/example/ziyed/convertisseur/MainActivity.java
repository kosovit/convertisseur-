package com.example.ziyed.convertisseur;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import com.example.ziyed.convertisseur.controller.CtrlChText;
import com.example.ziyed.convertisseur.controller.CtrlGlobal;
import com.example.ziyed.convertisseur.model.ModelGlobal;
import com.example.ziyed.convertisseur.view.VueGlobal;


public class MainActivity extends Activity {


    public static SensorManager sensorManager;
    Boolean switchState;
    private Switch switcheur;
    private Button btnConvertisseur;
    private VueGlobal vueGlobal;
    private ModelGlobal modelGlobal;
    private CtrlGlobal ctrlGlobal;
    private CtrlChText ctrlChText;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        VueGlobal vueGlobal = (VueGlobal) findViewById(R.id.main_id);
        ModelGlobal modelGlobal = new ModelGlobal(vueGlobal);
        CtrlGlobal ctrlGlobal = modelGlobal.getCtrl();

        ctrlGlobal.setLesListnner();
        ctrlGlobal.runThreadWorker();


    }


}

