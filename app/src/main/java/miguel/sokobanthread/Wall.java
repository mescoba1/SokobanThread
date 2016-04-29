package miguel.sokobanthread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Wall extends Tile {
    public final boolean moveable;
    private int tileWidth;
    public Wall(){
        moveable = false;
    }
    public Wall(int tileWidth){
        moveable = false;
        this.tileWidth = tileWidth;
    }

    public void draw(Canvas c, int x, int y){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        c.drawRect(x, y, x+tileWidth, y+tileWidth, p);
    }
}