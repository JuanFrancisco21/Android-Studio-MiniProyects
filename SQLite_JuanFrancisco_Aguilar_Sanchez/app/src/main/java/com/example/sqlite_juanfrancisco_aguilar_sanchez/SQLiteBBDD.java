package com.example.sqlite_juanfrancisco_aguilar_sanchez;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteBBDD extends SQLiteOpenHelper {
    //Creamos el constructor
    public SQLiteBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    //La primera vez que lo llamemos crea la tabla artículos
    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL(
                "Create table cursos" +
                        "( codigo int primary key," +
                        "  curso float(6,2)," +
                        "  descripcion char(50) );");
    }

    //Cuando se actualice la Base de datos
    // (No hacemos nada pero hay que poner el método)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*private static final String NAME_BD="CURSOSBBDD";
    private static final int VERSION_BD=1;
    private static final String TABLE_CURSOS="CREATE TABLE CURSOS(CODIGO INT PRIMARY KEY, CURSO FLOAT, DESCRIPCION TEXT)";


    public SQLiteBBDD(Context context) {
        super(context, NAME_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        *//*db.execSQL("DROP TABLE IF EXISTS "+TABLE_CURSOS);
        db.execSQL(TABLE_CURSOS);

    }*/

    /*public void agregarCursos(int codigo,float curso,String Descripcion) {
        SQLiteDatabase db=getWritableDatabase();
        if (db!=null && codigo==-1){
            ContentValues tupla = new ContentValues();
            tupla.put("id", codigo);
            tupla.put("nombre", curso);
            tupla.put("precio", Descripcion);

            db.insert("CURSOS",null, tupla);
            //db.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+Descripcion+"')");
            //db.close();
        }

    }
    public void mostrarCursos() {
        SQLiteDatabase db=getWritableDatabase();
        if (db!=null ){
            /*db.execSQL("SELECT * FROM CURSOS");
            return*/


            //db.execSQL("INSERT INTO CURSOS VALUES('"+codigo+"','"+curso+"','"+Descripcion+"')");
            //db.close();
        /*}

    }*/
   /* public void eliminarCursos(String codigo) {
        SQLiteDatabase db=getWritableDatabase();
        if (db!=null){
            db.execSQL("INSERT INTO CURSOS VALUES(codigo)");
            db.close();
        }

    }*/

}
