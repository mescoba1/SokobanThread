package miguel.sokobanthread;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

//public int screenHeight, screenWidth, tileWidth;

    public  class Buttons extends Tile {
        private int tileHeight, tileWidth;
        public int buttonWidth;
        public int x, y;

        public  Buttons(int buttonWidth, int x, int y){
            this.x = x;
            this.y = y;
            //this.tileWidth = tileWidth;
            this.buttonWidth = buttonWidth;
        }
    public void draw(Canvas c){
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        c.drawRect(x, y, x+buttonWidth, y+buttonWidth,p);

        }
    }

