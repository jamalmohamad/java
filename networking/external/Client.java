package networking.external;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String... args) throws UnknownHostException, IOException {
        String HOST = "127.0.0.1";
        int PORT = 2000;

        try (
            Socket socket = new Socket(HOST, PORT);
            ObjectOutputStream objOutStr = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objInputStr = new ObjectInputStream(socket.getInputStream());
            
        ){
            objOutStr.writeObject("something simple");
            objOutStr.flush();
            

        }

    }
    
}
