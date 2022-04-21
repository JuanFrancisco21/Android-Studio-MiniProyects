package com.example.parejas_juanaguilar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText mtx_clave1, mtx_clave2;
    private TextView mtx_full;
    private Button btnguardar,btnactualizar,btnbuscar,btnborrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtx_clave1=findViewById(R.id.mtxprimero);
        mtx_clave2=findViewById(R.id.mtxsegundo);
        mtx_full=findViewById(R.id.mtxfull);
        btnguardar=findViewById(R.id.btnguardar);
        btnbuscar=findViewById(R.id.btnbuscar);
        btnactualizar=findViewById(R.id.btnactualizar);
        btnborrar=findViewById(R.id.btnborrar);
        idioma();
    }
    public void idioma(){
        String lang = Locale.getDefault().getLanguage();
        if (lang.equals("en")) {
            btnborrar.setText("Delete");
            btnbuscar.setText("Search");
            btnactualizar.setText("Update");
            btnguardar.setText("Save");
        }
    }
    public void botones(View view) {
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        SharedPreferences datos = getSharedPreferences("informacion", Context.MODE_PRIVATE);
        SharedPreferences.Editor tupla = datos.edit();

        String dato1 = mtx_clave1.getText().toString();
        String dato2 = mtx_clave2.getText().toString();

        if(dato1.length()>=3 && dato2.length()>=3){
            switch (view.getId()){
                case R.id.btnguardar:
                    if (datos.getString(dato1,"").length()<1){
                        tupla.putString(dato1, dato2);
                        tupla.commit();
                        mtx_clave1.setText("");
                        mtx_clave2.setText("");
                        toast.setText("Guardado corectamente");
                        toast.show();
                    }else{
                        toast.setText("Datos ya registrados");
                        toast.show();
                    }
                    break;
                case R.id.btnactualizar:
                    if (datos.getString(dato1,"")!=null){
                        tupla.putString(dato1, dato2);
                        tupla.commit();
                        mtx_clave1.setText("");
                        mtx_clave2.setText("");
                        toast.setText("Actualizado corectamente");
                        toast.show();
                    }else{
                        toast.setText("Datos no existentes");
                        toast.show();
                    }
                    break;

                case R.id.btnborrar:
                    if(mtx_clave1.getText().toString().length()>=3) {

                        if (datos.getString(mtx_clave1.getText().toString(), "").length()>2) {
                            tupla.remove(String.valueOf(mtx_clave1.getText()));
                            tupla.commit();
                            toast.setText("Se ha borrado " + mtx_clave1.getText().toString());
                            toast.show();
                            mtx_clave1.setText("");
                            mtx_clave2.setText("");
                            mtx_full.setText("!Borrado¡");
                        } else {
                            toast.setText("No existe el usuario");
                            toast.show();
                        }
                    }else{
                        toast.setText("Rellena todos campos");
                        toast.show();
                    }
                    break;
            }
        }else if (view.getId()==R.id.btnactualizar || view.getId()==R.id.btnguardar ){
            toast.setText("Rellena todos campos");
            toast.show();
        }
        switch (view.getId()) {
            case R.id.btnbuscar:
                mtx_full.setText("");
                String busc = datos.getString(dato1, "");
                if (busc!=null && busc.length()>=1){
                    mtx_full.setText(dato1+" : "+busc);
                }else if (mtx_clave1.getText().length()<1){
                    Map<String, ?> full= datos.getAll();
                    for (Map.Entry<String, ?> entry : full.entrySet()){
                        mtx_full.setText(mtx_full.getText()+"\n"+entry.getKey()+" : "+entry.getValue().toString());
                    }
                }
                break;
        }
    }


}