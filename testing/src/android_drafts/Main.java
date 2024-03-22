package android_drafts;

import android_drafts.Calculator;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String exp = sc.nextLine();
        Calculator calc = new Calculator(exp);
        calc.calculate();

//        Stack<String> stack = new Stack<>();
//        Stack<String> stack2 = new Stack<>();
//        String temp = "";
//
//
//        for (int c = 0; c < exp.length(); c++) {
//            if(exp.charAt(c) == '-' || exp.charAt(c) == '/' || exp.charAt(c) == '+' || exp.charAt(c) == '*'){
//                System.out.println("here op");
//                stack.push(temp);
//                stack.push(String.valueOf(exp.charAt(c)));
//                temp="";
//                continue;
//            }
//            temp+=String.valueOf(exp.charAt(c));
//            System.out.println("here num");
//            if(c==exp.length()-1){
//                stack.push(temp);
//            }
//
//        }
//
//
//        int n = stack.size();
//        for (int i = 0; i < n; i++) {
//            if (stack.isEmpty()) {
//                break;
//            }
////            System.out.print(stack.peek());
//            if (Objects.equals(stack.peek(), "*")) {
//
//                stack.pop();
//                int temp1 = Integer.parseInt(stack.pop());
//                int temp2 = Integer.parseInt(stack2.pop());
//                int result = temp2 * temp1;
//                stack2.push(String.valueOf(result));
//            } else {
//
//                stack2.push(stack.pop());
//                int s = stack.size();
//
//            }
//        }
//
//        n = stack2.size();
//        for (int i = 0; i < n; i++) {
//            stack.push(stack2.pop());
//        }
//        n = stack.size();
//
//        for (int i = 0; i < n; i++) {
//            if (stack.isEmpty()) {
//                break;
//            }
//            if (Objects.equals(stack.peek(), "/")) {
//                stack.pop();
//                int temp1 = Integer.parseInt(stack.pop());
//                int temp2 = Integer.parseInt(stack2.pop());
//                int result = temp1 / temp2;
//                stack2.push(String.valueOf(result));
//            } else {
//                stack2.push(stack.pop());
//            }
//        }
//
//        n = stack2.size();
//        for (int i = 0; i < n; i++) {
//            stack.push(stack2.pop());
//        }
//        n = stack.size();
//        for (int i = 0; i < n; i++) {
//            if (stack.isEmpty()) {
//                break;
//            }
//            if (Objects.equals(stack.peek(), "+")) {
//                System.out.println("here");
//                stack.pop();
//                int temp1 = Integer.parseInt(stack.pop());
//                int temp2 = Integer.parseInt(stack2.pop());
//                int result = temp2 + temp1;
//                stack2.push(String.valueOf(result));
//            } else {
//                stack2.push(stack.pop());
//            }
//        }
//
//
//        n = stack2.size();
//        for (int i = 0; i < n; i++) {
//            stack.push(stack2.pop());
//        }
//        n = stack.size();
//        for (int i = 0; i < n; i++) {
//            if (stack.isEmpty()) {
//                break;
//            }
//            if (Objects.equals(stack.peek(), "-")) {
//                stack.pop();
//                int temp1 = Integer.parseInt(stack.pop());
//                int temp2 = Integer.parseInt(stack2.pop());
//                int result = temp1- temp2 ;
//                stack2.push(String.valueOf(result));
//            } else {
//                stack2.push(stack.pop());
//            }
//        }
//
//        n = stack2.size();
//        for (int i = 0; i < n; i++) {
//            stack.push(stack2.pop());
//        }
//
//        System.out.println(stack.pop());
        sc.close();
    }
}