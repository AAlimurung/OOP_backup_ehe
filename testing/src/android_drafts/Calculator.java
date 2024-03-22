package android_drafts;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
public class Calculator {
    //String exp;
    ArrayList<String> expTokens = new ArrayList<String>();

    //constructor
    public Calculator(String exp){
        //this.exp = exp;
        StringTokenizer strToken = new StringTokenizer(exp);

        while(strToken.hasMoreTokens()){
            expTokens.add(strToken.nextToken());
        }
    }

    public ArrayList<String> invert (Stack<String> original){
        //reverse to retain original
        ArrayList<String> ary = new ArrayList<>();
        Stack<String> temp = new Stack<>();

        while(original.size() > 0){
            temp.push(original.pop());
        }

        while (temp.size()>0){
            ary.add(temp.pop());
        }

        for(String a : ary){
            System.out.print(a + " ");
        }
        System.out.println();
        return ary;
    }

    public String calculate(){
        int len = expTokens.size();
        Stack<String> str1 = new Stack<>();
        Stack<String> str2 = new Stack<>();
        boolean pin = false;

        //multiply and divide
        for (int i = 0; i<len; i++){
            if(pin){
                pin = false;
                continue;
            }

            String curr = expTokens.get(i);
            if(i == len - 1){
                str1.push(curr);
                break;
            }

            String last = expTokens.get(i+1);
            if(curr.equals("*")){
                double n1 = Double.parseDouble(str1.pop());
                double n2 = Double.parseDouble(last);
                str1.push(Double.toString(n1 * n2));
                System.out.print("here op * ");
                pin = true;
            } else if (curr.equals("/")){
                double n1 = Double.parseDouble(str1.pop());
                double n2 = Double.parseDouble(last);
                if(Double.parseDouble(last) == 0){
                    throw new ArithmeticException("Cannot divide with zero");
                }

                str1.push(Double.toString(n1/n2));
                System.out.print("here / ");
                pin = true;
            } else{
                str1.push(curr);
            }
        }

        ArrayList<String> exp2 = invert(str1);
        len = exp2.size();

        if(len==1){
            return exp2.get(0);
        }

        pin = false;

        //add and subtract
        for(int i=0; i<len; i++){
            if(pin){
                pin=false;
                continue;
            }

            String curr = exp2.get(i);
            if(i == len-1){
                str1.push(curr);
                break;
            }

            String last = exp2.get(i+1);
            if(curr.equals("+")){
                double n1 = Double.parseDouble(str2.pop());
                double n2 = Double.parseDouble(last);
                str2.push(Double.toString(n1 + n2));
                System.out.print("here op + " + (n1+n2));
                pin = true;
            } else if (curr.equals("-")){
                double n1 = Double.parseDouble(str2.pop());
                double n2 = Double.parseDouble(last);
                str2.push(Double.toString(n1-n2));
                System.out.print("here op -");
                pin = true;
            } else {
                str2.push((curr));
            }
        }

        System.out.print("here answer");
        System.out.println(" " + str2.peek());
        return str2.peek();
    }
}