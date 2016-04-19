package com.example.lu.spaceinvader;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by lu on 2016-03-28.
 */
public class enemy extends Container{
    private  boolean IF_DIE=false;
    private int Num;
    private int Move_Type=1;
    private final int DEFAULT=0,SPACE_INVADER=1;
    private int Move_Direction=0;
    private final int LEFT=0,RIGHT=1;
    private Paint p;
    private int animation=0;
    private final int picture1=0,picture2=1;
    private int Row;
    private Bitmap invader1;
    private Bitmap invader2;
    private Rect mSrcRect, mDestRect;
    public enemy(float width,float height,float x,float y,Bitmap bitmap1,Bitmap bitmap2){
       // bulletEnemy m=new bulletEnemy(this);
        p=new Paint();
       // p.setColor(Color.WHITE);
        setInvader(bitmap1);
        setInvader2(bitmap2);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
       // mDestRect=new Rect((int)getX(),(int)getY(),256,256);
    }

    public void costomDraw(Canvas canvas){
        super.costomDraw(canvas);
        //canvas.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), p);
        setmDestRect(new Rect((int) getX(), (int) getY(), (int) getX() + 52, (int) getY() + 41));
        setmSrcRect(new Rect(0, 0, 439, 226));
        switch(animation){
            case picture1:
             canvas.drawBitmap(invader1, null, mDestRect, p);
             animation=picture2;
             break;
            case picture2:
             canvas.drawBitmap(invader2, null, mDestRect, p);
             animation=picture1;
             break;
            default:
                break;
        }
    }
    public void move() {

        switch (Move_Type) {

            case DEFAULT:
                setY(getY() + 10);
                break;
            case SPACE_INVADER:
                if(Move_Direction==LEFT)
                {
                    setX(getX() - 20);
                }
                if (Move_Direction==RIGHT){
                    setX(getX() + 20);
                }


        }
    }

    @Override
    public boolean isIF_DIE() {
        return IF_DIE;
    }

    @Override
    public void setIF_DIE(boolean IF_DIE) {
        this.IF_DIE = IF_DIE;
    }

    public Bitmap getInvader() {
        return invader1;
    }

    public void setInvader(Bitmap invader) {
        this.invader1 = invader;
    }

    public Rect getmSrcRect() {
        return mSrcRect;
    }

    public void setmSrcRect(Rect mSrcRect) {
        this.mSrcRect = mSrcRect;
    }

    public Rect getmDestRect() {
        return mDestRect;
    }
    public void setmDestRect(Rect mDestRect) {
        this.mDestRect = mDestRect;
    }

    public int getMove_Direction() {
        return Move_Direction;
    }

    public void setMove_Direction(int move_Direction) {
        Move_Direction = move_Direction;
    }

    public int getMove_Type() {
        return Move_Type;
    }

    public void setMove_Type(int move_Type) {
        Move_Type = move_Type;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        this.Row = row;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        this.Num = num;
    }

    public void setInvader2(Bitmap invader2) {
        this.invader2 = invader2;
    }
}
