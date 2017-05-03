package towerofhanoi;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
public class TowerOfHanoiProblem {

    public void towerOfHanoi(int n, char frompeg, char topeg, char auxpeg) {
        //if there is only one element then shift it from frompeg to topeg
        if (n == 1) {
            System.out.println("Moving disk from " + frompeg + " to " + topeg);
            return;
        }

        //if n>1, then move n-1 disks
        towerOfHanoi(n - 1, frompeg, auxpeg, topeg);
        System.out.println("Moving disk from " + frompeg + " to " + topeg);
        towerOfHanoi(n - 1, auxpeg, topeg, frompeg);
    }

    public static void main(String[] args) {
        TowerOfHanoiProblem towerOfHanoiProblem = new TowerOfHanoiProblem();
        towerOfHanoiProblem.towerOfHanoi(3, 'A', 'C', 'B');
    }
}
