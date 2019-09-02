package Communication;

public class MessageToServer {

    boolean isChatMessage = false;
    boolean isShot = false;
    String chatMessage;
    Cell shot;
    String sender;

    public MessageToServer(boolean isChatMessage, boolean isShot, String chatMessage, Cell shot, String sender) {
        this.isChatMessage = isChatMessage;
        this.isShot = isShot;
        this.chatMessage = chatMessage;
        this.shot = shot;
        this.sender = sender;
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

    public Cell getShot() {
        return shot;
    }

    public void setShot(Cell shot) {
        this.shot = shot;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
