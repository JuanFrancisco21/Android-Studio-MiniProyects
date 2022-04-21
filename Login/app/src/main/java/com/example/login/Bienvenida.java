package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bienvenida extends AppCompatActivity {
    private List<Usuario> Usuarios=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        List<Usuario>  usu = (List<Usuario>) getIntent().getSerializableExtra("users");
        if (usu!=null){
            Usuarios=usu;
        }
    }
    public void logout(View view){
        Toast toast = Toast.makeText(this, "Error al realizar log", Toast.LENGTH_SHORT);
            try{
                Intent main = new Intent(this, MainActivity.class);
                main.putExtra("users", (Serializable) Usuarios);
                startActivity(main);
            }catch (Exception e){
                toast.show();
            }
    }

}
