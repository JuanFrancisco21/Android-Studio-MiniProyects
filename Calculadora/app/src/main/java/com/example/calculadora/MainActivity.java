package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mtx_num1,mtx_num2;
    private RadioButton rbsum,rbrest,rbmult,rbdiv;
    private CheckBox cbsum,cbrest,cbmult,cbdiv;
    private TextView mtx_resl;
    private Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtx_num1 = (EditText) findViewById(R.id.ctx_num1);
        mtx_num2 = (EditText) findViewById(R.id.ctx_num2);
        //Radio butons-------------------------------------------------
        rbsum = (RadioButton) findViewById(R.id.radioButtonsum);
        rbrest = (RadioButton) findViewById(R.id.radioButtonrest);
        rbmult = (RadioButton) findViewById(R.id.radioButtonmult);
        rbdiv = (RadioButton) findViewById(R.id.radioButtondiv);
        //Radio butons-------------------------------------------------
        //CheckBoc-----------------------------------------------------
        cbsum = (CheckBox) findViewById(R.id.checkBoxsum);
        cbrest = (CheckBox) findViewById(R.id.checkBoxrest);
        cbmult = (CheckBox) findViewById(R.id.checkBoxmult);
        cbdiv = (CheckBox) findViewById(R.id.checkBoxdiv);
        //CheckBoc-----------------------------------------------------
        mtx_resl = (TextView) findViewById(R.id.ctx_resultado);
        b1 = (Button) findViewById(R.id.button);
    }

    public void calcular(View view){
        if (rbsum.isChecked() == true) {
            mtx_resl.setText( "Resultado= "+suma());
        }else if (rbrest.isChecked() == true){
            mtx_resl.setText( "Resultado= "+resta());
        }else if (rbdiv.isChecked() == true){
            mtx_resl.setText( "Resultado= "+divide());
        }else if (rbmult.isChecked() == true){
            mtx_resl.setText( "Resultado= "+multiplica());
        }
    }
    public void calcular2(View view){
        String result="";
        if (cbsum.isChecked() == true) {
            result=(result+ " Suma = "+suma());
        }if (cbrest.isChecked() == true){
            result=(result+ " Resta = "+resta());
        }if (cbdiv.isChecked() == true){
            result=(result+ " División = "+divide());
        }if (cbmult.isChecked() == true){
            result=(result+ " Multiplicación = "+multiplica());
        }
        mtx_resl.setText(result);

    }



    public Double suma(){
        Double result=0.0,num1,num2;
        num1 = Double.parseDouble(mtx_num1.getText().toString());
        num2 = Double.parseDouble(mtx_num2.getText().toString());
        result = num1+num2 ;
        return result;
    }
    public Double resta(){
        Double result=0.0,num1,num2;
        num1 = Double.parseDouble(mtx_num1.getText().toString());
        num2 = Double.parseDouble(mtx_num2.getText().toString());
        result = num1-num2 ;
        return result;
    }
    public Double divide(){
        Double result=0.0,num1,num2;
        num1 = Double.parseDouble(mtx_num1.getText().toString());
        num2 = Double.parseDouble(mtx_num2.getText().toString());
        if (num2!=0) {
            result = num1 / num2;
        }
        return result;
    }
    public Double multiplica(){
        Double result=0.0,num1,num2;
        num1 = Double.parseDouble(mtx_num1.getText().toString());
        num2 = Double.parseDouble(mtx_num2.getText().toString());
        result = num1*num2 ;
        return result;
    }
}