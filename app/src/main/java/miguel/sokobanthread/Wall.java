package miguel.sokobanthread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Wall extends Tile {
    public final boolean isMoveable, isEmpty;
    private int tileWidth;
    public Wall(int tileWidth){
        super(tileWidth);
        super.isEmpty = false;
        isMoveable = false;
        isEmpty = false;
        this.tileWidth = tileWidth;
    }

    public void draw(Canvas c, int x, int y){
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        c.drawRect(x, y, x+tileWidth, y+tileWidth, p);
    }
}