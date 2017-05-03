package weakhashmap;

/**
 * Created by vaibhav on 03-May-17.
 */
public class Temp {
    @Override
    public String toString() {
        return "temp";
    }

    public void finalize(){
        System.out.println("finalize method is called");
    }
}
