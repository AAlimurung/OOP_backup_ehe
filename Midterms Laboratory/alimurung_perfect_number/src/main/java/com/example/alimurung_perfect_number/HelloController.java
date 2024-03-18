package com.example.alimurung_perfect_number;

import javafx.fxml.FXML;
import javafx.scene.LightBase;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane anchor_main;
    @FXML
    private Label Input_num;
    @FXML
    private Label Input_thread;
    @FXML
    private Button btnOutput;
    @FXML
    private TextField txtFld_inputNum;
    @FXML
    private TextField txtFld_inputThread;
    @FXML
    private HBox hBoxProgress;
    int n, threads, s = 0;
    ArrayList<Integer> pNums;
    static int index, minimum;
    @FXML
    protected void onBtnOutputClick() {
        n = Integer.parseInt(txtFld_inputNum.getText());
        threads = Integer.parseInt(txtFld_inputThread.getText());
        pNums = new ArrayList<>(n);
//        boolean isCounting = false;
        //Thread cnt = new Thread();
//        for(int i = 1; i < n; i++){
//            for(int j = 1; j<=n-1; j++){
//                if(n%j==0){
//                    s = s+j;
//                }
//            }
//            if(s == n){
//                System.out.println(s + " is a perfect number");
//            }
//            //System.out.println(s);
//            s = 0;
//        }

        //progression
        List<ProgressIndicator> progresses = new ArrayList<>();
        for(int i=0; i<threads; i++){
            progresses.add(new ProgressIndicator());

            hBoxProgress.getChildren().add(progresses.get(i));
        }

        Thread [] thrd = new Thread[threads];
        Random rand = new Random();

        for(int k = 0; k<threads; k++){
            index = k;
            int max = (k+1)*10;
            int min = k*10+1;

            thrd[k] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int randomNum = rand.nextInt(max)+minimum;
                    if(index==0){
                        randomNum = n;
                    }
                    for(int number=min; number <= randomNum; number++) {
                        s = 0;
                        for (int i = 1; i <= number/2; i++) {
                            if (number%i==0){
                                s += i;
                            }
                        }
                        //Checking how hapit na sila mahuman hahhahaa
                        double progress= calculateProgress(number,randomNum);
                        progresses.get(index).setProgress(progress);
                        if (s==number){
                            System.out.println("It is a perfect number " + s);
                        }
                    }
                    minimum = randomNum+1;
                }
            });

        }
        //Starting the threads all at once
        for(Thread t: thrd){
            t.start();
        }
    }
        public double calculateProgress(int number, int randomNum){
            return number/randomNum;
        }
    }
