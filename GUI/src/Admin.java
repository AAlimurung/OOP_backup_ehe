import javax.swing.*;
import java.io.*;
import java.util.Objects;

public class Admin extends JFrame{

    private JButton SelectFilesBtn;
    private JButton addActivityButton;
    private JPanel admin;
    private JPanel studentActs;
    private JButton CHECKACTIVITIESButton;
    private JRadioButton openInIDERadioButton;
    private JRadioButton compileAndRunRadioButton;
    private JRadioButton executablesRadioButton;
    private JPanel checkActs;
    private JPanel Functions;
    private JButton doTaskButton;
    private JTextField textField1;
    private JFileChooser activity;
    private File file;
    Runtime rt;
    File mainClass=null;
    String main;
    String all="";
    public Admin(){


        this.setContentPane(this.admin);
        this.setSize(700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.setVisible(true);
        this.checkActs.setVisible(false);
        doTaskButton.setVisible(false);
        studentActs.setVisible(false);



//ActionListeners
        SelectFilesBtn.addActionListener(e -> {
            doTaskButton.setVisible(true);
            activity=new JFileChooser();
            activity.setMultiSelectionEnabled(true);
            rt= Runtime.getRuntime();


            if(openInIDERadioButton.isSelected()){// if you want to open on IDE
                onIDE();
            }
            else if(compileAndRunRadioButton.isSelected()){
                try {
                    compileRun();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if(executablesRadioButton.isSelected()){
                executables();
            }
            else{
                JOptionPane.showMessageDialog(this,"Please select which kind of files do you want to open");
            }


        });

        CHECKACTIVITIESButton.addActionListener(e -> {
            checkActs.setVisible(true);
            Functions.setVisible(false);
        });

    }


///functions
//    public void addButton(File file) throws IOException {
//            JButton newBtn;
//            BufferedReader reader=new BufferedReader(new FileReader(file));
//            String path;
//            if((path=reader.readLine())!=null){
//                newBtn=new JButton(path);
//                newBtn.setBounds(50,100,95,30);
//                studentActs.add(newBtn);
//
//            }
//    }
    public void onIDE(){
        int i=0;
        if(activity.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File[] files = activity.getSelectedFiles();
            String java="java";
            while (files.length>i){
//                ProcessBuilder p= new ProcessBuilder("cmd.exe","/c","start"+ " /min"+" \"\" " +space);
//                  p.start();
                Runtime rt= Runtime.getRuntime();
                try {
                    String[] command={"cmd.exe","/c","start"+ " /min"+" \"\" " +"\""+files[i].getAbsolutePath()+"\""};
                    rt.exec(command);
                    i++;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    public void executables(){
        int i=0;
        if(activity.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File[] files = activity.getSelectedFiles();
            while (files.length>i){
//                ProcessBuilder p= new ProcessBuilder("cmd.exe","/c","start"+ " /min"+" \"\" " +space);
//                  p.start();
                Runtime rt= Runtime.getRuntime();
                try {
                    String[] command={"cmd.exe","/c","start"+ " /min"+" \"\" " +"\""+files[i].getAbsolutePath()+"\""};
                    rt.exec(command);
                    i++;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

    }
    public void compileRun() throws IOException {
        mainClass=null;//mo auto compile mn gud siya taga call maong e null nako ang mainClass na identifier/fileholder

       int indexOfMain=-166;//feel lng nako -166
        int i=0;
        //this will iterate to all files that were chosen and compile them
        if(activity.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File[] files = activity.getSelectedFiles();
            while (files.length>i) {
                String java=".java";
                int extensionIndex= files[i].getName().lastIndexOf('.');
                String extension=files[i].getName().substring(extensionIndex);
                System.out.println(extension);

                if(!Objects.equals(extension, java)){
                    try {
                        JOptionPane.showMessageDialog(this,"file is not a java source file");
                        throw new me("File is not Java");
                    } catch (me e) {
                        throw new RuntimeException(e);
                    }
                }
                BufferedReader reader = new BufferedReader(new FileReader(files[i]));
                while ((main = reader.readLine()) != null) {
                    main=main.trim();
                    System.out.println(main); //just prints the whole code without tail and head excess spaces. ge gamit rani nako pang debug if. pang check if mo read bajud sa tanan
                    if (main.startsWith("public static void main" )) {// given na ge papas na apil ang head excess space.
                                                                      // if the bufferedReader.readline() starts with the main tag
                                                                      //then it will save it as the main Class to run after it is compiled

                        mainClass=new File(files[i].getAbsolutePath());


                    }
                }
                all+=(" "+files[i].getName());
                i++;
            }

            i=0;
                try {
//                    +""+"\"cd "+files[0].getParent()+"\""
                    System.out.println("\"javac "+files[i].getName()+"\"");
                    String[] command={"cmd","/c","\"cd "+files[0].getParent()+"&javac "+all+"\""};
                    rt.exec(command);


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            if(mainClass!=null) {
                doTaskButton.setEnabled(true);//e enable and do task when mana ug compile
            }
        }
        else{
            return;//do nothing if not files are selected;
        }
        doTaskButton.addActionListener(e -> {//if mainclass is found. then you will be able to run it.
            if(mainClass!=null) {
                int l=mainClass.getName().length()-5;
                String[] command = {"cmd","/c","\"cd "+mainClass.getParent()+"&start cmd /k java "+mainClass.getName().substring(0,l)+"\""};
                try {
                    rt.exec(command);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"main not found");
            }



        });

    }



}
