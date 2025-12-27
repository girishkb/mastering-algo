package org.example;

public class PeasantMultiply {

    public static int multiply(int x, int y){
        if (x == 0 ) return 0;
         else {
             int x_hat = x/2;
             int y_hat = y + y;

             int prod = multiply(x_hat, y_hat);
             if(x%2 !=0){
                 prod  = prod + y;
             }
             return prod;
        }
    }
    public static void main(String[] args) {
        System.out.println(multiply(110,3));
    }
}
