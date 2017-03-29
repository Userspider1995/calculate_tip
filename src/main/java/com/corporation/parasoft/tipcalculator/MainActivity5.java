package com.corporation.parasoft.tipcalculator;

import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity5 extends AppCompatActivity  implements View.OnClickListener {
    private EditText edit1;
    private TextView text1,text2,text3,text4,text5,text6;
    ImageButton button1,button2,button3;
    float percentage=0;
    float tiptotal=0;
    float finalbillamount=0;
    float totalbillamount=0;
    float DEFAULT_TIP_PERCENT=10;
    float REGULAR_TIP_PERCENT=15;
    float EXCELLENT_TIP_PERCENT=20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        addListenerOnButton();
        setTipvalues();
        ButterKnife.bind(this);
        //onTextChanged();

    }
    protected  void addListenerOnButton()
    {
        text3=(TextView)findViewById(R.id.T3);
        text4=(TextView)findViewById(R.id.T4);
        text6=(TextView)findViewById(R.id.T6);
        button1=(ImageButton)findViewById(R.id.I1);
        button2=(ImageButton) findViewById(R.id.I2);
        button3=(ImageButton)findViewById(R.id.I3);
        edit1=(EditText)findViewById(R.id.E1);
        button3.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.I1:
                percentage=DEFAULT_TIP_PERCENT;
                break;
            case R.id.I2:
                percentage=REGULAR_TIP_PERCENT;
                break;
            case R.id.I3:
                percentage=EXCELLENT_TIP_PERCENT;
                break;
        }
        setTipvalues();
        onTextChanged();
    }

    protected void setTipvalues()
    {
        text3.setText(getString(R.string.main_msg_tippercent,percentage));
        text4.setText(getString(R.string.main_msg_tiptotal,tiptotal));
        text6.setText(getString(R.string.main_msg_billtotalresult,finalbillamount));
    }


    public void onTextChanged()
    {

        calculate();
        setTipvalues();
    }

    public void calculate()
    {
        if( percentage==0 )
        {
            percentage=DEFAULT_TIP_PERCENT;
        }
        totalbillamount=Float.valueOf(edit1.getText().toString());
        tiptotal =(totalbillamount*percentage)/100;
        finalbillamount=tiptotal+totalbillamount;
    }






}
