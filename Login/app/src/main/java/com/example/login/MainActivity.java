package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_ir_crearCuenta,iniciar_sesion;
    private TextView email,password;
    private List<Usuario> Usuarios=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);
        email=findViewById(R.id.et_correo);
        password=findViewById(R.id.et_contrasena);
        Bundle parametros = this.getIntent().getExtras();
        //Intent i = getIntent();
        /*Usuarios = (List<Usuario>) i.getSerializableExtra("usuarios");*/
        Usuarios.add(new Usuario("log","123"));

        List<Usuario>  users = (List<Usuario>) getIntent().getSerializableExtra("users");
        if (users!=null){
            Usuarios = users;
        }
        Usuario  usu = (Usuario) getIntent().getSerializableExtra("usuario");
        if (usu!=null){
            Usuarios.add(usu);
        }



    }
    public boolean check(){
        Boolean result=false;
        String e= email.getText().toString();
        String p= password.getText().toString();
        for (Usuario user : Usuarios) {
            if (e.equals(user.getemail())&&p.equals(user.getpassword())){
                result=true;
                break;
            }else{

            }
        }
        return result;
    }
    public void login(View view){
        Toast toast = Toast.makeText(this, "Error al realizar log", Toast.LENGTH_SHORT);
        if (check()){
            try{
                Intent bienvenida = new Intent(this, Bienvenida.class);
                bienvenida.putExtra("users", (Serializable) Usuarios);
                startActivity(bienvenida);
            }catch (Exception e){
                toast.show();
            }
        }else{
            toast.setText("Credenciales no válidas");
            toast.show();
        }

    }
    public void CrearCuenta(View view){
        Toast toast = Toast.makeText(this, "Error pantalla crear", Toast.LENGTH_SHORT);

        try{
            Intent crear = new Intent(this, CrearCuenta.class);
            crear.putExtra("users", (Serializable) Usuarios);
            startActivity(crear);
        }catch (Exception e){
            toast.show();
        }


    }
    public void recuperarCuenta(View view){
        Toast toast = Toast.makeText(this, "Introduce el usuario", Toast.LENGTH_SHORT);
        boolean result=false;
        String e= email.getText().toString();
        String p= " ";

        try{
            if (!e.isEmpty()){
                for (Usuario user : Usuarios) {//revisa la lista de usuarios para recuperar la contraseña
                    if (e.equals(user.getemail())){//si lo encuentra la muestra
                        p=user.getpassword();
                        toast.setText("La contraseña es: "+p);
                        toast.show();
                        result=true;
                        break;
                    }
                }
            if(result!=true){//si no encuentra usuario lo dice
                    toast.setText("Usuario no encontrado");
                    toast.show();
                }
            }else {//Si el email esta vacio lo indica
                toast.show();
            }

        }catch (Exception e1){
            toast.show();
        }


    }
}