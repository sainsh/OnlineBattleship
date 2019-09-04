package Communication;

import Model.Cell;
import Model.Coordinate;

import java.io.Serializable;

public class MessageToClient implements Serializable {

    Cell shot;
    boolean yourShot;

    boolean isShot = false;
    boolean isMessage = false;

    String message;
    String sender;

    String clientText;
    boolean changeClientText = false;

    boolean isGameOver = false;

    private Cell[][] board;
    private boolean hasBoard = false;



    boolean yourTurn;


    public MessageToClient() {
    }

    public Cell getShot() {
        return shot;
    }

    public void setShot(Cell coordinate) {
        this.shot = coordinate;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public boolean isMessage() {
        return isMessage;
    }

    public void setMessage(boolean message) {
        isMessage = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getClientText() {
        return clientText;
    }

    public void setClientText(String clientText) {
        this.clientText = clientText;
    }

    public boolean isChangeClientText() {
        return changeClientText;
    }

    public void setChangeClientText(boolean changeClientText) {
        this.changeClientText = changeClientText;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public boolean isYourShot() {
        return yourShot;
    }

    public void setYourShot(boolean yourShot) {
        this.yourShot = yourShot;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
        hasBoard = true;
    }

    public boolean isHasBoard() {
        return hasBoard;
    }

    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }
}
