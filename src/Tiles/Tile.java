package Tiles;

import Board.Spots;
import Graphic.MainGraphic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Tile {
   public TileTypes type;
   //spot down and left
   public Vector2D position;
   public Color color;
   static Random random;
   public int Spin=1;
   public ArrayList<Spots> spots;
   public int ID;
   static int numID=0;


    public void addSpin(){
        Spin++;
        if (Spin==5) Spin=1;
        setSituation(Spin);
    }

    void setSituation(int spin){
        spots=new ArrayList<>();

        Spin=spin;
        int mainX= (position.getX()-60)/30;
        int mainY= (position.getX()-60)/30;
        Spots A= new Spots(mainX,mainY,ID,color);
        spots.add(A);

        switch (type){
            case Log:
                if (spin%2==1){
                    spots.add(new Spots(mainX,mainY-1,ID,color));
                    spots.add(new Spots(mainX,mainY-2,ID,color));
                    spots.add(new Spots(mainX,mainY-3,ID,color));
                }
                else {
                    spots.removeAll(spots);
                    spots.add(A);
                    spots.add(new Spots(mainX+1,mainY,ID,color));
                    spots.add(new Spots(mainX+2,mainY,ID,color));
                    spots.add(new Spots(mainX+3,mainY,ID,color));
                }
                break;
            case Window:
                spots.add(new Spots(mainX,mainY-1,ID,color));
                spots.add(new Spots(mainX+1,mainY,ID,color));
                spots.add(new Spots(mainX+1,mainY-1,ID,color));
                break;
            case LeftLeg:
                if (spin==1){
                    spots.add(new Spots(mainX-1,mainY,ID,color));
                    spots.add(new Spots(mainX,mainY-1,ID,color));
                    spots.add(new Spots(mainX,mainY-2,ID,color));
                }
                else {
                    spots.removeAll(spots);
                    spots.add(A);
                    if (spin==2){
                        spots.add(new Spots(mainX-1,mainY,ID,color));
                        spots.add(new Spots(mainX-1,mainY-1,ID,color));
                        spots.add(new Spots(mainX+1,mainY,ID,color));
                    }
                    if (spin==3)
                    spots.add(new Spots(mainX+1,mainY,ID,color));
                    spots.add(new Spots(mainX+2,mainY,ID,color));
                    spots.add(new Spots(mainX+3,mainY,ID,color));
                }



        }

    }

    public Tile(TileTypes type, Vector2D position, Color color){
        numID++;
        ID=numID;
        this.type=type;
        this.position=position;
        this.color=color;
        random= new Random(System.nanoTime());
        Spin=1;
        setSituation(1);
    }

    public static Tile createTile(){
        random= new Random(System.nanoTime());
        int x = MainGraphic.BoardSize/2;
        x=30*x+60;
        int y= Constants.startPoint;
        TileTypes type=null;
        int typeint=random.nextInt(8);
        switch (typeint){
            case 0:type=TileTypes.Log;
            break;
            case 1:type=TileTypes.LeftDuck;
                break;
            case 2:type=TileTypes.LeftLeg;
                break;
            case 3:type=TileTypes.RightDuck;
                break;
            case 4:type=TileTypes.RightLeg;
                break;
            case 5:type=TileTypes.Mountain;
                break;
            case 6:type=TileTypes.Mountain;
                break;
            case 7:type=TileTypes.Window;
                break;
        }
        Color color=null;
        int colorint=random.nextInt(5);
        switch (typeint){
            case 0:color=Color.blue;
                break;
            case 1:color=Color.magenta;
                break;
            case 2:color=Color.RED;
                break;
            case 3:color=Color.YELLOW;
                break;
            case 4:color=Color.GREEN;
                break;

        }
        return new Tile(type,new Vector2D(x,y),color);

    }

}
