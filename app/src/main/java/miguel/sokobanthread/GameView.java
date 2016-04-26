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

public class GameView extends SurfaceView
        implements  SurfaceHolder.Callback {
    public Bitmap mybitmap;
    private Tile icon;
    private Player player;
    public  int screenHeight, screenWidth, tileWidth, tileHeight;
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
        tileHeight = screenHeight/8;
        /*initial state
         ...
          launch animator thread */
        icon = new Tile(0, 0, tileWidth, tileWidth);
        player = new Player(tileWidth, tileWidth, tileWidth, tileWidth, getContext());
        gt = new GameThread(this);
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
        //update game state by responding to event
        // touch up-down-move
        return true;
    }

    @Override
    protected void onDraw(Canvas c){
    }

    public void draw(Canvas c) {
        c.drawColor(Color.MAGENTA);
        icon.draw(c);
        player.draw(c);
    }
}


