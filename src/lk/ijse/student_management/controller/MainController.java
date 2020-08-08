package lk.ijse.student_management.controller;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
    public AnchorPane root;
    public Button btnCourse;
    public Button btnBatch;
    public Button btnregistration;
    public Label lblexisting;
    public Button btnStudent;
    public AnchorPane panelMain;
    Node node;

    public void btnCourse(ActionEvent actionEvent) {
        if (node != null) {
            panelMain.getChildren().remove(node);

        }

        try {
            node = FXMLLoader.load(getClass().getResource("/lk/ijse/student_management/view/course.fxml"));
            JFXFillTransition fXFillTransition = new JFXFillTransition();
            fXFillTransition.setDuration(Duration.millis(2000));
            panelMain.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnBatchOnAction(ActionEvent actionEvent) {
        if (node != null) {
            panelMain.getChildren().remove(node);

        }

        try {
            node = FXMLLoader.load(getClass().getResource("/lk/ijse/student_management/view/batch.fxml"));
            JFXFillTransition fXFillTransition = new JFXFillTransition();
            fXFillTransition.setDuration(Duration.millis(2000));
            panelMain.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnregistrationOnAction(ActionEvent actionEvent) {
        if (node != null) {
            panelMain.getChildren().remove(node);

        }

        try {
            node = FXMLLoader.load(getClass().getResource("/lk/ijse/student_management/view/registration.fxml"));
            JFXFillTransition fXFillTransition = new JFXFillTransition();
            fXFillTransition.setDuration(Duration.millis(2000));
            panelMain.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lblexistingOnAction(MouseEvent mouseEvent) {
        if (node != null) {
            panelMain.getChildren().remove(node);

        }

        try {
            node = FXMLLoader.load(getClass().getResource("/lk/ijse/student_management/view/course.fxml"));
            JFXFillTransition fXFillTransition = new JFXFillTransition();
            fXFillTransition.setDuration(Duration.millis(2000));
            panelMain.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnStudentOnAction(ActionEvent actionEvent) {
        if (node != null) {
            panelMain.getChildren().remove(node);

        }

        try {
            node = FXMLLoader.load(getClass().getResource("/lk/ijse/student_management/view/student.fxml"));
            JFXFillTransition fXFillTransition = new JFXFillTransition();
            fXFillTransition.setDuration(Duration.millis(2000));
            panelMain.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
