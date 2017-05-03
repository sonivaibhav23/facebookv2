package backtracking;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
public class FindingStringCombinations {

    int[] A = new int[2];

    public void binary(int n) {

        if (n == 0) {
            for (int i=0;i<A.length;i++){
                System.out.print(A[i]);
            }
        }
        A[n - 1] = 0;
        binary(n - 1);
        A[n - 1] = 1;
        binary(n - 1);
    }

    public static void main(String[] args) {
        FindingStringCombinations findingStringCombinations = new FindingStringCombinations();
        findingStringCombinations.binary(2);
    }
}
