package verifyinganarrayissorted;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
public class AnArrayIsSorted {

    public boolean isArraySorted(int[] a, int size) {
        if (size == 1) {
            System.out.println("All elements are sorted.");
            return true;
        }
        return (a[size - 1] < a[size - 2]) ? false : isArraySorted(a, size - 1);
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 1};
        AnArrayIsSorted anArrayIsSorted = new AnArrayIsSorted();
        boolean sorted = anArrayIsSorted.isArraySorted(a, a.length);
        System.out.println(sorted);
    }
}
