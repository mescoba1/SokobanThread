package miguel.sokobanthread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tile {
    public int x, y;
    public boolean moveable;
    private int tileWidth;
    public Tile(){

    }
    public Tile(int x, int y, int tileWidth){
        moveable = false;
        this.tileWidth = tileWidth;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        c.drawRect(x, y, x+tileWidth, y+tileWidth, p);
    }
}
