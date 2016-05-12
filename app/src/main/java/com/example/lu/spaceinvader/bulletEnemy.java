package com.example.lu.spaceinvader;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by lu on 2016-03-28.
 */
public class bulletEnemy extends Container {
    private boolean IF_DIE=false;
    private float speed;
    private double direction;
    private int relativeHorizontalPosition;
    private int Move_Direction=0;
    private int TYPE;
   // private String level;
    private final int LEFT=1,UP=1;
    private final int RIGHT=2,DOWN=2;
    private final int DEFAULTTYPE=0;
    private final int HALFHOMINGTYPE=1;
    private final int SKILLHOMINGTYPE=2;
    private final int SHOTGUNTYPE=3;

    private Paint p;
    public bulletEnemy(enemy enemyFlight){
       p=new Paint();
        setSpeed(30);
        setWidth(10);
        setHeight(60);
        setTYPE(HALFHOMINGTYPE);
        p.setColor(Color.WHITE);
        setX(enemyFlight.getX());
        setY(enemyFlight.getY());


    }
    public void costomDraw(Canvas canvas) {
        super.costomDraw(canvas);
      //  Path path = new Path();
      //  path.moveTo(getX(), getY());
        //path.lineTo(getX() + getWidth(), getY());
       // path.lineTo(getX() + getWidth() / 2, getY() + getHeight());
      //  path.close();
       // canvas.drawPath(path, p);
        canvas.drawCircle(getX(), getY(), getWidth(), p);

    }

    public void bulletTypeInitial(mainHeroine flight){
        if(flight.getX()>getX()) {
            setRelativeHorizontalPosition(RIGHT);
        }
        else {
            setRelativeHorizontalPosition(LEFT);
        }


        switch(TYPE) {
            case DEFAULTTYPE:
                setDirection(Math.PI);
                break;
            case HALFHOMINGTYPE:
                setDirection(Math.toDegrees(Math.acos((flight.getY()-getY())/(Math.sqrt(Math.pow(flight.getX()-(getX()+getWidth()/2),2)
                        +Math.pow(flight.getY()-(getY()+getWidth()),2))))));
                //setDirection(Math.toDegrees(Math.atan(-(flight.getX()-getX())/(flight.getY()-getY())  )));
                break;
            default:
                break;

        }
    }
    public void move(){

            setY((float) (getY() + getSpeed() * Math.cos(Math.toRadians(getDirection()))));

       if(relativeHorizontalPosition ==LEFT) {
           setX((float) (getX() - getSpeed() * Math.sin(Math.toRadians(getDirection()))));
       }
        else {
           setX((float) (getX() + getSpeed() * Math.sin(Math.toRadians(getDirection()))));
       }



    }
    public void realTimeHoming(mainHeroine flight){

    }

    @Override
    public boolean isIF_DIE() {
        return IF_DIE;
    }

    @Override
    public void setIF_DIE(boolean IF_DIE) {
        this.IF_DIE = IF_DIE;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }

    public int getRelativeHorizontalPosition() {
        return relativeHorizontalPosition;
    }

    public void setRelativeHorizontalPosition(int relativeHorizontalPosition) {
        this.relativeHorizontalPosition = relativeHorizontalPosition;
    }


  //  public String getLevel() {
 //       return level;
 //   }

  //  public void setLevel(String level) {
  //      this.level = level;
 //   }
}
