package networking.external;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String... args) {
        int PORT = 10000;

        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();  


        ) {

        } catch(Exception err) {
            err.printStackTrace();

        }
    }
    
}
