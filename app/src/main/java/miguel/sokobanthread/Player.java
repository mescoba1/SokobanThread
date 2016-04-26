package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Player extends Tile {
    public int x, y;
    public final boolean moveable;
    private int tileWidth, tileHeight;
    Bitmap player;
    public Player(int x, int y, int tileWidth, int tileHeight, Context context){
        moveable = true;
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.x = x;
        this.y = y;
        player = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    public void draw(Canvas c){
        Rect dst = new Rect();
        dst.set(x, y, x + tileWidth, y + tileHeight);
        c.drawBitmap(player, null, dst, null);
    }
}
