package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Box extends Tile {
    public final boolean moveable;
    private int tileWidth, tileHeight;
    public Box(int tileWidth){
        moveable = true;
        this.tileWidth = tileWidth;
    }

    public void draw(Canvas c, int x, int y){
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        c.drawRect(x, y, x + tileWidth, y + tileWidth, p);
    }
}