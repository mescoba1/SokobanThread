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
    static Tile[][] level1;
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
                //Walls
                if ((j == 0 && (i >= 2 && i <= 4)) || (j == 1 && (i == 2 || i == 4))
                        || (j == 2 && (i == 2 || (i >= 4 && i <= 7)))
                        || (j == 3 && (i >= 0 && i <= 2 || i == 7))
                        || (j == 4 && (i == 0 || i >= 5))
                        || (j == 5 && (i <= 3 || i == 5))
                        || (j == 6 && (i == 3 || i == 5))
                        || (j == 7 && (i > 2 && i < 6))) {
                    level1[i][j] = new Wall(x, y, tileSize);
                }
                //Targets
                else if ((i == 3 && j == 1) || (i == 1 && j == 4) || (i == 6 && j == 3) || (i == 4 && j == 6)) {
                    System.out.println("I made a target at i = " + i + " j = " + j);
                    level1[i][j] = new Target(x, y, tileSize);
                }
                //Boxes
                else if ((i == 3 && j == 3) || (i == 3 && j == 4) || (i == 5 && j == 3) || (i == 4 && j == 5)) {
                    level1[i][j] = new Box(x, y, tileSize);
                }
                //Player
                else if (i == 4 && j == 4) {
                    level1[i][j] = new Player(x, y, tileSize, context);
                } else {
                    level1[i][j] = new Tile(x, y, tileSize);
                }
            }
        }
        return level1;
    }
    public void draw(Canvas c){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                level1[i][j].draw(c);
            }
        }
    }
    public static int[] findPlayer(){
        int[] player = new int[2];
        Tile[][] currentLevel = level1;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(currentLevel[i][j] instanceof Player){
                    player[0] = i;
                    player[1] = j;
                    break;
                }
            }
        }
        return player;
    }
    public boolean move(){
        return false;
    }
}

