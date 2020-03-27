package Tiles;

import Graphic.Canvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case (KeyEvent.VK_DOWN):
                Canvas.Moving(Moves.Spin);
                break;
            case (KeyEvent.VK_RIGHT):
                Canvas.Moving(Moves.Right);
                break;
            case (KeyEvent.VK_LEFT):
                Canvas.Moving(Moves.Left);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
