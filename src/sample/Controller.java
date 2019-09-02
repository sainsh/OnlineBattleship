package sample;

import Communication.Connector;
import Communication.MessageToClient;
import Communication.MessageToServer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    Connector connector;
    Thread thread;

    @FXML
    public void initialize(){
        connector = new Connector(this);
        thread = new Thread(connector);
        thread.start();

    }


    public void onMouseClickedEnemyBoard(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown()) {

        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            send();
        }
    }

    public void send() {
        MessageToServer messageToServer = new MessageToServer();

        connector.send(messageToServer);
    }

    public void respondToMessage(MessageToClient messageToClient) {



    }
}
