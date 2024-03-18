import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String pass = sc.nextLine();
        int leftLen = pass.length();

        StringBuilder atk = new StringBuilder();
        atk.append("a".repeat(leftLen));

//        int aps = 0; //counter
        Thread[] thrd = new Thread[26];

        for(int i=0; i<26; i++){
            thrd[i] = new Thread(new bruteForce((char)('a'+i), pass));
        }

        for (Thread t :
                thrd) {
            t.start();
        }

        for (Thread t :
                thrd) {
            try{
                t.join();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }

        /*while(!atk.toString().equals(pass)){
            int[] ary = new int[leftLen];
            aps++;
            int temp = aps;
            for(int i=leftLen-1, j=0; i>=0; i--,j++){
                ary[j] = temp/(int) Math.pow(26, i);
                temp = temp % (int) Math.pow(26, i);
            }

            atk = new StringBuilder();
            for(int i = 0; i<leftLen; i++){
                atk.append((char) ('a'+ary[i]));
            }

            System.out.println(atk);
        }*/
    }
}