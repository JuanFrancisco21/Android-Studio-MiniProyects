package com.example.aplicacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mtx_nombre;
    private TextView mtx_mensaje;
    private Button mtx_saluda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtx_nombre = (EditText) findViewById(R.id.ctx_Nombre);
        mtx_mensaje = (TextView) findViewById(R.id.ctx_resultado);
    }
    public void saluda(View view){
        mtx_mensaje.setText( "Hola "+mtx_nombre.getText());
    }
    public void despide(View view){
        mtx_mensaje.setText( "Adios "+mtx_nombre.getText());
    }
}