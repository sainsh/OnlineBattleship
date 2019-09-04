package Communication;

import java.io.Serializable;

public class MessageToClient implements Serializable {

    private boolean yourShot;

    private boolean isShot = false;
    private boolean isMessage = false;

    private String message;
    private String sender;

    private String clientText;
    private boolean changeClientText = false;

    private boolean isGameOver = false;

    private boolean hasBoard = false;


    private boolean yourTurn;

    private int x;
    private int y;
    private int status;
    private boolean shipSunken;
    private int[] coordinate;
    private int[][] board;

    public MessageToClient() {
    }

    public boolean isYourShot() {
        return yourShot;
    }

    public void setYourShot(boolean yourShot) {
        this.yourShot = yourShot;
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

    public boolean isHasBoard() {
        return hasBoard;
    }

    public void setHasBoard(boolean hasBoard) {
        this.hasBoard = hasBoard;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isShipSunken() {
        return shipSunken;
    }

    public void setShipSunken(boolean shipSunken) {
        this.shipSunken = shipSunken;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}

