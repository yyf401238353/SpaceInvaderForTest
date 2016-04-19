package com.example.lu.spaceinvader;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lu on 2016-03-23.
 */


public class Container {
          private List<Container> children;
          private float x=0 ,y=0,width=0,height=0 ;
          private boolean IF_DIE=false;

    public Container(){

              children=new ArrayList<Container>();
           }

    //将List中所有的View进行绘制
    public void draw(Canvas canvas){
      canvas.save();
      //canvas.translate(getX(),getY());
        costomDraw(canvas);
        for (Container child: children){
            child.draw(canvas);
        }
        canvas.restore();
    }

    public void costomDraw(Canvas canvas){

    }
    public void addChild(Container child){
    children.add(child);

    }
    public  void removeChild(Container child){
        children.remove(child);

    }
    public void clearChildren(){
        children.clear();
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isIF_DIE() {
        return IF_DIE;
    }

    public void setIF_DIE(boolean IF_DIE) {
        this.IF_DIE = IF_DIE;
    }
}

