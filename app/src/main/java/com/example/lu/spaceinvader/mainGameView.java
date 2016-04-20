package com.example.lu.spaceinvader;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lu on 2016-03-23.
 */
public class mainGameView extends GameView implements Runnable {
    private boolean IF_OVER=false;
    private int enemyArray=1;
    private final int SQUARE=1;
    private final int RANDOM_ARRAY=0;
    private final int LEFT=0,RIGHT=1;
    private List<PointF> allpoint;
    private Thread animation;
    private int row=5;
    private Text Score;
    int[] rowDirection=new int[row];
    private Bitmap enemyIcon;
    private Bitmap enemyIcon1;
    private Bitmap heroineIcon;
    private int counter=0,timer=0;
    private List<bulletHeroine> bulletHit=new ArrayList<>(),backupOfHeroineBullet =new ArrayList<>();
    private List<enemy> enemies=new ArrayList<>(),backupOfEnemy=new ArrayList<>();
    private List<bulletEnemy> bulletComing=new ArrayList<>(),backupOfEnemyBullet = new ArrayList<>();
    private mainHeroine fly;
    private float WIDTH=0,HEIGHT=0;
    private boolean IF_DIE=false;
    //�Ƿ񱻴���
    static boolean isPoint;
    //������xyλ��
    static float Point_x, Point_y;
    private boolean isRun=false;
    public mainGameView(Context context,AttributeSet attrs) {
        super(context,attrs);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
         WIDTH = wm.getDefaultDisplay().getWidth();
         HEIGHT = wm.getDefaultDisplay().getHeight();
        enemyIcon= ((BitmapDrawable) this.getResources().getDrawable(R.drawable.space_invader1))
        .getBitmap();
        enemyIcon1= ((BitmapDrawable) this.getResources().getDrawable(R.drawable.space_invader3))
                .getBitmap();
        heroineIcon=((BitmapDrawable) this.getResources().getDrawable(R.drawable.space_invader2))
                .getBitmap();

        start();


    }


    //����һ�����ڻ�ͼ���߳�
    public void start(){
        addFlight();
        animation = new Thread(this);
        isRun=true;
        animation.start();
    }
    public void addFlight()
    {
        mainHeroine flight = new mainHeroine(40,50,heroineIcon);
        getRoot().addChild(flight);
        fly=flight;

    }


    public void destroyBullet(){
        for(bulletHeroine bulletDie: bulletHit) {

            if(bulletDie.getY()<0){
                bulletDie.setIF_DIE(true);
            }
            if(bulletDie.getTimeToLive()<0){
                bulletDie.setIF_DIE(true);
            }
           // for(enemy enemyFlight:enemies) {
          //      if (bulletDie.getX() > enemyFlight.getX() &&
           //             bulletDie.getX() < enemyFlight.getX() + enemyFlight.getWidth() &&
           //             bulletDie.getY() > enemyFlight.getY() &&
            //            bulletDie.getY() < enemyFlight.getY() + enemyFlight.getHeight()
            //            ) {
             //       bulletDie.setIF_DIE(true);
            //    }
         //   }
            if (!bulletDie.isIF_DIE()){
                backupOfHeroineBullet.add(bulletDie);

            }
            else {
                getRoot().removeChild(bulletDie);
            }


        }
        bulletHit.clear();
        for (bulletHeroine bulletLive: backupOfHeroineBullet) {
            bulletHit.add(bulletLive);
        }
        backupOfHeroineBullet.clear();

        }
    public void addScoreText(){
        Score=new Text(700,70,"Score:",0,(int)WIDTH,(int)HEIGHT);
        getRoot().addChild(Score);
    }
    public void addenemy(){
        switch (enemyArray){
            case RANDOM_ARRAY:
             enemy enemyFlight = new enemy(52, 41, (float) Math.random() * WIDTH, 10, enemyIcon,enemyIcon1);
             getRoot().addChild(enemyFlight);
             enemies.add(enemyFlight);
             break;
            case SQUARE:
            for(row=1;row<6;row++) {


                for (int i = 1; i < 9; i++) {
                    enemy enemyFly = new enemy(52, 41, WIDTH / 4 + (i-1) * 70, 100 + row * 50, enemyIcon,enemyIcon1);
                    enemyFly.setRow(row);
                    enemyFly.setNum(i);
                    getRoot().addChild(enemyFly);
                    enemies.add(enemyFly);


                }
            }
                row--;
             break;
            default:
                break;
             }

        }

    public void enemyArrayDeal(){

                int tempRow=0;

        for (enemy enemyFlight:enemies) {
            if (enemyFlight.getRow() != tempRow) {

                tempRow = enemyFlight.getRow();

                if (enemyFlight.getX() < 20 && enemyFlight.getMove_Direction() == LEFT) {
                    rowDirection[tempRow - 1] = RIGHT;
                    enemyFlight.setMove_Direction(rowDirection[tempRow - 1]);
                }else {

                }

            } else {

                    if (enemyFlight.getX() > WIDTH - 20&&enemyFlight.getMove_Direction()==RIGHT) {
                        rowDirection[tempRow - 1] = LEFT;
                    }

            }
        }
        for (enemy enemyFlight:enemies) {
            enemyFlight.setMove_Direction(rowDirection[enemyFlight.getRow()-1]);
            enemyFlight.move();
        }

                    //max = enemyFlight.getX();
                    //min = enemyFlight.getX();
                //    if(!IF_CHANGED){
                  //  rowDirection=enemyFlight.getMove_Direction();
               //     }
                 //   enemyFlight.move();
              //  }else{
                //    if(enemyFlight.getX()<20) {
                //       rowDirection=RIGHT;
               //     }else if(enemyFlight.getX()>WIDTH-20) {
                //        rowDirection = LEFT;
                //    }
               //     enemyFlight.move();
              //      IF_CHANGED=true;
             //   }


         //   }
          //  else{
          //         enemyFlight.setMove_Direction(rowDirection);
          //         enemyFlight.move();
          //  }




    }

    public void addHeroineBullet(mainHeroine flight)
    {
        bulletHeroine bulletOfHeroine = new bulletHeroine(flight);
        bulletOfHeroine.setNum(counter);
        getRoot().addChild(bulletOfHeroine);
        bulletHit.add(bulletOfHeroine);
        counter++;

    }
    public boolean onTouchEvent(MotionEvent event) {
        Point_x =  event.getRawX();
        Point_y =  event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isPoint = true;
                break;
            case MotionEvent.ACTION_UP:
                isPoint = false;
                break;
            default:
                break;
        }
        return true;
    }


    public void addEnemyBullet(){
        for (enemy enemyFlight:enemies) {
            bulletEnemy bulletOfEnemy = new bulletEnemy(enemyFlight);
            bulletOfEnemy.bulletTypeInitial(fly);
            getRoot().addChild(bulletOfEnemy);
            bulletComing.add(bulletOfEnemy);
        }
    }
   public void bulletDeal() {
        for (bulletHeroine bullet : bulletHit) {
            bullet.move(WIDTH,HEIGHT);


        }
    }
    public void enmeyDeal(){
       for(enemy enemyFlight : enemies){
           enemyFlight.move();
       }
    }
    public boolean bulletHitBox(float x,float y,Rect rect,float radius){
        if((x>rect.left-radius&&x<rect.right+radius&&y>rect.top&&y<rect.bottom)||
                (y>rect.top-radius&&y<rect.bottom+radius&&x<rect.right&&x>rect.left)) {

               return true;
        }
            if(x<rect.left&&y<rect.top) {
                if (Math.sqrt(Math.pow((double) (x - rect.left), 2)
                       + Math.pow((double) (y - rect.top), 2)) <= radius)
                return true;
            }

            if(x>rect.right&&y<rect.top) {
                if (Math.sqrt(Math.pow((double) (x - rect.right), 2)
                        + Math.pow((double) (y - rect.top), 2)) <= radius)
                    return true;
            }
            if(x<rect.left&&y>rect.bottom) {
                if (Math.sqrt(Math.pow((double) (x - rect.left), 2)
                        + Math.pow((double) (y - rect.bottom), 2)) <= radius)
                    return true;
            }
            if(x>rect.right&&y>rect.bottom) {
                if (Math.sqrt(Math.pow((double) (x - rect.right), 2)
                        + Math.pow((double) (y - rect.bottom), 2)) <= radius)
                    return true;
            }

            return false;

    }
    public void enemyDestroy() {
        for (enemy enemyFlight : enemies) {
            for (bulletHeroine bulletOfHeroine : bulletHit) {
                Rect rect=new Rect((int)enemyFlight.getX(),(int)enemyFlight.getY(),(int)(enemyFlight.getX()+enemyFlight.getWidth()),(int)(enemyFlight.getY()+enemyFlight.getHeight()));
               // if (bulletOfHeroine.getX()>enemyFlight.getX()&&bulletOfHeroine.getX()<enemyFlight.getX()+enemyFlight.getWidth()
                    //    &&bulletOfHeroine.getY()>enemyFlight.getY()&&bulletOfHeroine.getY()<enemyFlight.getY()+enemyFlight.getHeight()){
                     if(bulletHitBox(bulletOfHeroine.getX(),bulletOfHeroine.getY(),rect,bulletOfHeroine.getWidth())) {
                    enemyFlight.setIF_DIE(true);
                    bulletOfHeroine.setIF_DIE(true);

                }
            }
            if (enemyFlight.getY() > HEIGHT) {

                enemyFlight.setIF_DIE(true);


            }
            if (enemyFlight.isIF_DIE()) {
                Score.setData_saved(Score.getData_saved()+100);
                getRoot().removeChild(enemyFlight);
            } else {
                backupOfEnemy.add(enemyFlight);
            }
        }
                enemies.clear();
            for (enemy enemyLive : backupOfEnemy) {
                enemies.add(enemyLive);
            }


        backupOfEnemy.clear();
    }

    public void enemyBulletMove(){
        for(bulletEnemy bulletOfEnemy:bulletComing){
            bulletOfEnemy.move();
        }
    }
    public void enemyBulletDeal(){
        for (bulletEnemy bulletOfEnemy:bulletComing){
            if (bulletOfEnemy.getY()>HEIGHT||bulletOfEnemy.getY()<0){
                bulletOfEnemy.setIF_DIE(true);
            }
           // if(Math.sqrt(Math.pow(fly.getX()-(bulletOfEnemy.getX()+bulletOfEnemy.getWidth()/2),2)
            //        +Math.pow(fly.getY()-(bulletOfEnemy.getY()+bulletOfEnemy.getWidth()),2))<=fly.getWidth()){
            if (bulletOfEnemy.getX()>fly.getmDestRect().left&&bulletOfEnemy.getX()<fly.getmDestRect().right
                    &&bulletOfEnemy.getY()>fly.getmDestRect().top&&bulletOfEnemy.getY()<fly.getmDestRect().bottom)
            {
                bulletOfEnemy.setIF_DIE(true);
                setIF_OVER(true);
            }
            if(bulletOfEnemy.getX()<0||bulletOfEnemy.getX()>WIDTH){
                bulletOfEnemy.setIF_DIE(true);
            }

            if (bulletOfEnemy.isIF_DIE()){
                getRoot().removeChild(bulletOfEnemy);
            }
            else{
                backupOfEnemyBullet.add(bulletOfEnemy);
            }
        }
        bulletComing.clear();
        for(bulletEnemy bulletLive:backupOfEnemyBullet){
            bulletComing.add(bulletLive);
        }
        backupOfEnemyBullet.clear();
    }

   // public void crashThings(float width,float height){
   //     for(bulletHeroine bulletOfHeroine:bulletHit){

   //     }
   // }
    @Override
    //��ͼ�߳�
    public void run() {
        if (enemyArray==SQUARE){
            addenemy();

        }
        addScoreText();
        while (isRun){

            fly.move(Point_x, Point_y, isPoint);
            if(timer%20==0){
                addHeroineBullet(fly);
            }

            if(timer%10==0){


                if(enemyArray==RANDOM_ARRAY) {

                    addenemy();
                }
                if(timer%30==0) {
                    addEnemyBullet();

                }
            }

            if(enemyArray==SQUARE){
                enemyArrayDeal();
            }else{
                enmeyDeal();
            }

            bulletDeal();
            destroyBullet();


            enemyBulletMove();
            enemyBulletDeal();
            enemyDestroy();
            draw();
            timer++;
           if(IF_OVER){
              // Toast.makeText(getContext(),"游戏结束！",Toast.LENGTH_SHORT).show();
               getRoot().clearChildren();
               bulletHit.clear();
               bulletComing.clear();
               enemies.clear();
               addFlight();
               setIF_OVER(false);
               rowDirection=new int[row];
               addScoreText();
               if(enemyArray==SQUARE){
                   addenemy();
               }
               // getContext().dialog();

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        

    }

    public boolean isIF_OVER() {
        return IF_OVER;
    }

    public void setIF_OVER(boolean IF_OVER) {
        this.IF_OVER = IF_OVER;
    }
}
