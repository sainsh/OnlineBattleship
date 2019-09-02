package Communication;

public class MessageToClient {

    Coordinate coordinate;

    boolean isShot = false;
    boolean isMessage = false;

    String message;
    String sender;

    String clientText;
    boolean changeClientText = false;

    boolean isGameOver = false;

    boolean setBoard;
    Cell[][] board;

    boolean yourTurn;

    public MessageToClient() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
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

    public boolean isSetBoard() {
        return setBoard;
    }

    public void setSetBoard(boolean setBoard) {
        this.setBoard = setBoard;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}
