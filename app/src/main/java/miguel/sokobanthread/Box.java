package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Box extends Tile {
    public int x, y;
    public final boolean moveable;
    private int tileWidth, tileHeight;
    public Box(int x, int y, int tileWidth){
        moveable = true;
        this.tileWidth = tileWidth;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        c.drawRect(x, y, x + tileWidth, y + tileWidth, p);
    }
}