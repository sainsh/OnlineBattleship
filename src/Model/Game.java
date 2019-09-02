package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Game {
    private Socket player1;
    private ObjectOutputStream outP1;
    private ObjectInputStream inP1;
    private Socket player2;
    private ObjectOutputStream outP2;
    private ObjectInputStream inP2;
    private Board board;



    public Socket getPlayer1() {
        return player1;
    }

    public void setPlayer1(Socket player1) {
        this.player1 = player1;
    }

    public ObjectOutputStream getOutP1() {
        return outP1;
    }

    public void setOutP1(ObjectOutputStream outP1) {
        this.outP1 = outP1;
    }

    public ObjectInputStream getInP1() {
        return inP1;
    }

    public void setInP1(ObjectInputStream inP1) {
        this.inP1 = inP1;
    }

    public Socket getPlayer2() {
        return player2;
    }

    public void setPlayer2(Socket player2) {
        this.player2 = player2;
    }

    public ObjectOutputStream getOutP2() {
        return outP2;
    }

    public void setOutP2(ObjectOutputStream outP2) {
        this.outP2 = outP2;
    }

    public ObjectInputStream getInP2() {
        return inP2;
    }

    public void setInP2(ObjectInputStream inP2) {
        this.inP2 = inP2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
