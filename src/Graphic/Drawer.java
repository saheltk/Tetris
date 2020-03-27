package Graphic;

import Board.Spots;
import Board.State;
import Tiles.Tile;

import java.awt.*;

public class Drawer {
    Graphics2D graphics2D;
public Drawer(){}
    public Drawer(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public void drawGameState(State state){
        for ( Tile tile : state.getTiles()){
            fillTile(tile,tile.Spin);
        }
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    private void fillTile(Tile tile,int spinCase){
        for (Spots s: tile.spots)
        MainGraphic.board[s.X][s.Y].setForeground(s.color);
    }
}