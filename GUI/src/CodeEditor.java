import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class CodeEditor extends JFrame{

    private JButton saveButton;
    private JButton Compile;
    private JTextArea codeArea;
    private JPanel codeEditor;
    private JButton runButton;
    private JButton Main;
    private JButton addFileBtn;
    private JPanel topBar;
    private JPanel codeAreaPanel;
    private String path=null;//folder directory
    private String fileName=null;
    File file;
    int fileCountBtn=0;//count of file button that is visible
    ArrayList<JTextArea> txt;// all text area for all file button
    ArrayList<JButton> btnList;
    String extension;
    private Runtime rt;


    //constructor
    public CodeEditor(String passedPath,String extension){
        this.extension=extension;

        boolean bool;
        this.path=passedPath;
        rt= Runtime.getRuntime();
        btnList=new ArrayList<>();
        Main.setText("Main"+extension);
        btnList.add(Main);
        txt=new ArrayList<>();
        codeArea.setTabSize(4);
        txt.add(codeArea);

        if(extension==".py"){//hide compile button kay you dont have to manually compile python files when running
            runButton.setText("Compile and Run");
            Compile.setVisible(false);
        }
        setContentPane(codeEditor);
        this.setSize(500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setUndecorated(true);
        this.setVisible(true);




        //for saving txtarea as a java file
        saveButton.addActionListener(e -> {//to save/update the latest textarea as files

            try {
                for (JTextArea jta:txt) {
                    String name = btnList.get(txt.indexOf(jta)).getText();
                    file = new File(path + "\\" + name);

                    FileWriter fileWriter = new FileWriter(file);
                    jta.write(fileWriter);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,"Failed to save");
            }
        });
        //for compiling
        Compile.addActionListener(e -> {
                for (JTextArea jta : txt) {
                    String name = btnList.get(txt.indexOf(jta)).getText();

                    String[] command = {"cmd", "/c", "\"cd " + path + "&javac " + name + "\""};//cmd command
                    try {
                        rt.exec(command);
                        System.out.println("Compiled");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            });
        //for running
        runButton.addActionListener(e -> {

            String main;
            try {
                if(extension==".java"){//for java, traverse to all, find the main, and run
                    for (JTextArea jta:txt) {
                        String fname = btnList.get(txt.indexOf(jta)).getText();
                        BufferedReader reader= new BufferedReader(new FileReader(new File(path+"\\"+fname)));

                        while ((main = reader.readLine()) != null) {
                            main=main.trim();
                            System.out.println(main);
                            if (main.startsWith("public static void main" )) {
                                String className = btnList.get(txt.indexOf(jta)).getText().substring(0, btnList.get(txt.indexOf(jta)).getText().length() - 5);
                                System.out.println(className);
                                String [] command2 = {"cmd", "/c", "\"cd " + this.path + "&start cmd /k java " + className + "\""};//run command
                                rt.exec(command2);
                                return;
                            }
                        }
                    }
                    //main not found
                    JOptionPane.showMessageDialog(this,"Main not Found");
                }

                if(extension==".py"){//for python, same,
                    for (JTextArea jta:txt) {
                        String fname = btnList.get(txt.indexOf(jta)).getText();
                        BufferedReader reader= new BufferedReader(new FileReader(new File(path+"\\"+fname)));

                        while ((main = reader.readLine()) != null) {
                            main = main.trim();
                            System.out.println(main);
                        }

                                String className = btnList.get(txt.indexOf(jta)).getText().substring(0, btnList.get(txt.indexOf(jta)).getText().length() - 3);
                                System.out.println(className);
                                if(jta.isVisible()) {
                                    String[] command2 = {"cmd", "/c", "\"cd " + this.path + "&start cmd /k Python " + fname + "\""};
                                    rt.exec(command2);
                                    return;
                                }


                    }

                }
            } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


        });
        //add a new File to the same path and open in code editor
        addFileBtn.addActionListener(e -> {

            String newfileName = JOptionPane.showInputDialog(this,"Enter File name");
            if(newfileName.isEmpty()){
                JOptionPane.showMessageDialog(this,"File must have a name");

                return;
            }

            if(fileCountBtn==5){
                JOptionPane.showMessageDialog(this,"Max reached");
                return;
            }



            JTextArea txtt=new JTextArea();
            txtt.setTabSize(4);
            if(extension==".java") {
                txtt.setText("\n\n\n" + "public class " + newfileName + "{\n" +
                        "\n" +
                        "}");
            }
            //else no name needed
            this.txt.add(txtt);
            for (JTextArea tE:txt
            ) {
                tE.setVisible(false);

            }

            txtt.setVisible(true);

            codeAreaPanel.add(txtt,BorderLayout.CENTER);
            codeAreaPanel.validate();


            JButton F= new JButton(newfileName+extension);



            F.addActionListener(e1 -> {
                for (JTextArea tE:txt
                ) {
                    tE.setVisible(false);

                }

                txtt.setVisible(true);
            });
            this.btnList.add(F);
            topBar.add(F);


            topBar.validate();
            fileCountBtn++;


        });
        // which textArea to show for Initial
        Main.addActionListener(e -> {
            for (JTextArea tE:txt
            ) {
                tE.setVisible(false);

            }

            codeArea.setVisible(true);

        });


    }


}
