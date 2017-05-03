package weakhashmap;

import java.util.WeakHashMap;

/**
 * Created by vaibhav on 03-May-17.
 */

/**
 * In this program GarbageCollector will dominate over WeakHashMap and remove the unused objects.
 * But this will not happen with HashMap, because HashMap will dominates over GarbageCollector
 * and won't allow GC to remove unused objects.
 */
public class WeakHashMapVsGarbageCollector {
    public static void main(String[] args) throws InterruptedException {
        Temp t = new Temp();
        WeakHashMap whm = new WeakHashMap();
        whm.put(t, "vaibhav");
        System.out.println(whm);
        //here I am setting the value of t equal to null, so now it would be eligible for garbage collector
        t = null;
        //calling the garbage collector, because unused object is here
        System.gc();
        //causing the main thread to sleep for 5 seconds
        Thread.sleep(5000);
        //now printing the map value again
        System.out.println(whm);
    }
}
