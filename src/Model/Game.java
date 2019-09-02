package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Game {
    Socket player1;
    ObjectOutputStream outP1;
    ObjectInputStream inP1;
    Socket player2;
    ObjectOutputStream outP2;
    ObjectInputStream inP2;
    Board board;
    //Board
}
