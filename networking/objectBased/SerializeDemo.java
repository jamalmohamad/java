package networking.objectBased;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "MO";
        e.address = "Budapest";
        e.SSN = 1232112;
        e.number = 101;

        try(
            FileOutputStream fileOut = new FileOutputStream("employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
           
        ) {

            out.writeObject(e);
            out.flush();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.ser");


        } catch(Exception err) {
            err.printStackTrace();

        }
    }
    
    
}
