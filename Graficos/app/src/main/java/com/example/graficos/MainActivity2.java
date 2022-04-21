package com.example.graficos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void Volver(View view){
        Intent pantalla2 = new Intent(this, MainActivity.class);
        pantalla2.putExtra("dato1", "mtx_mensaje.getText().toString())");
        startActivity(pantalla2);
    }
}