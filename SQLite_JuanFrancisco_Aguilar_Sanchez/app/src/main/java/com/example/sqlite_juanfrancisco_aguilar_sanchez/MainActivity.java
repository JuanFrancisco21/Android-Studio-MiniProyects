package com.example.sqlite_juanfrancisco_aguilar_sanchez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtCodigo,edtCurso,edtDescripcion;
    TextView edtLista;
    Button btnAgregar,btnEliminar,btnMostrar,btnEditar,btnMostrartodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo=findViewById(R.id.editCodigo);
        edtCurso=findViewById(R.id.editCurso);
        edtDescripcion=findViewById(R.id.editDescripcion);
        edtLista=findViewById(R.id.txtlista);

        btnAgregar=findViewById(R.id.btn_Agregar);
        btnEditar=findViewById(R.id.btn_Editar);
        btnEliminar=findViewById(R.id.btn_Eliminar);
        btnMostrar=findViewById(R.id.btn_Mostrar);
        btnMostrartodo=findViewById(R.id.btn_MostrarTodo);

    }
    public void Botonera(View view) {
        SQLiteBBDD x = new SQLiteBBDD( this, "BD_Cursos", null, 1);
        SQLiteDatabase bd = x.getWritableDatabase();
        int codigo = -1;
        float curso=1F;
        String descripcion="";
        try {
            codigo= (Integer.parseInt(edtCodigo.getText().toString()) );
            curso= (Float.parseFloat(edtCurso.getText().toString()) );
            descripcion=edtDescripcion.getText().toString();
        }catch (Exception e){}

        switch (view.getId()) {
            case R.id.btn_Agregar:
                Cursor tuplas =bd.rawQuery("Select * from cursos where codigo = " + codigo, null);
                if (tuplas.moveToFirst()){
                    Toast.makeText( this, "Objeto ya existente", Toast.LENGTH_SHORT).show();

                }else if (codigo>=0 && curso>=0 && descripcion!=null){
                    ContentValues tupla = new ContentValues();
                    tupla.put("codigo", codigo);
                    tupla.put("curso", curso);
                    tupla.put("descripcion", descripcion);

                    bd.insert("cursos", null, tupla);

                    Toast.makeText( this, "Articulo almacanado", Toast.LENGTH_SHORT).show();
                    edtCodigo.setText("");
                    edtCurso.setText("");
                    edtDescripcion.setText("");
                }else {
                    Toast.makeText( this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_Editar:
                if (codigo>=0 && curso>=0 && descripcion!=null){
                    ContentValues tupla = new ContentValues();
                    tupla.put("codigo", codigo);
                    tupla.put("curso", curso);
                    tupla.put("descripcion", descripcion);

                    bd.update("cursos", tupla, "codigo ="+codigo,null);

                    Toast.makeText( this, "Articulo actualizado", Toast.LENGTH_SHORT).show();
                    edtCodigo.setText("");
                    edtCurso.setText("");
                    edtDescripcion.setText("");
                }else {
                    Toast.makeText( this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_Eliminar:
                if (codigo>=0){

                    int borrados = bd.delete("cursos", "id = " + codigo, null);

                    if(borrados!=0) {
                        Toast.makeText(this, "Artículo borrado", Toast.LENGTH_SHORT).show();
                        edtCodigo.setText("");
                        edtDescripcion.setText("");
                        edtCurso.setText("");
                    }
                    else {
                        Toast.makeText( this, "Artículo no existente", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText( this, "Código no valido", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_Mostrar:
                if (codigo>=0){
                    tuplas =bd.rawQuery("Select * from cursos where codigo = " + codigo, null);

                    if(tuplas.moveToFirst()) {
                        edtCodigo.setText(tuplas.getString(0));
                        edtCurso.setText(tuplas.getString(1));
                        edtDescripcion.setText(tuplas.getString(2));

                        Toast.makeText(this, "Artículo recuperado", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText( this, "Artículo no encontrado", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText( this, "Codigo fuera de rango", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_MostrarTodo:
                    tuplas =bd.rawQuery("Select * from cursos ", null);

                    if(tuplas!=null) {
                        String todos="";
                        while (tuplas.moveToNext()){
                            todos=todos+"\ncodigo ="+tuplas.getString(0)+"  curso="+tuplas.getString(1)+"  descripcion="+tuplas.getString(2);
                        }
                        edtLista.setText(todos);
                    }
                    else {
                        Toast.makeText( this, "Artículo no encontrado", Toast.LENGTH_SHORT).show();
                    }

                break;

        }
    }
}