package miguel.sokobanthread;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tile {
    public boolean isMoveable, isEmpty;
    private int tileWidth;
    public Tile(){
        isEmpty = true;
        isMoveable = false;
    }
    public Tile(int tileWidth){
        isMoveable = false;
        isEmpty = true;
        this.tileWidth = tileWidth;
    }

    public void draw(Canvas c, int x, int y){
        Paint p = new Paint();
        p.setColor(Color.GRAY);
        c.drawRect(x, y, x+tileWidth, y+tileWidth, p);
    }
}
