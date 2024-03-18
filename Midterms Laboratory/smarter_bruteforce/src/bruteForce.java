public class bruteForce implements Runnable{

    private char ch;
    private String pass;
    static boolean pin = false;

    public bruteForce(char ch, String pass) {
        this.ch = ch;
        this.pass = pass;
    }

    @Override
    public void run() {
        int leftLen = pass.length();
        StringBuilder atk = new StringBuilder(ch);
        atk.append(ch).append("a".repeat(leftLen-1));
        int[] ary = new int[leftLen];
        int aps = 0;

        while(!atk.toString().equals(pass) && aps < Math.pow(26, leftLen) && !pin){
            aps++;
            int temp = aps;
            for(int i=leftLen-1; i>=0; i--){
                ary[i] = temp / (int) Math.pow(26, i);
                temp = temp % (int) Math.pow(26, i);
            }

            atk = new StringBuilder(ch);
            for(int i = 0; i<leftLen; i++){
                atk.append((char) ('a'+ary[i]));
            }
            System.out.println(atk);
        }
        if(atk.toString().equals(pass)){
            pin = true;
            System.out.println("Found " + atk);
        }
    }

    //use while loop as checking


    //supposed to be able to pass the input
    /*public void passes(String pass){
        String[] ray = new String[leftLen];
        for(int i=0; i<leftLen; i++){
            ray[i] = pass;
        }
    }*/
}