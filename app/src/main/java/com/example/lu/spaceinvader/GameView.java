package com.example.lu.spaceinvader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by lu on 2016-03-23.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

   // public GameView(Context context) {
    //    super(context);
    //    root=new Container();
   //     getHolder().addCallback(this);
  //  }
   private Container root;
    public GameView(Context context, AttributeSet attrs){
        super(context);
        root=new Container();
        getHolder().addCallback(this);//用于回调

    }

    public void draw(){
        Canvas canvas=getHolder().lockCanvas();//锁定画布
        if(canvas!=null){
            canvas.drawColor(Color.BLACK);
            root.draw(canvas);//调用Container的方法
            getHolder().unlockCanvasAndPost(canvas);//街锁画布
        }
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
                draw();
    }

    public Container getRoot(){
        return root;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
