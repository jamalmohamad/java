package networking.external;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String... args) {
        String HOST = "127.0.0.1";
        int PORT = 10000;

        try (
            Socket socket = new Socket(HOST, PORT);
            ObjectOutputStream objOutStr = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objInputStr = new ObjectInputStream(socket.getInputStream());
            
        ){
            objOutStr.writeObject(new MyData(123, "abc"));
            objOutStr.flush();

            MyData answer = (MyData)objInputStr.readObject();
            System.out.println("Client got: " + answer);


           
            

        } catch(Exception err){
            err.printStackTrace();

        }

    }
    
}
