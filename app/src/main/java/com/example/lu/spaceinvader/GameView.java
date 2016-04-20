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
   private Container root;
   // public GameView(Context context) {
    //    super(context);
    //    root=new Container();
   //     getHolder().addCallback(this);
  //  }

    public GameView(Context context, AttributeSet attrs){
        super(context);
        root=new Container();
        getHolder().addCallback(this);

    }

    public void draw(){
        Canvas canvas=getHolder().lockCanvas();
        if(canvas!=null){
            canvas.drawColor(Color.BLACK);
            root.draw(canvas);
            getHolder().unlockCanvasAndPost(canvas);
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
