package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Canvas;

import java.util.Vector;

/**
 * Created by miguel on 4/26/2016.
 */
public class Game {
    int screenWidth;
    static int tileSize;
    static Context context;
    Tile[][] level1;
    public Game(int sw, Context context) {
        screenWidth = sw;
        tileSize = sw / 8;
        this.context = context;
        level1 = genLevel1();
    }

    public static Tile[][] genLevel1() {
        int x, y;
        Tile[][] level1 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize*i;
                y = tileSize*j;
                //Targets
                if ((i == 3 && j == 1) || (i == 1 && j == 4) || (i == 6 && j == 3) || (i == 4 && j == 6)) {
                    System.out.println("I made a target at i = " + i + " j = " + j);
                    level1[i][j] = new Target(x, y, tileSize);
                }
                //Boxes
                if ((i == 3 && j == 3) || (i == 3 && j == 4) || (i == 5 && j == 3) || (i == 4 && j == 5)) {
                    level1[i][j] = new Box(x, y, tileSize);
                }
                //Player
                if (i == 4 && j == 4) {
                    level1[i][j] = new Player(x, y, tileSize, context);
                }
                //Walls
                if ((j == 0 && (i >= 2 && i <= 4)) || (j == 1 && (i == 2 || i == 4))
                        || (j == 2 && (i == 2 || (i >= 4 && i <= 7)))
                        || (j == 3 && (i >= 0 && i <= 2 || i == 7))
                        || (j == 4 && (i == 0 || i >= 5))
                        || (j == 5 && (i <= 3 || i == 5))
                        || (j == 6 && (i == 3 || i == 5))
                        || (j == 7 && (i > 2 && i < 6))) {
                    level1[i][j] = new Wall(x, y, tileSize);
                } else {
                    level1[i][j] = new Tile(x, y, tileSize);
                }
            }
        }
        System.out.println("[3][1] target? " + (level1[3][1] instanceof Target));
        System.out.println("[1][3] target? " + (level1[1][3] instanceof Target));
        System.out.println("[3][1] tile? " + (level1[3][1] instanceof Tile));
        System.out.println("[1][3] tile? " + (level1[1][3] instanceof Tile));
        return level1;
    }
    public void draw(Canvas c){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                level1[i][j].draw(c);
            }
        }
        //System.out.println("i=3, j=1 is intance of Target" + (level1[3][1] instanceof  Target));
    }
}

