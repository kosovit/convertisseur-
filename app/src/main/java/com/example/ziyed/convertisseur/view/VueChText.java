package com.example.ziyed.convertisseur.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ziyed.convertisseur.R;
import com.example.ziyed.convertisseur.controller.CtrlChText;
import com.example.ziyed.convertisseur.model.ModelChText;

/**
 * Created by zna on 26/01/2017.
 */

public class VueChText extends RelativeLayout {
    private ModelChText mod;
    private CtrlChText ctrl;
    private TextView textView1;
    private TextView textView2;
    private EditText editText1;
    private EditText editText2;

    public VueChText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public VueChText(Context context) {
        super(context);
    }

    public VueChText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context ctx, AttributeSet attrs) {

        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(R.layout.agentchamptexte_layout, null);
        textView1 = (TextView) v.findViewById(R.id.label_1_id);
        textView2 = (TextView) v.findViewById(R.id.label_2_id);

        editText1 = (EditText) v.findViewById(R.id.input_id);
        editText2 = (EditText) v.findViewById(R.id.output_id);


        addView(v);


        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.vuechtext);

        a.recycle();

    }

    public TextView getTextView1() {
        return textView1;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public EditText getEditText1() {
        return editText1;
    }

    public EditText getEditText2() {
        return editText2;
    }
}