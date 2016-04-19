package com.example.lu.spaceinvader;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by lu on 2016-03-23.
 */
public class mainHeroine extends Container{
    private Bitmap protector;
    private Paint p;
    private int speed;
    private Rect mSrcRect, mDestRect;
    public mainHeroine(float width,float height,Bitmap bitmap){
        p=new Paint();
        setX(500);
        setY(600);
        setHeight(height);
        setWidth(width);
        setSpeed(20);
        protector=bitmap;
        p.setColor(Color.WHITE);
        setmDestRect(new Rect((int) getX(), (int) getY(), (int) getX() + 184, (int) getY() + 104));
    }

    @Override
    public void costomDraw(Canvas canvas) {
        super.costomDraw(canvas);
       // canvas.drawCircle(getX(), getY(), getWidth(), p);
        setmDestRect(new Rect((int) getX(), (int) getY(), (int) getX() + 92, (int) getY() + 52));
        canvas.drawBitmap(protector,null,mDestRect,p);
    }

    public void move(float touch_x,float touch_y,boolean is_point){
       if (is_point) {
           if (touch_x > getX()) {
               setX(getX()+getSpeed());
           }
           if (touch_x < getX()){
               setX(getX()-getSpeed());
           }
           if (touch_y > getY()) {
               setY(getY()+getSpeed());
           }
           if (touch_y < getY()) {
               setY(getY()-getSpeed());
           }
       }


    }

    public Rect getmDestRect() {
        return mDestRect;
    }

    public void setmDestRect(Rect mDestRect) {
        this.mDestRect = mDestRect;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
