import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;

public class LogIn extends JFrame {
    private JTextField userName;
    private JPasswordField password;
    private JButton logInButton;
    private JButton registerButton;
    private JPanel Login;
    private JButton exitButton;
    private JButton userBut;
    private String s;
    private int ctr =0;
    private FileReader fileReader;
    private BufferedReader reader;
    private BufferedReader passwordR;
    private boolean aStudent=true;


    public LogIn() {

        this.setContentPane(this.Login);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        this.setVisible(true);


        //LogIn button
        logInButton.addActionListener(e -> {
                afterLogIn();

        });

        //exit button action listener
        exitButton.addActionListener(e -> System.exit(0));

        //para ig enter mo ditso ug enter. para di na need mo press sa log in button if mo log in
        password.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    // your logic here
                    //wani ge gamit
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_ENTER) {
                        //if enter button is pressed then call afterLogin method
                        afterLogIn();
                        System.out.println("ENTER PRESSED");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // your logic here\
                    //wani ge gamit
                }
            });



        //User or Admin button
        userBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aStudent==true){
                    userBut.setText("Admin");
                    aStudent=false;
                }
                else{
                    userBut.setText("Student");
                    aStudent=true;
                }

            }
        });
    }

    //afterLogIn(); make instances of admin or student if given inputs for username and password is valid
    public void afterLogIn(){
        try {
            fileReader= new FileReader("C:\\Users\\janed\\Documents\\CodeEditor\\src\\IDs.txt");//ilisi full path
            reader=new BufferedReader(fileReader);
//            passwordR=new BufferedReader(reader);

            while((s=reader.readLine())!=null){
                String pass= reader.readLine();
                String admin=reader.readLine();

                if(Objects.equals(s, userName.getText())){

                    if(Objects.equals(pass, new String(password.getPassword()))){

                        if(aStudent==false){
                            if(Objects.equals(admin, "0")){
                                new Admin();
                                this.setVisible(false);
                                System.out.println("here as admin");
                                ctr=1;
                                break;
                            }
                        }
                        else{
                            if(Objects.equals(admin, "1")) {
                                ctr = 1;

                                System.out.println("here as student");
                                new Student();
                                this.setVisible(false);
                                break;
                            }
                        }
                    }
                }
            }
            if(ctr==0){
                JOptionPane.showMessageDialog(this,"User not found");
            }
        }  catch (FileNotFoundException k) {
            //if file is not found
            System.out.println("Asdasd");
        } catch (IOException e) {
            //generic for filenotfoun. Filenotfound is needed to specify it
            throw new RuntimeException(e);
        }

    }


}
