package networking;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String... args) {
        System.out.println("Client");
        
        String HOST =  "localhost";
        int PORT = 3000;

        try(
            Socket s = new Socket(HOST, PORT);

            PrintWriter pw = new PrintWriter(s.getOutputStream());
            Scanner sc = new Scanner(s.getInputStream());

        ){
            pw.println("Joe Jane");
            // pw.println("Jane");
            pw.flush();

            String answer = sc.nextLine(); // get the answer from server
            System.out.println("Client got: " + answer);

            String answer2 = sc.nextLine(); // get the answer from server
            System.out.println("Client got: " + answer2);
        
        } catch(Exception e){
            e.printStackTrace();

        }
    }
    
}
