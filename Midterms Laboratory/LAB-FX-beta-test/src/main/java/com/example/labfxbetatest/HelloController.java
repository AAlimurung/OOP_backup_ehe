package com.example.labfxbetatest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    AnchorPane paneMain;

    @FXML
    GridPane paneLogin;

    @FXML
    VBox paneLogout;

    @FXML
    AnchorPane paneWelcomeMain;

    @FXML
    TextField txtFieldUsername;

    @FXML
    PasswordField psFieldPassword;
    @FXML
    Button btnToggle;

    @FXML
    Button btnNightmode;

//    @FXML
//    ColorPicker cpPicker;
    @FXML
    protected void onLoginButtonClick() throws IOException {
        File file = new File("Z:\\L14X15W28\\LAB-FX-beta-test\\src\\main\\resources\\data.txt");
        BufferedReader bfr = new BufferedReader(new FileReader(file));
        String input;
//           try{
               while ((input = bfr.readLine())!=null){
                   if(input.equals(txtFieldUsername.getText())){
                       System.out.println("Match found");
                       if(bfr.readLine().equals(psFieldPassword.getText())){
                           System.out.println("Logged In");
                           Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
                           Scene scene = new Scene(root, 460, 380);
                           paneMain.getScene().getStylesheets().add
                                   (HelloApplication.class.getResource("hello.css").toExternalForm());

                           paneMain.getChildren().remove(paneLogin);
                           paneMain.getChildren().add(root);
                       }
                   }
             }
//           } catch (IOException e){
//               e.printStackTrace();
//           }

//           PasswordField txtFieldPassword = (PasswordField) new TextField();
//           btnToggle.setOnAction(new EventHandler<ActionEvent>() {
//               @Override
//               public void handle(ActionEvent actionEvent) {
//                    txtFieldPassword.setText(psFieldPassword.getText());
//               }
//           });
    }

    @FXML
    protected void onLogoutButtonClick() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        try{
//            BufferedWriter bfw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
//            bfw.write("#paneWelcomeMain{ -fx-background-image: url(\"bg-pink.jpg\"); }");
//            bfw.newLine();
//            bfw.write("#cpPicker { -fx-background-color: #" + cpPicker.getValue().toString().substring(2, 8) + ";}");
//            bfw.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        paneWelcomeMain.getChildren().remove(paneLogout);
        paneWelcomeMain.getChildren().add(root);
    }

    protected void onBtnNightmodeClick() throws IOException{

    }
}