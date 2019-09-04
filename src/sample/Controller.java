package sample;

import Communication.Connector;
import Communication.MessageToClient;
import Communication.MessageToServer;
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



    @FXML
    public void initialize() {

        playerContext = playerBoard.getGraphicsContext2D();
        enemyContext = enemyBoard.getGraphicsContext2D();

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
            messageToServer.setX(clickedX);
            messageToServer.setY(clickedY);
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
        } else {
            yourTurn = messageToClient.isYourTurn();
        }

        if (messageToClient.isShot()) {
            draw(messageToClient);
        }
        if (messageToClient.isChangeClientText()) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ServerMessageLabel.setText(messageToClient.getClientText());
                }
            };
            Platform.runLater(runnable);

        }
        if (messageToClient.isHasBoard()) {
            drawBoard(messageToClient.getBoard());
        }

    }

    private void draw(MessageToClient messageToClient) {
        System.out.println(messageToClient.getStatus());
        switch (messageToClient.getStatus()) {
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

            playerContext.fillRect(messageToClient.getX() * coordinateSize + 2, messageToClient.getY() * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);

        } else {

            enemyContext.fillRect(messageToClient.getX() * coordinateSize + 2, messageToClient.getY() * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);
        }
    }

    private void drawBoard(int[][] board) {

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                playerContext.setFill(Color.WHITE);
                playerContext.fillRect(x * coordinateSize, y * coordinateSize, coordinateSize, coordinateSize);
                if (board[x][y] == 1) {
                    playerContext.setFill(Color.BLACK);
                } else {
                    playerContext.setFill(Color.BLUE);
                }
                playerContext.fillRect(x * coordinateSize + 2, y * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);

                enemyContext.setFill(Color.WHITE);
                enemyContext.fillRect(x * coordinateSize, y * coordinateSize, coordinateSize, coordinateSize);
                enemyContext.setFill(Color.BLUE);
                enemyContext.fillRect(x * coordinateSize + 2, y * coordinateSize + 2, coordinateSize - 2, coordinateSize - 2);
            }
        }
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        connector.closeConnection();
    }
}
