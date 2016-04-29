package miguel.sokobanthread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Target extends Tile {
    public final boolean moveable;
    private int tileWidth;
    public Target(int tileWidth){
        moveable = false;
        this.tileWidth = tileWidth;
    }

    public void draw(Canvas c, int x, int y){
        Paint p = new Paint();
        p.setColor(Color.RED);
        c.drawRect(x, y, x+tileWidth, y+tileWidth, p);
    }
}