package Communication;

import sample.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connector implements Runnable {

    private Controller controller;
    MessageToClient messageToClient;


    String host = "localhost";
    int port = 8000;

    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    Object inputObject;

    public Connector(Controller controller){
        this.controller = controller;
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
                    controller.respondToMessage(messageToClient);

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
}
