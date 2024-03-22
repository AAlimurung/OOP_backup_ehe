import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Student extends JFrame{

    private JPanel Jpanel;
    private JButton chooseFile;
    private JButton Loc;
    private JTextArea fileSelected;
    private JTextField textField2;
    private JButton submitButton;
    private JComboBox comboBox1;
    private JCheckBox checkBox1;
    private JButton javaButton;
    private JButton pythonButton;

    private File[] file;

    private File target;
    JFileChooser fileChooser;

    JFileChooser fileChooser2;
    String path;
    String dir=null;


    public Student(){


        this.setContentPane(this.Jpanel);
        this.setSize(700,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.setVisible(true);
        target=new File("C:\\Users\\janed\\Documents\\UGENGGENG");//to set as default
        path=target.getAbsolutePath();
        textField2.setText("C:\\Users\\janed\\Documents\\UGENGGENG|| [COMMON]");//to display default path

        chooseFile.addActionListener(e -> {//this opens the Jfilechooser ato choose which file or folder you want to submit
             fileChooser=new JFileChooser();
             fileChooser.setMultiSelectionEnabled(true);
             fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){//if the user selects a file.

               if(fileChooser.getSelectedFile().isDirectory()) {
                   file = fileChooser.getSelectedFile().listFiles();
               }
               else{
                   file=fileChooser.getSelectedFiles();
               }
            }
            else{
                return;
            }
            for(int i=0;i< file.length;i++){
                ///                to append           + new selected files      + new line
                fileSelected.setText(fileSelected.getText()+file[i].getAbsolutePath()+"\n");
            }
        });

        Loc.addActionListener(e -> {// to choose a path
            fileChooser2=new JFileChooser();
            fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// filter to folders only

            if(fileChooser2.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                fileChooser2.setCurrentDirectory(new java.io.File("."));
                target=new File(fileChooser2.getSelectedFile().getAbsolutePath());
            }
            else{//do nothing
                return;
            }
            textField2.setText(target.getAbsolutePath());//Set the chosen path to be the target location/ the location you want to paste the files/folder
            path=target.getAbsolutePath();
        });

        submitButton.addActionListener(e ->{
            if(file==null){
                JOptionPane.showMessageDialog(this,"cannot");
                return;
            }
                int index=1;
                try {
                    for(int i=0;i<file.length;i++) {//copy the file and paste to the selected location
                        target = new File(path + "\\" + file[i].getName());
                        Files.copy(file[i].toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        index++;
                    }
                    JOptionPane.showMessageDialog(this, "Succesful");//if nothing is thrown by the loop
                }catch (IOException ex) {

                    JOptionPane.showMessageDialog(this, "Unsuccesful from"+file[index-1]+"File no."+index);
                    ex.printStackTrace();
                }
        });

        javaButton.addActionListener(e -> {// to create a codeEditor for java
            String p=setPath();
            if(p!=null) {
                new Java(p);
            }
            else{
                System.out.println("did not input Project name");
            }
        });

        pythonButton.addActionListener(e -> {//to create code editor for python
            String p=setPath();
            if(p!=null) {
                new Python(p);
            }
            else{
                System.out.println("did not input Project name");
            }
        });
    }

    public String setPath(){        //this will return a path with the new folder created
        JOptionPane.showMessageDialog(this,"Choose working directory");
        JFileChooser path=new JFileChooser();
        String folder=null;
        path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(path.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            dir= path.getSelectedFile().getAbsolutePath();
            String newFolder;

            newFolder = JOptionPane.showInputDialog(this, "Input Project name");
            Boolean bool = new File(dir + "\\" + newFolder).mkdirs();
            folder=dir+"\\"+newFolder;
        }
        return folder;
    }



        /*
        features na ganhan ninyo e add other than design
         *




         Language to add
         *c++
         *c








         */

}
