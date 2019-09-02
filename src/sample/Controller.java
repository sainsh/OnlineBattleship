package sample;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {


    public void onMouseClickedEnemyBoard(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()){

        }
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            send();
        }
    }

    public void send() {
    }
}
