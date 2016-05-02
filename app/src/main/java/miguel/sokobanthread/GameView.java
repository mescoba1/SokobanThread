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
    public int screenHeight, screenWidth, tileWidth, buttonWidth;
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
        buttonWidth = 3*tileWidth/2;
        /*initial state
         ...
          launch animator thread */

        //down button
        b1= new Buttons(buttonWidth, tileWidth*3 +tileWidth/3, 2*screenHeight/3 +2*tileWidth);
        //up button
        b2= new Buttons(buttonWidth, tileWidth*3 +tileWidth/3, 2*screenHeight/3 );
        //right button
        b3= new Buttons(buttonWidth, tileWidth*6, 2*screenHeight/3 +tileWidth);
        //left button
        b4= new Buttons(buttonWidth, tileWidth/2, 2*screenHeight/3 +tileWidth);

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

                //MOVING LEFT
                if(x >= b4.x && x <=b4.x +buttonWidth &&  y>=b4.y && y<=b4.y+buttonWidth){
                    dir = Directions.Left;
                }
                //MOVING RIGHT
                if(x >= b3.x && x <=b3.x +buttonWidth &&  y>=b3.y && y<=b4.y+buttonWidth){
                    dir = Directions.Right;
                }
                //MOVING UP
                if(x >= b2.x && x <=b2.x +buttonWidth &&  y>=b2.y && y<=b2.y+buttonWidth){
                    dir = Directions.Up;
                }
                //MOVING DOWN
                if(x >= b1.x && x <=b1.x +buttonWidth &&  y>=b1.y && y<=b1.y+buttonWidth){
                    dir = Directions.Down;
                }
                movement = game.move(dir, game.getLevel());
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


