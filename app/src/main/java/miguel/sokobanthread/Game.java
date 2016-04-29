package miguel.sokobanthread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;

import java.util.Vector;

/**
 * Created by miguel on 4/26/2016.
 */
public class Game {
    int screenWidth;
    static int tileSize;
    static Context context;
    static Tile[][] level1;
    static Tile[][] level2;
    static Tile[][] level3;
   // static Tile[][] level4;
    public Game(int sw, Context context) {
        screenWidth = sw;
        tileSize = sw / 8;
        this.context = context;
        level1 = genLevel1();
        level2 = genLevel2();
        level3 = genLevel3();
       // level4 = genLevel4();
    }

    public static Tile[][] genLevel1() {
        int x, y;
        Tile[][] level1 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize*i;
                y = tileSize*j;
                //Basic tiles
                if ((i==3 && j ==2) || (i ==4 && j ==3) || (i ==2 && j ==4)){
                    level1[i][j] = new Tile(tileSize);
                }
                //Targets
                else if ((i == 3 && j == 1) || (i == 1 && j == 4) || (i == 6 && j == 3) || (i == 4 && j == 6)) {
                    System.out.println("I made a target at i = " + i + " j = " + j);
                    level1[i][j] = new Target(tileSize);
                }
                //Boxes
                else if ((i == 3 && j == 3) || (i == 3 && j == 4) || (i == 5 && j == 3) || (i == 4 && j == 5)) {
                    level1[i][j] = new Box(tileSize);
                }
                //Player
                else if (i == 4 && j == 4) {
                    level1[i][j] = new Player(tileSize, context);
                //Walls
                } else {
                    level1[i][j] = new Wall(tileSize);

                }
            }
        }
        return level1;
    }
    public static Tile[][] genLevel2() {
        int x, y;
        Tile[][] level2 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize * i;
                y = tileSize * j;

                //creating the basic tiles GRAY
                if( (i >=1 && i<=3 && j >=1 && j <= 3)||(i==4 && j ==2)
                        || (i ==6 && j >=1 && j<=3)
                        || (i ==5 && (j ==5 || j ==3))){
                    level2[i][j] = new Tile(tileSize);
                }
                //creating the targets RED
                else if( (i ==6 && j ==4) || (i == 6 && j ==5)){
                    level2[i][j] = new Target(tileSize);
                }
                //creating the Boxes BLUE
                else if((i == 5 && j ==2) || (i ==5 && j ==4)){
                    level2[i][j] = new Box(tileSize);
                }
                //creating the player DUDE
                else if(i ==5 && j ==1){
                    level2[i][j] = new Player(tileSize, context);
                }
                //setting everything else as a wall BLACK
                else{
                    level2[i][j] = new Wall(tileSize);
                }
            }
        }

        return level2;
    }
    public static Tile[][] genLevel3() {
        int x, y;
        Tile[][] level3 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize * i;
                y = tileSize * j;

                //creating the basic tiles GRAY
                if( (i >=2 && i<=6 && j==1) || (i>=4 && i<=6 && j ==2)
                        || (i==2 && j>=2 && j<=4 )
                        || (i==3 && j == 3) || (i >=5 && i<=6 && j ==3)
                        || (i>=3 && i<=5 && j ==5) || (i==2 && j ==6)
                        || (i>=4 && i <=5 && j ==6)){
                    level3[i][j] = new Tile(tileSize);
                }
                //creating the player
                else if(i==1 && j ==5){
                    level3[i][j] = new Player(tileSize, context);
                }
                //making the targets
                else if( (i ==1 && j ==6) || (i ==3 && j ==6)){
                    level3[i][j] = new Target(tileSize);
                }
                else if( (i == 2 && j == 5) || (i ==3 && j == 2)){
                    level3[i][j] = new Box(tileSize);
                }
                //making the walls
                else{
                    level3[i][j] = new Wall(tileSize);
                }
            }
        }
    return level3;
    }
   /* public static Tile[][] genLevel4() {
        int x, y;
        Tile[][] level4 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize * i;
                y = tileSize * j;
                //Basic tiles
                if( (i>=2 && i<=3 && j==1) || (i>=1 && i<=2 && j==2)
                        ||(i>=3 && i <=6 && j==3) || (i>=5 && i <=6 && j==1)
                        ||(i==6 && j==2)){
                    level4[i][j] = new Tile(tileSize);
                }
                //targets
                if( (i==2 && j==1) || (i==1 && j==3) || (i==2 && j==3)){
                    level4[i][j] = new Target(tileSize);
                }
                //player tile
                if(i==1 && j==1){
                    level4[i][j] = new Player(tileSize, context);
                }
                //walls
                else{
                    level4[i][j] = new Wall(tileSize);
                }
            }
        }
        return level4;
    } */
    public void draw(Canvas c){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                level3[i][j].draw(c, i*tileSize, j*tileSize);
            }
        }
    }
    public static int[] findPlayer(){
        int[] player = new int[2];
        Tile[][] currentLevel = level3;
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
    public boolean move(GameView.Directions dir, Tile[][] currentLevel){
        // x,y position of player
        int[] pos = findPlayer();
        int x = pos[0], y = pos[1];
        System.out.println("x: " +pos[0]+ "y: " + pos[1]);
        System.out.println("Direction: " + dir );
        if(dir == GameView.Directions.Left){
            //cannot move
            if( pos[0]==0){
                return false;
            }
        }
        else if(dir == GameView.Directions.Right){
            if(pos[0]==7){
                return false;
            }
        }
        else if(dir == GameView.Directions.Up){
            if(pos[1]==0){
                return false;
            }
            if(y > 0 && !(currentLevel[x][y-1] instanceof Wall)){
                if(currentLevel[x][y-1] instanceof Box){
                    System.out.println("Block in the way");
                } else {
                    currentLevel[x][y-1] = currentLevel[x][y];
                    currentLevel[x][y] = new Tile(tileSize);
                    System.out.println("moving upp");
                }
            }
        }
        else if (dir == GameView.Directions.Down){
            if(pos[1]==7){
                return false;
            }
            if(y < 7 && !(currentLevel[x][y+1] instanceof Wall)){
                if(currentLevel[x][y+1] instanceof Box){
                    System.out.println("Block in the way");
                } else {
                    currentLevel[x][y+1] = currentLevel[x][y];
                    currentLevel[x][y] = new Tile(tileSize);
                    System.out.println("moving down");
                }
            }
        }
        return false;
    }
    public Tile[][] getLevel(){
        return level3;
    }
}

