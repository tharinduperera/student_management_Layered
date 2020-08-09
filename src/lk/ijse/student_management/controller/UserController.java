package lk.ijse.student_management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.UserBO;
import lk.ijse.student_management.util.UserTM;

public class UserController {
    public AnchorPane root;
    public JFXTextField txtusername;
    public JFXPasswordField txtpassword;
    public JFXButton btnLogin;

    UserBO userBO = BOFactory.getInstance().getBO(BOTypes.USER);

    public void txtusernameOnAction(ActionEvent actionEvent) {
        txtpassword.requestFocus();
    }

    public void txtpasswordOnAction(ActionEvent actionEvent) {
        btnLogin.requestFocus();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String username = txtusername.getText();
        String password = txtpassword.getText();

        try {
            boolean result = userBO.login(new UserTM(username,password));
            if (result){
                Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/student_management/view/main.fxml"));
                Scene mainScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(mainScene);
                primaryStage.centerOnScreen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
