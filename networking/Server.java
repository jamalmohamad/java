package networking;

import java.io.*;
import java.util.*;
import java.net.*;



public class Server {
    public static void main(String... args){
        System.out.println("Server");
        mainObj(args);
    }



    public static void mainObj(String... args){
        int PORT = 3000; // 16bit: 1024... 65535

        try (
            ServerSocket ss = new ServerSocket(PORT);
            Socket s = ss.accept(); // blocking program wait here until client request something
            
            // text based communication
            // order of getInputStream and getOutputStream does not matter
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());


            // object based communication
            // the system send messages silently they will start communicat in a wrong way so the order is matter

        ) {

            //String name = sc.nextLine(); // pick the messege up from client
            

            String name = sc.next();  // next will get word and skip empty strings, tabs , make sure to use only one in the program either next or nextline


            pw.println("Hello " + name);
            pw.flush();

            String name2 = sc.next();  // next will get word and skip empty strings, tabs , make sure to use only one in the program either next or nextline
            

            pw.println("Hello " + name2);
            pw.flush();

        } catch(Exception e){
            e.printStackTrace();

        }
    }
    
}
