package com.example.lu.spaceinvader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by lu on 2016-04-18.
 */
public class Text extends Container {
    private Paint p;

    private String Text;
    private String TextToShow;

    private int data_saved;
    public Text(float x,float y,String text,int data,int WIDTH,int HEIGHT){
        p=new Paint();
        setX(x);
        setY(y);
        setHeight(HEIGHT);
        setWidth(WIDTH);
        setData_saved(data);
        p.setStrokeWidth(3);
        p.setTextSize(40);
        p.setColor(Color.RED);
        p.setTextAlign(Paint.Align.LEFT);
        setText(text);
    }
    public Text(float x,float y,String text,int WIDTH,int HEIGHT){
        p=new Paint();
        setX(x);
        setY(y);
        setHeight(HEIGHT);
        setWidth(WIDTH);
        p.setStrokeWidth(3);
        p.setTextSize(40);
        p.setColor(Color.RED);
        p.setTextAlign(Paint.Align.LEFT);
        setText(text);
    }
    public void costomDraw(Canvas canvas){
        super.costomDraw(canvas);
        setTextToShow(getText() + Integer.toString(data_saved));
        Rect bounds=new Rect();
        p.getTextBounds(TextToShow, 0, TextToShow.length(), bounds);
        canvas.drawText(TextToShow, getX()+ bounds.width()/2, getY()+ bounds.height()/2, p);
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public int getData_saved() {
        return data_saved;
    }

    public void setData_saved(int data_saved) {
        this.data_saved = data_saved;
    }



    public String getTextToShow() {
        return TextToShow;
    }

    public void setTextToShow(String textToShow) {
        TextToShow = textToShow;
    }
}
