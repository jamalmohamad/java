package networking.external;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String... args) {
        int PORT = 10000;

        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();  


            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


        ) {
            MyData msg = (MyData)ois.readObject();

            msg.x *= 2;
            msg.y += msg.y;

            oos.writeObject(msg);
            oos.flush();

        } catch(Exception err) {
            err.printStackTrace();

        }
    }
    
}
