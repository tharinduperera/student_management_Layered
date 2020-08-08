package lk.ijse.student_management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.BatchBO;
import lk.ijse.student_management.util.BatchTM;

import java.net.URL;
import java.util.ResourceBundle;

public class BatchController implements Initializable {
    public AnchorPane root;
    public Label lblbid;
    public TableView<BatchTM> tblbatch;
    public JFXTextField txtname;
    public JFXTextField txtsearch;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    public JFXDatePicker dtpstartDate;
    public JFXComboBox cmbCourseName;
    public Label lblcid;

    BatchBO batchBO = BOFactory.getInstance().getBO(BOTypes.BATCH);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblbatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblbatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bname"));
        tblbatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblbatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cname"));
        tblbatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startdate"));

        txtname.requestFocus();

    }

    public void txtnameOnAction(ActionEvent actionEvent) {
    }

    public void txtsearchOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }


}
