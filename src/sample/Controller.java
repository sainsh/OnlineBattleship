package sample;

import Communication.Connector;
import Communication.MessageToClient;
import Communication.MessageToServer;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    Connector connector;
    Thread thread;

    int coordinateSize = 10;
    int clickedX;
    int clickedY;

    @FXML
    TextField chatText;
    @FXML
    TextArea chatHistoryText;

    Board playerBoard;
    Board enemyBoard;


    @FXML
    public void initialize() {
        connector = new Connector(this);
        thread = new Thread(connector);
        thread.start();

    }


    public void onMouseClickedEnemyBoard(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown()) {
            clickedX = (int)mouseEvent.getX()/coordinateSize;
            clickedY = (int)mouseEvent.getY()/coordinateSize;


            MessageToServer messageToServer = new MessageToServer();

            messageToServer.setShot(true);
            messageToServer.setShot(enemyBoard.getCell(clickedX,clickedY));
            connector.send(messageToServer);

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
        if(messageToClient.isMessage()){
            chatHistoryText.appendText(messageToClient.getMessage() + "\n");
        }

        if(messageToClient.isShot()){
            draw(messageToClient);
        }

    }

    private void draw(MessageToClient messageToClient) {
    }
}
