package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrearCuenta extends AppCompatActivity {
    private Button btn_ir_crearCuenta,back;
    private TextView email,telefono,password,password2;
    private List<Usuario> Usuarios=new ArrayList<>();

    private Usuario user=new Usuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        back=findViewById(R.id.volver);
        email=findViewById(R.id.et_correo);
        telefono=findViewById(R.id.et_telefono);
        password=findViewById(R.id.et_contrasena);
        password2=findViewById(R.id.et_contrasena2);

        List<Usuario>  usu = (List<Usuario>) getIntent().getSerializableExtra("users");
        if (usu!=null){
            Usuarios=usu;
        }

    }


    public boolean check(){
        Toast toast = Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT);
        Boolean result=false;
        Boolean isin=false;
        String e= email.getText().toString();
        String t= telefono.getText().toString();
        String p= password.getText().toString();
        String p2= password2.getText().toString();
        for (Usuario user : Usuarios) {
            if (e.equals(user.getemail())){
                isin=true;
                break;
            }
        }
        if (!e.isEmpty()&&!t.isEmpty() &&p.equals(p2) && isin!=true){
            user.setemail(e);
            user.setpassword(p);
            result=true;
            Usuarios.add(user);
        }else if(isin.equals(true)) {
            toast.setText("Usuario ya registrado");
            toast.show();
        }else {
            toast.show();
        }
        return result;
    }

    public void login(View view){
        Toast toast = Toast.makeText(this, "Error al realizar log", Toast.LENGTH_SHORT);
        if (check()){
            try{
                Intent main = new Intent(this, MainActivity.class);
                main.putExtra("users", (Serializable) Usuarios);
                startActivity(main);
            }catch (Exception e){
                toast.show();
            }
        }

    }

    public void volver(View view){
        Toast toast = Toast.makeText(this, "Error al volver", Toast.LENGTH_SHORT);
        try{
            Intent bienvenida = new Intent(this, MainActivity.class);
            startActivity(bienvenida);
        }catch (Exception e){
            toast.show();
        }


    }
}