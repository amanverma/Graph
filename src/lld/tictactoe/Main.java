package lld.tictactoe;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        Board board = new Board(5,new Player[]{p1,p2});

    }
}
