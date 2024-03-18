import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FibRunnable implements Runnable {
    private final int n;
    private final int[] results;
    private final Lock stopper;

    public FibRunnable(int n, int[] results, Lock lock) {
        this.n = n;
        this.results = results;
        this.stopper = lock;
    }

    @Override
    public void run() {
        if (n <= 1) {
            results[n] = n;
            return;
        }
        synchronized (stopper) {
            while (results[n - 1] == -1 || results[n - 2] == -1) {
                try {
                    stopper.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            results[n] = results[n - 1] + results[n - 2];
            stopper.notifyAll();
        }

//        if (n <= 0) {
//            result = 0;
//        } else if (n == 1) {
//            result = 1;
//        } else {
//
//            Thread t1 = new Thread(new FibRunnable(n - 1));
//            Thread t2 = new Thread(new FibRunnable(n - 2));
//
//            t1.start();
//            t2.;
//            try {
//                t1.join();
//                t2.join();
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted.");
//                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
//
//            result = t1. ;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of inputs: ");
        int s = sc.nextInt(); // User input: number of Fibonacci elements

        // not yet computed
        int[] results = new int[s];
        for (int i = 0; i < s; i++) {
            results[i] = -1;
        }

        // for syncing
        Lock lock = new ReentrantLock();

        //abli ang threads
        Thread[] fib = new Thread[s];
        for (int i = 0; i < s; i++) {
            fib[i] = new Thread(new FibRunnable(i, results, lock));
            fib[i].start();
        }

        try {
            fib[s - 1].join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        //printing
        System.out.println("Fibonacci sequence:");
        for (int i = 0; i < s; i++) {
            System.out.print(results[i] + " ");
        }

//        try {
//            int num = Integer.parseInt(args[0]); // Get user input for the number of elements
//            FibRunnable[] fibThreads = new FibRunnable[num];
//
//            // Create threads for each Fibonacci number
//            for (int i = 0; i < num; i++) {
//                fibThreads[i] = new FibRunnable(i);
//            }
//
//            // Start the last thread (for the nth Fibonacci number)
//            fibThreads[num - 1].run();
//
//            // Print the results
//            System.out.println("First " + num + " Fibonacci numbers:");
//            for (int i = 0; i < num; i++) {
//                System.out.print(fibThreads[i].getResult() + " ");
//            }
//        } catch (Exception e) {
//            System.out.println("Interrupted.");
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }

    }
}