package midterm_prac;

public class Fibonacci {
    int n1;
//    int n2;
    private Thread[] threads;
    long[] res;

    public Fibonacci(int n1){
        this.n1 = n1;
//        this.n2 = n2;
        threads = new Thread[n1];
        res = new long[n1];
    }

    public void calculate(){
        for(int i=0; i<n1; i++){
            FibonacciCalc calc = new FibonacciCalc(i);
            threads[i] = new Thread(calc);
        }
    }
}
