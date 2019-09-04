package Communication;

import java.io.Serializable;

public class MessageToServer implements Serializable {

    private boolean isChatMessage = false;
    boolean isShot = false;
    private String chatMessage;
    private int x, y;
    private String sender;

    public MessageToServer() {

    }

    public boolean isChatMessage() {
        return isChatMessage;
    }

    public void setChatMessage(boolean chatMessage) {
        isChatMessage = chatMessage;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
