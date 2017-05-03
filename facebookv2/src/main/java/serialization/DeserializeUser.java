package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
public class DeserializeUser {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\user.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            ois.close();
            System.out.println(user.getId() + ", " + user.getName());
            System.out.println("Object successfully read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
