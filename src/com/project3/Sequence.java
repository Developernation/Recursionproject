package com.project3;

/**
 * Created by enjoi on 9/26/16.
 */
public class Sequence {

    private static int effncy = 0;
    private static int last;
    private static int rVal = 0;
    private static int nxt;

    // Default constructor so no object can be created from this class
    private Sequence() {
    }

    public static int recursion(int n) {
        effncy = 0;
        return actualRecursion(n); // Just calls the recursive method
    }

    private static int actualRecursion(int n) {

        // This method takes in the input of n and if it equals 0 or 1 returns

        if (n == 0) {
            effncy++;
            return 0;
        } else if (n == 1) {
            effncy++;
            return 1;
        } else {
            effncy++;
            return 2 * actualRecursion(n - 1) + actualRecursion(n - 2);
        }

    }
    public static int efficincy(){ // Getter for the efficiency
        return effncy;
    }


    public static int iterative(int n) { // Iterative method
        effncy = 0;


        if (n == 0) {
            effncy++;
            return 0;
        } else if (n == 1) {
            effncy++;
            return 1;
        } else {
            last = 1;
            nxt = 0;

            for (int i = 2; i <= n; i++) {
                effncy++;
                rVal = 2 * last + nxt;
                nxt = last;
                last = rVal;
            }
        }

        return rVal;
    }


}



















