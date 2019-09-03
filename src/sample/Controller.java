package sample;

import Communication.Connector;
import Communication.MessageToClient;
import Communication.MessageToServer;
import Model.Board;
import Model.Cell;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller implements Connector.ConnectorListener {

    private Connector connector;
    private Thread thread;

    private boolean yourTurn = false;

    private int coordinateSize = 90;
    private int clickedX;
    private int clickedY;

    @FXML
    TextField chatText;
    @FXML
    TextArea chatHistoryText;
    @FXML
    Label ServerMessageLabel;
    @FXML
    Canvas enemyBoard;
    @FXML
    Canvas playerBoard;


    private GraphicsContext playerContext;
    private GraphicsContext enemyContext;

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
        if (mouseEvent.getButton() == MouseButton.PRIMARY && yourTurn) {
            clickedX = (int) mouseEvent.getX() / coordinateSize;
            clickedY = (int) mouseEvent.getY() / coordinateSize;
            System.out.println(clickedX + " " + clickedY);


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
        chatText.setText("");

        connector.send(messageToServer);
    }

    public void respondToMessage(MessageToClient messageToClient) {
        System.out.println(messageToClient.isChangeClientText());
        if (messageToClient.isMessage()) {
            chatHistoryText.appendText(messageToClient.getMessage() + "\n");
        }else{
            yourTurn = messageToClient.isYourTurn();
        }

        if (messageToClient.isShot()) {
            draw(messageToClient);
        }
        if(messageToClient.isChangeClientText()){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ServerMessageLabel.setText(messageToClient.getClientText());
                }
            };
            Platform.runLater(runnable);

        }

    }

    private void draw(MessageToClient messageToClient) {

        switch (messageToClient.getShot().getStatus()) {
            case 1: //not shot at
                playerContext.setFill(Color.BLUE);
                enemyContext.setFill(Color.BLUE);
                break;
            case 2: //miss
                playerContext.setFill(Color.YELLOW);
                enemyContext.setFill(Color.YELLOW);
                break;
            case 3: // hit on ship
                playerContext.setFill(Color.RED);
                enemyContext.setFill(Color.RED);
                break;
        }

        if (!messageToClient.isYourShot()) {

            playerContext.fillRect(messageToClient.getShot().getCoordinate().getX()*coordinateSize + 2 , messageToClient.getShot().getCoordinate().getY()*coordinateSize+2, coordinateSize-2, coordinateSize-2);

        }else{

            enemyContext.fillRect(messageToClient.getShot().getCoordinate().getX()*coordinateSize+2, messageToClient.getShot().getCoordinate().getY()*coordinateSize+2, coordinateSize-2, coordinateSize-2);
        }
    }

    private void drawBoard() {

        for (Cell[] cells : board.getPlayerBoard()) {
            for (Cell cell : cells) {

                playerContext.setFill(Color.WHITE);

                playerContext.fillRect(cell.getCoordinate().getX() * coordinateSize, cell.getCoordinate().getY() * coordinateSize, coordinateSize, coordinateSize);

                if (cell.getShip() == null) {
                    playerContext.setFill(Color.BLUE);

                } else {
                    playerContext.setFill(Color.BLACK);
                }
                playerContext.fillRect(cell.getCoordinate().getX() * coordinateSize + 2, cell.getCoordinate().getY() * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);
            }
        }

        for (Cell[] cells : board.getEnemyBoard()) {
            for (Cell cell : cells) {

                enemyContext.setFill(Color.WHITE);

                enemyContext.fillRect(cell.getCoordinate().getX() * coordinateSize, cell.getCoordinate().getY() * coordinateSize, coordinateSize, coordinateSize);

                if (cell.getShip() == null) {
                    enemyContext.setFill(Color.BLUE);

                } else {
                    enemyContext.setFill(Color.BLACK);
                }
                enemyContext.fillRect(cell.getCoordinate().getX() * coordinateSize + 2, cell.getCoordinate().getY() * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);

            }
        }
    }

    @FXML
    public void exitApplication(ActionEvent event){
        connector.closeConnection();
    }
}
