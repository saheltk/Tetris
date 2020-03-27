package Graphic;

import Board.Board;
import Tiles.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGraphic {
    public static int BoardSize;
    static int score=0;
    static Frame frame = new Frame("TETRIS");
    static JButton Score;
    //BOARD
    static JButton [][] board ;
   static Board boardGame;

    public static void addScore(int k){
        score+=k;
        Score.setText(String.valueOf(score));
    }
    public static void setSize(){
        Frame f = new Frame("TETRIS ENTRANCE");
        f.setResizable(false);
        f.setLayout(null);
        JRadioButton size1 = new JRadioButton("6*18");
        JRadioButton size2 = new JRadioButton("8*18");
        JRadioButton size3 = new JRadioButton("10*18");
        JRadioButton size4 = new JRadioButton("12*18");
        ButtonGroup group= new ButtonGroup();
        Label size = new Label("Size: ");
        JButton click = new JButton("Done!");

        size1.setSelected(true);
        size1.setBounds(150,50,250,30);
        size2.setBounds(150,80,250,30);
        size3.setBounds(150,110,250,30);
        size4.setBounds(150,140,250,30);
        size.setBounds(100,50,50,30);
        click.setBounds(150,170,70,30);
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (size1.isSelected()) BoardSize=6;
                if (size2.isSelected()) BoardSize=8;
                if (size3.isSelected()) BoardSize=10;
                if (size4.isSelected()) BoardSize=12;
                f.setVisible(false);
                run();
            }
        });

//Colors
        size.setForeground(Color.WHITE);click.setBackground(Color.WHITE);
        size1.setForeground(Color.WHITE);size1.setBackground(Color.BLACK);
        size2.setForeground(Color.WHITE);size2.setBackground(Color.BLACK);
        size3.setForeground(Color.WHITE);size3.setBackground(Color.BLACK);
        size4.setForeground(Color.WHITE);size4.setBackground(Color.BLACK);


        group.add(size1); group.add(size2); group.add(size3); group.add(size4);

        f.setBackground(Color.BLACK);
        f.add(click);
        f.add(size);
        f.add(size1); f.add(size2); f.add(size3); f.add(size4);
        f.setBounds(550,150,400,220);
        f.setVisible(true);
    }
    public static void board() {
        board= new JButton[BoardSize][18];
        boardGame = new Board();
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < BoardSize; j++) {
                board[j][i] = new JButton();
                board[j][i].setBounds(60 + j * 30, 100 + i * 30, 28, 28);
                board[j][i].setBackground(Color.lightGray);
                board[j][i].setBorderPainted(false);
                frame.add(board[j][i]);
            }
        }
        JButton jb = new JButton();
        frame.add(jb);
        frame.remove(jb);
    }
    public static void run(){
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);
        frame.setBounds(50,30, Constants.maxWidth,Constants.maxHeigth);
        frame.setResizable(false);
        frame.getMenuBar();

       JButton ScoreName= new JButton("SCORE");
        ScoreName.setBounds(485,50,100,30);
        ScoreName.setBackground(Color.BLACK);
        ScoreName.setForeground(Color.ORANGE);
        ScoreName.setBorderPainted(false);
        frame.add(ScoreName);

        JButton NextName= new JButton("Next Tile");
        NextName.setBounds(485,130,100,40);
        NextName.setBackground(Color.BLACK);
        NextName.setForeground(Color.BLUE);
        NextName.setBorderPainted(false);
        frame.add(NextName);

        JButton TOPTEN= new JButton("TOP 10");
        TOPTEN.setBounds(485,180,100,40);
        TOPTEN.setBackground(Color.BLACK);
        TOPTEN.setForeground(Color.green);
        TOPTEN.setBorderPainted(false);
        frame.add(TOPTEN);

        Score= new JButton(String.valueOf(score));
        Score.setBounds(500,80,70,40);
        Score.setBackground(Color.orange);
        Score.setForeground(Color.BLACK);
        Score.setBorderPainted(false);
        frame.add(Score);

        JButton line = new JButton();
        line.setBounds(450,30,5,700);
        line.setBackground(Color.magenta);
        line.setBorderPainted(false);
        frame.add(line);
        frame.setVisible(true);
        board();
        runGame();
    }

    public static void runGame(){
        Canvas canvas = new Canvas();

    }
    public static void main(String[] args) {
     setSize();

    }
}
