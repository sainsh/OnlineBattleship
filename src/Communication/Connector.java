package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connector implements Runnable {

    private ConnectorListener listener;
    private MessageToClient messageToClient;


    private String host = "localhost";
    private int port = 8000;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Object inputObject;

    public interface ConnectorListener{
        void respondToMessage(MessageToClient messageToClient);
    }

    public Connector(ConnectorListener listener){
        this.listener = listener;
    }


    @Override
    public void run() {

        try {
            socket = new Socket(host,port);

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            while(true){

                inputObject = in.readObject();
                if(inputObject.getClass() == MessageToClient.class){
                    messageToClient = (MessageToClient) inputObject;
                    listener.respondToMessage(messageToClient);

                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void send(MessageToServer messageToServer){

        try {
            out.writeObject(messageToServer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
