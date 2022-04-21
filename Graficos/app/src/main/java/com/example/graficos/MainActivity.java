package com.example.graficos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView min_image;
    private Button mbt_mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        min_image = (ImageView) findViewById(R.id.cim_oche);
        min_image.setVisibility(View.INVISIBLE);
        mbt_mostrar = (Button) findViewById(R.id.cbt_mostrar);
    }
    public void mostrar(View view){
        min_image.setVisibility(View.VISIBLE);
        mbt_mostrar.setVisibility(View.INVISIBLE);
    }
    public void ocultar(View view){
        min_image.setVisibility(View.INVISIBLE);
        mbt_mostrar.setVisibility(View.VISIBLE);
    }
    public void Volver(View view){
        Intent pantalla2 = new Intent(this, MainActivity2.class);
        //pantalla2.putExtra(name="dato1", "mtx_mensaje.getText().toString())";  new Intent(packageContext= this, MainActivity2.class);
        startActivity(pantalla2);
    }
}