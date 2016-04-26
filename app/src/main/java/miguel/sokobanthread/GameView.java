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
    private Box b1;
    private Wall w1;
    private Target t1;
    public  int screenHeight, screenWidth, tileWidth, tileHeight;
    private boolean moveLeft,moveRight,moveUP,moveDown;
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
        b1 = new Box(tileWidth*2, tileWidth, tileWidth, tileWidth);
        w1 = new Wall(tileWidth*3,tileWidth,tileWidth,tileWidth);
        t1 = new Target(tileWidth*4,tileWidth,tileWidth, tileWidth);
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
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if((x > 0 && x < screenWidth/3) && (y > screenHeight/3 && y < 2*screenHeight/3)){
                    player.moveLeft();
                    moveLeft = true;
                    System.out.println("moving left");
                }
                if((x>2*screenWidth/3 && x<screenWidth)&&(y>screenHeight/3 && y<2*screenHeight/3)){
                    player.moveRight();
                    moveRight = true;
                    System.out.println("moving right");
                }
                if((x>screenWidth/3 && x<2*screenWidth/3)&&(y>0&&y<screenHeight/3)){
                    player.moveUp();
                    moveUP = true;
                    System.out.println("moving up");
                }
                if((x>screenWidth/3 && x<2*screenWidth/3)&&(y>2*screenHeight/3 && y<screenHeight)){
                    player.moveDown();
                    moveDown = true;
                    System.out.println("moving down");
                }
                return true;
            case MotionEvent.ACTION_UP:
                moveDown = false;
                moveLeft = false;
                moveRight =false;
                moveUP = false;
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas c){
    }

    public void draw(Canvas c) {
        c.drawColor(Color.MAGENTA);
        icon.draw(c);
        b1.draw(c);
        w1.draw(c);
        t1.draw(c);
        player.draw(c);
    }
}


