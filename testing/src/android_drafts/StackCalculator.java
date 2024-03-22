package android_drafts;

import java.util.Stack;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StackCalculator {
    ArrayList<String> expTokens = new ArrayList<String>();
    Stack<String> st1 = new Stack<>();
    Stack<String> st2 = new Stack<>();
    String temp = "";

    public StackCalculator(String exp){
        StringTokenizer strToken = new StringTokenizer(exp);
        while(strToken.hasMoreTokens()){
            expTokens.add(strToken.nextToken());
        }
    }
}
