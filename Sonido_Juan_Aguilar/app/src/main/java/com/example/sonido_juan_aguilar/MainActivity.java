package com.example.sonido_juan_aguilar;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

/*public class MainActivity extends AppCompatActivity {
    Button mtb_play;
    MediaPlayer sonido;
    //MediaPlayer sonido [] = new MediaPlayer[2];

    int Posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtb_play = findViewById(R.id.mtb_play);

        sonido = MediaPlayer.create(this,R.raw.dimetusecleto);
        *//*sonido[0] = MediaPlayer.create(this,R.raw.tetubi);
        sonido[1] = MediaPlayer.create(this,R.raw.dimetusecleto);*/

    //}

    /*public void BotonesMusica(View view){
        switch (view.getId()){
            case R.id.mtb_play:
                if (sonido[Posicion].isPlaying()){
                    mtb_play.setText("Play");
                    sonido[Posicion].pause();
                }else if (!sonido[Posicion].isPlaying()){
                    mtb_play.setText("Pause");
                    sonido[Posicion].start();
                }
                break;
            case R.id.mtb_stop:
                sonido[Posicion].pause();
                sonido[Posicion].reset();
                break;
        }
    }*//*
    public void BotonesMusica(View view){
        switch (view.getId()){
            case R.id.mtb_play:
                if (sonido.isPlaying()){
                    mtb_play.setText("Play");
                    sonido.pause();
                }else if (!sonido.isPlaying()){
                    mtb_play.setText("Pause");
                    sonido.start();
                }
                break;
            case R.id.mtb_stop:
                sonido.stop();
                break;
        }
    }

    public void CargarCanciones(View view){
        MediaPlayer sonidos= new MediaPlayer();
        String ficheroExterno;
        try {
            ficheroExterno = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Sonido1.mp3";
            sonidos.setDataSource(ficheroExterno);
            sonidos.prepare();
            sonidos.start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void GrabarCanciones(View view){
        MediaRecorder grabacion= new MediaRecorder();
        String ficheroExterno;
        try {
            if (grabacion == null) {
                ficheroExterno = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"+"Sonido1.mp3";
                grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
                grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                grabacion.setOutputFile(ficheroExterno);
                try {
                    grabacion.prepare();
                    grabacion.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                grabacion.stop();
                grabacion.release();
                grabacion = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}*/
public class MainActivity extends AppCompatActivity {
    EditText met_fichero;
    Button mbt_play, mbt_repetir, mbt_grabar;
    Boolean repetir = false;

    int numero_canciones = 2;
    int posicion = 0;
    MediaPlayer lista_canciones[] = new MediaPlayer[numero_canciones];
    MediaRecorder grabacion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        met_fichero = (EditText) findViewById(R.id.cet_fichero);
        mbt_play = (Button) findViewById(R.id.cbt_playpause);
        mbt_repetir = (Button) findViewById(R.id.cbt_repetir);
        mbt_grabar = (Button) findViewById(R.id.cbt_grabar);
        CargaCanciones();
    }
    public void CargaCanciones() {
        lista_canciones[0] = MediaPlayer.create(this, R.raw.dimetusecleto);
        lista_canciones[1] = MediaPlayer.create(this, R.raw.tetubi);
    }

        public void BotonesMusica(View view){
            switch (view.getId()){
                case R.id.cbt_playpause:
                    if (lista_canciones[posicion].isPlaying()) {
                        mbt_play.setText("Play");
                        lista_canciones[posicion].pause();
                        Toast.makeText( this, "Pausado", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        mbt_play.setText("Pause");
                        lista_canciones[posicion].start();
                        Toast.makeText( this, "Reproduciendo", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.cbt_stop:
                    mbt_play.setText("Play");
                    lista_canciones[posicion].stop();
                    CargaCanciones();
                    break;

                case R.id.cbt_repetir:
                    if (repetir == true) {
                        mbt_repetir.setText("No repetir");
                        Toast.makeText( this, "Repetición desactivada", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        mbt_repetir.setText("Repetir");
                        Toast.makeText( this, "Repetición activada", Toast.LENGTH_SHORT).show();
                    }
                    repetir = !repetir;
                    lista_canciones[posicion].setLooping(repetir);
                    break;

                case R.id.cbt_atras:
                    if (posicion != 0) {
                        lista_canciones[posicion].pause();
                        posicion--;
                        lista_canciones[posicion].start();
                    }
                    else {
                        Toast.makeText( this, "Primera canción", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.cbt_alante:
                    if (posicion != (numero_canciones-1)) {
                        lista_canciones[posicion].pause();
                        posicion++;
                        lista_canciones[posicion].start();
                    }
                    else {
                        Toast.makeText( this, "Última canción", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cbt_reproducir:
                    MediaPlayer sonido = new MediaPlayer();
                    String ficheroExterno;
                    try {
                        ficheroExterno = Environment.getExternalStorageDirectory().getAbsolutePath()
                                + "/" + met_fichero.getText().toString() + ".mp3";
                        sonido.setDataSource(ficheroExterno);
                        sonido.prepare();
                        sonido.start();
                        Toast.makeText( this, "Reproduciendo el fichero", Toast.LENGTH_SHORT).show();
                    }
                    catch (IOException e) {
                        Toast.makeText( this, "Existe algún error", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }

    public void Grabador(View view) {
//      MediaRecorder grabacion = new MediaRecorder();
        String ficheroExterno;

        if (grabacion == null) {
            grabacion = new MediaRecorder();
            ficheroExterno = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/" + met_fichero.getText().toString() + ".mp3";
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            grabacion.setOutputFile(ficheroExterno);

            try {
                grabacion.prepare();
                grabacion.start();
            } catch (IOException e) {
            }
            mbt_grabar.setText("Parar");
            Toast.makeText( this, "Grabando...", Toast.LENGTH_SHORT).show();
        }
        else {
            grabacion.stop();
            grabacion.release();
            grabacion = null;
            mbt_grabar.setText("Grabar");
            Toast.makeText( this, "Grabación parada", Toast.LENGTH_SHORT).show();
        }
    }
}