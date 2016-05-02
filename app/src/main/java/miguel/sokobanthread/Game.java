package miguel.sokobanthread;

import android.content.Context;
import android.content.SyncAdapterType;
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
    static Tile[][] level4;
    boolean targetSteppedOn = false;
    boolean boxOnTarget = false;
    public Vector<Tile[][]> levels = new Vector<Tile[][]>();
    int currentLevel;
    int targetsAquired;
    public Game(int sw, Context context) {
        screenWidth = sw;
        tileSize = sw / 8;
        this.context = context;
        level1 = genLevel1();
        level2 = genLevel2();
        level3 = genLevel3();
        level4 = genLevel4();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        currentLevel = 0;
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
                if( (i >=1 && i<=3 && j >=1 && j <= 2)||(i>=1 && i<=3 && j ==4)||(i==4 && j >=2&& j<=4)
                        || (i ==6 && j >=1 && j<=4)
                        || (i ==5 && (j ==5 || j ==3))){
                    level2[i][j] = new Tile(tileSize);
                }
                //creating the targets RED
                else if( (i ==1 && j ==3) || (i == 6 && j ==5)){
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
                        || (i>=3 && i<=4 && j ==5) || (i==2 && j ==6)
                        || (i>=3 && i <=5 && j ==6)){
                    level3[i][j] = new Tile(tileSize);
                }
                //creating the player
                else if(i==1 && j ==5){
                    level3[i][j] = new Player(tileSize, context);
                }
                //making the targets
                else if( (i ==1 && j ==6) || (i ==5 && j ==5)){
                    level3[i][j] = new Target(tileSize);
                }
                //Making the boxes
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
    public static Tile[][] genLevel4() {
        int x, y;
        Tile[][] level4 = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = tileSize * i;
                y = tileSize * j;
                //Basic tiles
                if( ( i>=2 && i<=3 && j==1) || ( i<=2 && i>=1 && j==2)
                        ||(i>=2 && i <=4 && j==3) ||(i==6 && j==3)
                        || (i>=5 && i <=6 && j==1) || (i==5 && j==2)
                        || (i>=1 && i<=6 && j>=4 && j<=5) || (i>=1 && i<=3 && j==6)
                        || (i>=5 && i<=6 && j==6)){
                    level4[i][j] = new Tile(tileSize);
                }
                //targets
                else if( (i==1 && j==3) || (i==6 && j==2) || (i==4 && j ==6) ){
                    level4[i][j] = new Target(tileSize);
                }
                //player tile
                else if(i==1 && j==1){
                    level4[i][j] = new Player(tileSize, context);
                }
                //block
                else if( (i >=3 && i <=4 && j == 2) ||(i==5 && j==3)){
                    level4[i][j] = new Box(tileSize);
                }
                //walls
                else{
                    level4[i][j] = new Wall(tileSize);
                }
            }
        }
        return level4;
    }
    public void draw(Canvas c){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                levels.get(currentLevel)[i][j].draw(c, i*tileSize, j*tileSize);
            }
        }
    }
    public int[] findPlayer(){
        int[] player = new int[2];
        Tile[][] currLevel = levels.get(currentLevel);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(currLevel[i][j] instanceof Player){
                    player[0] = i;
                    player[1] = j;
                    break;
                }
            }
        }
        return player;
    }
    public boolean move(GameView.Directions dir, Tile[][] currentLevel) {
        // x,y position of player
        int[] pos = findPlayer();
        Tile temp = currentLevel[0][0];
        int x = pos[0], y = pos[1];
        System.out.println("x " + x + " y " + y);
        System.out.println(dir);
        //move left
        if (dir == GameView.Directions.Left) {
            if (x > 0 && (currentLevel[x-1][y].isEmpty)) {
                if(targetSteppedOn){
                    if(!(currentLevel[x-1][y] instanceof Target)){
                        targetSteppedOn = false;
                    }
                    currentLevel[x-1][y] = currentLevel[x][y];
                    currentLevel[x][y] = new Target(tileSize);
                    //targetSteppedOn = false;
                    return true;
                }
                if(currentLevel[x-1][y] instanceof Target){
                    targetSteppedOn = true;
                    temp = currentLevel[x-1][y];
                    currentLevel[x-1][y] = new Tile(tileSize);
                }
                currentLevel[x-1][y] = currentLevel[x][y];
                currentLevel[x][y] = new Tile(tileSize);
                return true;
            } else if (x >  0 && !(currentLevel[x-1][y].isEmpty)) {
                if (x-2> 0 && currentLevel[x-1][y].isMoveable && (currentLevel[x-2][y].isEmpty)){
                    if(currentLevel[x-2][y] instanceof Target){
                        targetsAquired++;
                        currentLevel[x-2][y] = currentLevel[x-1][y];
                        currentLevel[x-2][y].isMoveable = false;
                    }
                    currentLevel[x-2][y] = currentLevel[x-1][y];
                    currentLevel[x-1][y] = currentLevel[x][y];
                    if(targetSteppedOn){
                        currentLevel[x][y] = new Target(tileSize);
                        targetSteppedOn = false;
                    } else {
                        currentLevel[x][y] = new Tile(tileSize);
                    }
                    return true;
                }
            }
            return false;
        }
        //move right
        else if (dir == GameView.Directions.Right) {
            if (x < 7 && (currentLevel[x+1][y].isEmpty)) {
                if(targetSteppedOn){
                    if(!(currentLevel[x+1][y] instanceof Target)){
                        targetSteppedOn = false;
                    }
                    currentLevel[x+1][y] = currentLevel[x][y];
                    currentLevel[x][y] = new Target(tileSize);
                    //targetSteppedOn = false;
                    return true;
                }
                if(currentLevel[x+1][y] instanceof Target){
                    targetSteppedOn = true;
                    temp = currentLevel[x+1][y];
                    //currentLevel[x+1][y] = new Tile(tileSize);
                }
                currentLevel[x+1][y] = currentLevel[x][y];
                currentLevel[x][y] = new Tile(tileSize);
                return true;
            } else if (x < 7 && !(currentLevel[x+1][y].isEmpty)) {
                if (x+2> 0 && currentLevel[x+1][y].isMoveable && (currentLevel[x+2][y].isEmpty)) {
                    if(currentLevel[x+2][y] instanceof Target){
                        targetsAquired++;
                        currentLevel[x+2][y] = currentLevel[x+1][y];
                        currentLevel[x+2][y].isMoveable = false;
                    }
                    currentLevel[x+2][y] = currentLevel[x+1][y];
                    currentLevel[x+1][y] = currentLevel[x][y];
                    if(targetSteppedOn){
                        currentLevel[x][y] = new Target(tileSize);
                        targetSteppedOn = false;
                    } else {
                        currentLevel[x][y] = new Tile(tileSize);
                    }
                    return true;
                }
            }
            return false;
        }
        //move up
        else if (dir == GameView.Directions.Up) {
            if (y > 0 && (currentLevel[x][y - 1].isEmpty)) {
                if(targetSteppedOn){
                    if(!(currentLevel[x][y-1] instanceof Target)){
                        targetSteppedOn = false;
                    }
                    currentLevel[x][y-1] = currentLevel[x][y];
                    currentLevel[x][y] = new Target(tileSize);
                    //targetSteppedOn = false;
                    return true;
                }
                if(currentLevel[x][y-1] instanceof Target){
                    targetSteppedOn = true;
                    temp = currentLevel[x][y-1];
                    //currentLevel[x][y-1] = new Tile(tileSize);
                }
                currentLevel[x][y-1] = currentLevel[x][y];
                currentLevel[x][y] = new Tile(tileSize);
                return true;
            } else if (y > 0 && !(currentLevel[x][y - 1].isEmpty)) {
                if (y - 2 > 0 && currentLevel[x][y - 1].isMoveable && (currentLevel[x][y - 2].isEmpty)) {
                    if(currentLevel[x][y-2] instanceof Target){
                        targetsAquired++;
                        currentLevel[x][y - 2] = currentLevel[x][y - 1];
                        currentLevel[x][y-2].isMoveable = false;
                    }
                    currentLevel[x][y - 2] = currentLevel[x][y - 1];
                    currentLevel[x][y - 1] = currentLevel[x][y];
                    if(targetSteppedOn){
                        currentLevel[x][y] = new Target(tileSize);
                        targetSteppedOn = false;
                    } else {
                        currentLevel[x][y] = new Tile(tileSize);
                    }
                    return true;
                }
            }
            return false;
        }
        //move down
        else if (dir == GameView.Directions.Down) {
            if (y < 7 && (currentLevel[x][y + 1].isEmpty)) {
                if(targetSteppedOn){
                    if(!(currentLevel[x][y+1] instanceof Target)){
                        targetSteppedOn = false;
                    }
                    currentLevel[x][y+1] = currentLevel[x][y];
                    currentLevel[x][y] = new Target(tileSize);
                    return true;
                }
                if(currentLevel[x][y+1] instanceof Target){
                    targetSteppedOn = true;
                    temp = currentLevel[x][y+1];
                    //currentLevel[x][y+1] = new Tile(tileSize);
                }
                currentLevel[x][y+1] = currentLevel[x][y];
                currentLevel[x][y] = new Tile(tileSize);
                return true;
            } else if (y < 7 && !(currentLevel[x][y + 1].isEmpty)) {
                if (y + 2 < 7 && currentLevel[x][y + 1].isMoveable && (currentLevel[x][y + 2].isEmpty)) {
                    if(currentLevel[x][y+2] instanceof Target){
                        targetsAquired++;
                        currentLevel[x][y + 2] = currentLevel[x][y + 1];
                        currentLevel[x][y+2].isMoveable = false;

                    }
                    currentLevel[x][y + 2] = currentLevel[x][y + 1];
                    currentLevel[x][y + 1] = currentLevel[x][y];
                    if(targetSteppedOn){
                        currentLevel[x][y] = new Target(tileSize);
                        targetSteppedOn = false;
                    } else {
                        currentLevel[x][y] = new Tile(tileSize);
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    public Tile[][] getLevel(){
        return levels.get(currentLevel);
    }
    public void checkLevelUp(){
        switch (currentLevel){
            //level 1
            case 0:
                if(targetsAquired >= 4){
                    targetsAquired = 0;
                    currentLevel++;
                }
                break;
            case 1:
                if(targetsAquired >= 2){
                    targetsAquired = 0;
                    currentLevel++;
                }
                break;
            case 2:
                if(targetsAquired >= 2){
                    targetsAquired = 0;
                    currentLevel++;
                }
                break;
            case 3:
                if(targetsAquired >= 3){
                    targetsAquired  =0;
                    //gameover
                }
                break;
        }
    }
}

