package networking.external;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainE {
    public static void main(String... args) throws InterruptedException {
          // lambda: Runnable
          new Thread(() -> {
            Server.main(args);
        }).start();

        // wait for 0.1 seconds
        Thread.sleep(100);

        new Thread(() -> {
            Client.main(args);
        }).start();
    }
    
}
