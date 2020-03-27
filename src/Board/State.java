package Board;

import Graphic.MainGraphic;
import Tiles.Tile;
import Tiles.TileTypes;
import Tiles.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class State {
    public ArrayList<Tile> tiles;
    private static State state;

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    private State(){
        tiles=new ArrayList<>();
    }

    private State(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public static State getInstance(){
        if (state==null) state = new State();
        return state;
    }
}
