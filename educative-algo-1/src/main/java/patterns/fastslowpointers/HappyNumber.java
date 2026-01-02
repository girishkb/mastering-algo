package patterns.fastslowpointers;

import java.util.HashSet;
import java.util.Set;

/*
LC - 202
* Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


*
* */
public class HappyNumber {

    public boolean isHappy(int number) {

        int s = number;
        Set<Integer> visited = new HashSet<>();

        while (s != 1 && !visited.contains(s)) {
            visited.add(s);
            s = getNextNumber(s);
        }
        return s == 1;
    }


    public int getNextNumber(int number) {

        int next = 0;

        while (number > 0) {
            int digit =  number%10;
            next+= (digit*digit);
            number = number/10;
        }
        return next;
    }


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println("19: " + happyNumber.isHappy(19));  // true
        System.out.println("2: " + happyNumber.isHappy(2));    // false
        System.out.println("1: " + happyNumber.isHappy(1));    // true
        System.out.println("7: " + happyNumber.isHappy(7));    // true
        System.out.println("4: " + happyNumber.isHappy(4));    // false (enters cycle)


    }
}
