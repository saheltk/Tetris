package Board;

import Graphic.MainGraphic;
import Tiles.Constants;
import Tiles.Tile;

public class Board {
    int[][] board ;
    int size;

    public Board(){
        size=MainGraphic.BoardSize;
        board= new int[size][18];
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < 18; j++) {
                board[i][j]=0;
            }
        }
    }

    public void write(int x, int y, int id){
        board[x][y]=id;
    }
    public boolean checkEmpty(int x, int y, int id){
        if (  board[x][y]==id ||   board[x][y]==0) return true;
        return false;
    }
}
