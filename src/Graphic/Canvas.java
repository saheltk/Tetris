package Graphic;

import Board.Board;
import Board.Spots;
import Board.State;
import Tiles.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Canvas  extends JComponent {
private Drawer drawer;
private State state;
static boolean newToCome = true;
static Tile movingTile=null;
static Board board;

    Canvas(){
        board=MainGraphic.boardGame;
        addKeyListener(new Keyboard());
        state=State.getInstance();
        Timer  timer= new Timer();
        TimerTask timerTask= new update();
        timer.scheduleAtFixedRate(timerTask,1000, Constants.tickTime);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics= (Graphics2D) g;
        if (drawer==null) drawer= new Drawer(graphics);
        requestFocus();
        drawer.setGraphics2D(graphics);
        drawer.drawGameState(state);
    }
    void paint (){
        if (drawer==null) drawer= new Drawer();
        requestFocus();
        drawer.drawGameState(state);
    }


    public static void Moving(Moves moveType){
        if (hit(movingTile,moveType))return;
        switch (moveType){
            case Left:
                movingTile.position.addX(new Vector2D(-30,0));
                break;
            case Right:
                movingTile.position.addX(new Vector2D(30,0));
                break;
            case Spin:
                movingTile.addSpin();
                break;
        }
    }


    static boolean hit(Tile tile, Moves move){
        if ( movingTile.position.getY()==610)return true;
        switch (move){
            case Left:
                for (Spots s : tile.spots){
                    if (!board.checkEmpty(s.X-1,s.Y,tile.ID)) return true;
                }
                break;
            case Right:
                for (Spots s : tile.spots){
                    if (!board.checkEmpty(s.X+1,s.Y,tile.ID)) return true;
                }
                break;
        }
        return false;
    }



    private class update extends TimerTask {
        Random random = new Random(System.nanoTime());

        void updateGame(){
            if (newToCome){
                this.newComing();
            }
            else {
                if (!hit(movingTile, Moves.Down) || movingTile.position.getY()==610 ){
                    newToCome=true;
                }
            }

        }

        void newComing(){
            MainGraphic.addScore(1);
            movingTile=Tile.createTile();
            state.tiles.add(new Tile(movingTile.type,new Vector2D(movingTile.position.getX(),movingTile.position.getY())
                    ,movingTile.color));
            newToCome=false;
        }

        @Override
        public void run() {
            updateGame();
            //paint
          paint();
        }


    }



}
