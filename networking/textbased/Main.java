package networking.textbased;


public class Main {
    public static void main(String... args) throws Exception {
        //lambda: Runnable
        new Thread( () -> {
            Server.main(args);
        }).start();

        Thread.sleep(1000);

        new Thread( () -> {
            Client.main(args);
        }).start();


    }
    
}
