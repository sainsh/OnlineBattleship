package Communication;

import Model.Cell;
import Model.Coordinate;

public class MessageToClient {

    Cell shot;
    boolean yourShot;

    boolean isShot = false;
    boolean isMessage = false;

    String message;
    String sender;

    String clientText;
    boolean changeClientText = false;

    boolean isGameOver = false;



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
}
