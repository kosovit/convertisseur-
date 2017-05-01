package com.example.ziyed.convertisseur.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.ziyed.convertisseur.R;
import com.example.ziyed.convertisseur.controller.CtrlChText;
import com.example.ziyed.convertisseur.model.ModelChText;

/**
 * Created by zna on 27/01/2017.
 */

public class VueGlobal extends RelativeLayout {
    public static SensorManager sensorManager;
    private Sensor sensor;
    private Switch switcheur;
    private Boolean switchState;
    private Button btnConvertisseur;
    private VueChText champText;
    private ModelChText modelChText;
    private CtrlChText ctrlChText;

    public VueGlobal(Context context) {
        super(context);
    }

    public VueGlobal(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public VueGlobal(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Switch getSwitcheur() {
        return switcheur;
    }

    public Boolean getSwitchState() {
        return switchState;
    }

    public void setSwitchState(Boolean switchState) {
        this.switchState = switchState;
    }

    private void init(Context ctx, AttributeSet attrs) {
        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.activity_main_layout, null);

        champText = (VueChText) v.findViewById(R.id.mes_champs_text_id);
        modelChText = new ModelChText(champText);
        ctrlChText = modelChText.getCtrl();
        switcheur = (Switch) v.findViewById(R.id.switcheur);
        switchState = switcheur.isChecked();

        btnConvertisseur = (Button) v.findViewById(R.id.button_convertisseur);
        addView(v);
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.vuechtext);

        a.recycle();
        sensorManager = (SensorManager) ctx.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    public Button getBtnConvertisseur() {
        return btnConvertisseur;
    }


    public VueChText getChampText() {
        return champText;
    }


    public CtrlChText getctrlChText() {
        return ctrlChText;
    }

    public Button getbtn() {
        return btnConvertisseur;
    }


}
