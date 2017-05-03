package general;

import java.math.BigDecimal;

/**
 * Created by vaibhav on 02-May-17.
 */
public class FractionalProblem {

    public static void main(String[] args) {
        //String result = calculateResult(getDivision(10, 3), 3);
        String res2 = calculateResult(3.000014222722222222222222222, 10);
        //String res2 = calculateResult(4.122245555, 3);
        //String res2 = calculateResult(getDivision(22, 7), 2);
        //System.out.println(result);
        System.out.println(res2);
        double d1 = 2.15;
        double d2 = 1.10;
        System.out.println(d1 + "\n" + d2 + "\n" + (d1 - d2));

        BigDecimal bigDecimal1 = new BigDecimal("2.15");
        BigDecimal bigDecimal2 = new BigDecimal("1.10");
        System.out.println(bigDecimal1.subtract(bigDecimal2));

    }

    public static double getDivision(int a, int b) {
        return (double) a / b;
    }

    public static String calculateResult(double d, int minAllowedRepeatence) {
        int count = 1;
        String completeValue = d + "";
        int indexOfDot = completeValue.indexOf('.');
        String afterDot = completeValue.substring(indexOfDot + 1, completeValue.length());
        if (afterDot.equals("0")) {
            return completeValue.substring(0, indexOfDot);
        }
        char[] afterDotCharArray = afterDot.toCharArray();
        char prev = afterDotCharArray[0];
        String processingValue = prev + "";
        for (int i = 1; i < afterDotCharArray.length; i++) {
            if (prev == afterDotCharArray[i] && i != afterDotCharArray.length - 1) {
                count++;
            } else {
                if (count > minAllowedRepeatence) {
                    if (processingValue.charAt(processingValue.length() - 1) == prev) {
                        processingValue = processingValue.substring(0, processingValue.length() - 1);
                    }
                    processingValue += "(" + prev + ")";
                    count = 1;
                } else if (count > 1 && count <= minAllowedRepeatence) {
                    //int initialDependencyIndex = (processingValue.length() == 1) ? 1 : 0;
                    for (int j = 1/*initialDependencyIndex*/; j < count; j++) {
                        processingValue += prev + "";
                    }
                    count = 1;
                }
                if (getPreviousChar(processingValue) != afterDotCharArray[i]) {
                    processingValue += afterDotCharArray[i] + "";
                }
            }
            prev = afterDotCharArray[i];
        }
        return completeValue.substring(0, indexOfDot + 1) + processingValue;
    }

    private static char getPreviousChar(String processingValue) {
        int processingValueLength = processingValue.length();
        if (processingValue.charAt(processingValueLength - 1) == ')') {
            return processingValue.charAt(processingValueLength - 2);
        }
        return processingValue.charAt(processingValueLength - 1);
    }
}
