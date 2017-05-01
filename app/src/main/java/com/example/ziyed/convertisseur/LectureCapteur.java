package com.example.ziyed.convertisseur;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.example.ziyed.convertisseur.view.VueGlobal;


/**
 * Created by wro on 17/01/2017.
 */

public class LectureCapteur extends Thread {
    private MDD monmdd;
    private String nom;
    private Sensor mAccelerometer = null;

    public LectureCapteur(MDD monmdd, String nom) {
        super();
        this.monmdd = monmdd;
        this.nom = nom;
    }

    @Override
    public void run() {
        mAccelerometer = VueGlobal.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        VueGlobal.sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                if (Math.abs(x) >= 6.0) {
                    monmdd.setvalues(true);
                    Log.e("sensor", String.valueOf(x));
                } else
                    monmdd.setvalues(false);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        }, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }
}
