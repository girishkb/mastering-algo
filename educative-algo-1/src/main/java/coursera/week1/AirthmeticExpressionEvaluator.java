package coursera.week1;

import java.util.Stack;

public class AirthmeticExpressionEvaluator {


    public static Double solve(String expression){
        char[] expArray = expression.toCharArray();
        Stack<String> ops= new Stack<>();
        Stack<Double> values  = new Stack<Double>();

        for(char c : expArray) {

            if (c == '(') continue;
            else if (c == '+' || c == '*') ops.push(String.valueOf(c));
            else if (c == ')') {
                String op = ops.pop();
                double opsVal = 0;
                if (op.equals("+")) {
                    opsVal = values.pop() + values.pop();

                } else if (op.equals("*")) {
                    opsVal = values.pop() * values.pop();
                }
                values.push(opsVal);
            }
            else {
                values.push(Double.parseDouble(String.valueOf(c)));
            }

        }
        return  values.pop();
    }

    public static void main(String[] args) {
        String expression = "(1+((2+3)*(4*5)))";
        System.out.println("Result ---->> " + solve(expression));
    }
}
