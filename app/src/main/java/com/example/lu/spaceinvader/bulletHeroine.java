package com.example.lu.spaceinvader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by lu on 2016-03-23.
 */
public class bulletHeroine extends Container {
    private double direction;
    private boolean IF_DIE=false;
    private int timeToLive;
    private int crashType;
    private int relativeHorizontalPosition;
    private float speed;
    private Paint p;
    private int checkDelay=6;
    private int Num=0;
    private final int CRASH_WALL=1;
    private final int CRASH_ENEMY=2;
    private final int DEFAULT=0;
public bulletHeroine(mainHeroine flight){
     p=new Paint();
     setX(flight.getX());
     setY(flight.getY());
     setSpeed(50);
     setTimeToLive(3);
     setDirection(Math.random()*20-10);
    this.setWidth(10);
    p.setColor(Color.RED);
    }

//public void bulletInit(){

 //   }
    public void costomDraw(Canvas canvas) {
        super.costomDraw(canvas);
        canvas.drawCircle(getX(), getY(), getWidth(), p);

    }


    public void move(float width,float height) {
        if (getCheckDelay() == 0) {//�����ǽ������ӵ����ڵ��ж� delay��Ϊ�˲����ӵ����ڱ߽������ظı䷽��
            if (getX() > width-80 || getX() < 80) {
                setDirection( 360-getDirection());
                setCheckDelay(5);
                setTimeToLive(getTimeToLive()-1);
            }
            if (getY() < 80 || getY() > height-160) {
                setDirection(180-getDirection());
                setCheckDelay(5);
                setTimeToLive(getTimeToLive()-1);
            }
        } else {
            setCheckDelay(getCheckDelay() - 1);

        }



        setY((float) (getY() - getSpeed() * Math.cos(Math.toRadians(getDirection()))));
        setX((float) (getX() + getSpeed() * Math.sin(Math.toRadians(getDirection()))));
           //ͨ�����Ǻ������㷨������xy���ƶ�����
    }



    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getCrashType() {
        return crashType;
    }

    public void setCrashType(int crashType) {
        this.crashType = crashType;
    }

    public int getCheckDelay() {
        return checkDelay;
    }

    public void setCheckDelay(int checkDelay) {
        this.checkDelay = checkDelay;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public boolean isIF_DIE() {
        return IF_DIE;
    }

    @Override
    public void setIF_DIE(boolean IF_DIE) {
        this.IF_DIE = IF_DIE;
    }
}
