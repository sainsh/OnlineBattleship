package sample;

import Communication.Connector;
import Communication.MessageToClient;
import Communication.MessageToServer;
import Model.Board;
import Model.Cell;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {

    private Connector connector;
    private Thread thread;

    private boolean yourTurn = false;

    private int coordinateSize = 100;
    private int clickedX;
    private int clickedY;

    @FXML
    TextField chatText;
    @FXML
    TextArea chatHistoryText;
    @FXML
    Canvas enemyBoard;
    @FXML
    Canvas playerBoard;

    GraphicsContext playerContext;
    GraphicsContext enemyContext;

    private Board board;


    @FXML
    public void initialize() {

        board = new Board();
        playerContext = playerBoard.getGraphicsContext2D();
        enemyContext = enemyBoard.getGraphicsContext2D();
        drawBoard();

        connector = new Connector(this);
        thread = new Thread(connector);
        thread.start();

    }


    public void onMouseClickedEnemyBoard(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown() && yourTurn) {
            clickedX = (int) mouseEvent.getX() / coordinateSize;
            clickedY = (int) mouseEvent.getY() / coordinateSize;


            MessageToServer messageToServer = new MessageToServer();

            messageToServer.setShot(true);
            messageToServer.setShot(board.getEnemyBoard()[clickedX][clickedY]);
            connector.send(messageToServer);
            yourTurn = false;

        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            send();
        }
    }

    public void send() {
        MessageToServer messageToServer = new MessageToServer();
        messageToServer.setChatMessage(true);
        messageToServer.setChatMessage(chatText.getText());
        chatHistoryText.appendText(chatText.getText() + "\n");
        chatText.setText("");

        connector.send(messageToServer);
    }

    public void respondToMessage(MessageToClient messageToClient) {
        if (messageToClient.isMessage()) {
            chatHistoryText.appendText(messageToClient.getMessage() + "\n");
        }

        if (messageToClient.isShot()) {
            draw(messageToClient);
        }

        yourTurn = messageToClient.isYourTurn();

    }

    private void draw(MessageToClient messageToClient) {

    }

    private void drawBoard() {

        for (Cell[] cells : board.getPlayerBoard()){
            for (Cell cell: cells) {
                System.out.println(cell.getCoordinate().getX()+ " " + cell.getCoordinate().getY());
                if(cell.getShip() == null){
                    playerContext.setFill(Color.BLUE);

                }else{
                    playerContext.setFill(Color.BLACK);
                }
                playerContext.fillRect(cell.getCoordinate().getX()*coordinateSize,cell.getCoordinate().getY()*coordinateSize,coordinateSize,coordinateSize);
            }
        }

        for (Cell[] cells : board.getEnemyBoard()){
            for (Cell cell: cells) {

                if(cell.getShip() == null){
                    enemyContext.setFill(Color.BLUE);

                }else{
                    enemyContext.setFill(Color.BLACK);
                }
                enemyContext.fillRect(cell.getCoordinate().getX()*coordinateSize,cell.getCoordinate().getY()*coordinateSize,coordinateSize,coordinateSize);
            }
        }
    }
}
