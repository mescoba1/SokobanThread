package miguel.sokobanthread;

import android.content.Context;

import java.util.Vector;

/**
 * Created by miguel on 4/26/2016.
 */
public class Game {
    int screenWidth, tileSize;
    Context context;
    //int level=0;
    //Tile[8][8] level = genLevel1();
    public Game(int sw, Context context){
        screenWidth = sw;
        tileSize = sw/8;
        this.context = context;
    }
}

/*public Tile genLevel1(){
    int x, y;
    Tile[][] level1 = new Tile[8][8];
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
            x = tileSize*i;
            y = tileSize*j;
            //Targets
            if((i==3&&j==1)||(i==1&&j==4)||(i==6&&j==3)||(i==4&&j==6)){
                level1[i][j] = new Target(x, y, tileSize, tileSize);
            }
            //Boxes
            if((i==3&&j==3)||(i==3&&j==4)||(i==5&&j==3)||(i==4&&j==5)){
                level1[i][j] = new Box(x, y, tileSize, tileSize);
            }
            //Player
            if(i==4 && j==4){
                level1[i][j] = new Player(x,y, tileSize, tileSize, context);
            }
            //Walls
            if((j==0&&(i>=2&&i<=4))||(j==1&&(i==2||i==4))
                    ||(j==2&&(i==2||(i>=4&&i<=7)))
                    ||(j==3&&(i>=0&&i<=2 || i==7))
                    ||(j==4&&(i==0||i>=5))
                    ||(j==5&&(i<=3||i==5))
                    ||(j==6&&(i==3||i==5))
                    ||(j==7&&(i>2&&i<6)))
            {
                level1[i][j] = new Wall(x,y, tileSize, tileSize);
            }
            else{
                level1[i][j] = new Tile(x, y, tileSize, tileSize);
            }
        }
    }
    return level1[8][8];
}*/

