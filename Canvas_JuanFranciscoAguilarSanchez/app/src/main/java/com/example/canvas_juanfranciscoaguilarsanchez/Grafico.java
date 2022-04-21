package com.example.canvas_juanfranciscoaguilarsanchez;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class Grafico extends View{
    double h=0,v=100,ang=50,t=0.05,p1=0,p2=0;

    public Grafico(Context context, AttributeSet argumentos) {
        super(context, argumentos);
    }

    protected void onDraw(Canvas canvas) {
        Paint pincel = new Paint();
        pincel.setColor(0x550000ff);
        pincel.setStrokeWidth(2);
        pincel.setStyle(Paint.Style.FILL_AND_STROKE);

        Paint pincel2 = new Paint();
        pincel2.setColor(Color.rgb(78,59,49));
        pincel.setColor(Color.rgb(0,0,0));


        float y=0,x=0;

        canvas.drawLine(80,0,80,2000,pincel);
        canvas.drawLine(0,810,2000,810,pincel);

            for (t=0.05;y>=-1;t+=0.05) {
                y =(float) (h+((v * Math.sin(Math.toRadians(ang)) * t)-((9.8 * t * t) / 2)));
                x = (float) ((v*Math.cos(Math.toRadians(ang))*t));
                canvas.drawCircle( x+85, -y+798, 5, pincel2);
            }

    }

    public void actualizar(int ang,int vel,int alt){
        Log.d(""," "+ang);
        this.ang=ang;
        this.v=vel;
        this.h=alt;
        invalidate();

    }

}