package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Player extends Tile {
    public final boolean moveable;
    private int tileWidth, tileHeight;
    Bitmap player;
    public Player(int tileWidth, Context context){
        moveable = true;
        this.tileWidth = tileWidth;
        player = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    public void draw(Canvas c, int x, int y){
        Rect dst = new Rect();
        dst.set(x, y, x + tileWidth, y + tileWidth);
        c.drawBitmap(player, null, dst, null);
    }
}
