package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

public class GameView extends SurfaceView
        implements  SurfaceHolder.Callback {
    public Bitmap mybitmap;
    Game game;
    public int screenHeight, screenWidth, tileWidth;
    public Buttons b1, b2, b3, b4;
    public boolean movement = false;
    public enum Directions{
        Up,Down,Left,Right
    }
    public Directions dir;
    public GameView (Context context) {
        super(context) ;
        getHolder().addCallback(this);
        setFocusable(true);
        //initialize game state variables
        Bitmap mybitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }
    GameThread gt;

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        screenWidth = getWidth();
        screenHeight = getHeight();
        tileWidth = screenWidth/8;
        /*initial state
         ...
          launch animator thread */

        //down button
        b1= new Buttons(tileWidth*3/2,tileWidth*3, tileWidth/3 +tileWidth*10);
        //up button
        b2= new Buttons(tileWidth*3/2, tileWidth*3, tileWidth*8);
        //right button
        b3= new Buttons(tileWidth*3/2, tileWidth*6, tileWidth*9);
        //left button
        b4= new Buttons(tileWidth*3/2, 0, tileWidth*9);

        gt = new GameThread(this);
        game = new Game(screenWidth, getContext());
        gt.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        //respond to surface changes
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void surfaceDestroyer(SurfaceHolder holder){
        //stops thread by interrupting it
        //checks for interrupt flag
        gt.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:


                if((x > 0 && x < screenWidth/3) && (y > screenHeight/3 && y < 2*screenHeight/3)){
              //  if((x > tileWidth*3  && x < tileWidth*3+tileWidth) && (y > tileWidth/3 +tileWidth*10 && y < tileWidth/3 +tileWidth*10 +tileWidth)){

                    dir = Directions.Left;
                   // System.out.println(Player.movable);
                    System.out.println("moving left");
                }
                if((x>2*screenWidth/3 && x<screenWidth)&&(y>screenHeight/3 && y<2*screenHeight/3)){
                    dir = Directions.Right;
                    System.out.println("moving right");
                }
                if((x>screenWidth/3 && x<2*screenWidth/3)&&(y>0&&y<screenHeight/3)){
                    dir = Directions.Up;
                    System.out.println("moving up");
                }
                if((x>screenWidth/3 && x<2*screenWidth/3)&&(y>2*screenHeight/3 && y<screenHeight)){
                    dir = Directions.Down;
                    System.out.println("moving down");
                }
                movement = game.move(dir, game.getLevel());
                System.out.println(movement);
                System.out.println("targets " + game.targetsAquired);
                game.checkLevelUp();
                return true;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas c){
    }
    public void draw(Canvas c, int x, int y){

    }

    public void draw(Canvas c) {
       c.drawColor(Color.GRAY);
        game.draw(c);
        b1.draw(c);
        b2.draw(c);
        b3.draw(c);
        b4.draw(c);

    }
}


