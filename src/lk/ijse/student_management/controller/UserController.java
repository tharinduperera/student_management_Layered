package lk.ijse.student_management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class UserController {
    public AnchorPane root;
    public JFXTextField txtusername;
    public JFXPasswordField txtpassword;
    public JFXButton btnLogin;

    public void txtusernameOnAction(ActionEvent actionEvent) {
        txtpassword.requestFocus();
    }

    public void txtpasswordOnAction(ActionEvent actionEvent) {
        btnLogin.requestFocus();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
    }
}
