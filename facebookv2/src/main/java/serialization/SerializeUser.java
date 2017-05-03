package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
public class SerializeUser {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Vaibhav Soni");
        try {
            FileOutputStream fos = new FileOutputStream("D:\\user.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            System.out.println("Writting object Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
