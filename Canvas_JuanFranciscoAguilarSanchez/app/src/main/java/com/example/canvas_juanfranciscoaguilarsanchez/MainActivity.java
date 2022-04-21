package com.example.canvas_juanfranciscoaguilarsanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btndibujar;
    private EditText mtx_vel,mtx_alt,mtx_ang;
    private Grafico grafica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndibujar=findViewById(R.id.btndibujar);
        mtx_alt=findViewById(R.id.mtx_alt);
        mtx_vel=findViewById(R.id.mtx_vel);
        mtx_ang=findViewById(R.id.mtx_ang);
        this.grafica=(Grafico) findViewById(R.id.grafica);
        idioma();
    }

    public void idioma(){
        String lang = Locale.getDefault().getLanguage();
        if (lang.equals("en")) {
            btndibujar.setText("Draw");
        }
    }

    public void dibujar(View view){
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        int ang,vel,alt;
        try {
            if (mtx_ang.getText().length()>=1 && mtx_vel.getText().length()>=1 && mtx_alt.getText().length()>=1){
                ang=Integer.parseInt(String.valueOf(mtx_ang.getText()));
                vel=Integer.parseInt(String.valueOf(mtx_vel.getText()));
                alt=Integer.parseInt(String.valueOf(mtx_alt.getText()));

                grafica.actualizar(ang,vel,alt);
            }else{
                toast.setText("Rellena todos los campos");
                toast.show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}