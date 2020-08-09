package lk.ijse.student_management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.BatchBO;
import lk.ijse.student_management.business.custom.CourseBO;
import lk.ijse.student_management.util.BatchTM;
import lk.ijse.student_management.util.CourseTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblbatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblbatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bname"));
        tblbatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblbatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cname"));
        tblbatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startdate"));

        txtname.requestFocus();
        loadAllBatches();
        loadBatchCombo();
        try {
            lblbid.setText(batchBO.getBatchId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblbatch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BatchTM>() {
            @Override
            public void changed(ObservableValue<? extends BatchTM> observable, BatchTM oldValue, BatchTM newValue) {
                BatchTM selectedItem = tblbatch.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnSave.setText("Save");
                    return;
                }

                btnSave.setText("Update");
                btnSave.setDisable(false);
                lblbid.setText(selectedItem.getBid());
                txtname.setText(selectedItem.getBname());
                lblcid.setText(selectedItem.getCid());
                cmbCourseName.getSelectionModel().select(selectedItem.getCname());
                dtpstartDate.setValue(selectedItem.getStartdate().toLocalDate());

            }
        });

    }

    private void loadBatchCombo() {
        try {
            List<CourseTM> courseTMS = courseBO.getAllCourses();
            if (courseTMS != null) {
                ObservableList observableList = FXCollections.observableArrayList();
                for (CourseTM courseTM : courseTMS) {
                    observableList.add(courseTM.getCname());
                    cmbCourseName.setItems(observableList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAllBatches() {
        try {
            tblbatch.getItems().clear();
            List<BatchTM> allBatchTMS = batchBO.getAllBatches();
            ObservableList<BatchTM> batchTMS = FXCollections.observableArrayList(allBatchTMS);
            tblbatch.setItems(batchTMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtnameOnAction(ActionEvent actionEvent) {
        cmbCourseName.requestFocus();
    }

    public void txtsearchOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        try {
            if (txtname.getText().trim().length() == 0 || cmbCourseName.getSelectionModel().getSelectedItem() == null || dtpstartDate.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Cannot Proceed with Empty Fields!", ButtonType.OK);
                alert.show();
                return;
            }

            String bid = lblbid.getText();
            String bname = txtname.getText();
            String cid = lblcid.getText();
            String cname = cmbCourseName.getSelectionModel().getSelectedItem().toString();
            Date date = Date.valueOf(dtpstartDate.getValue());

            if(btnSave.getText().trim().equals("Save")){
                boolean result = batchBO.saveBatch(new BatchTM(bid,bname,cid,cname,date));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Successfully Saved!!!", ButtonType.OK).show();
                    loadAllBatches();
                    tblbatch.refresh();
                    lblcid.setText(batchBO.getBatchId());
                    reset();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong, Failed to Save !!!", ButtonType.OK).show();
                }
            }else {
                boolean result = batchBO.updateBatch(new BatchTM(bid,bname,cid,cname,date));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Successfully Updated!!!", ButtonType.OK).show();
                    loadAllBatches();
                    tblbatch.refresh();
                    lblcid.setText(batchBO.getBatchId());
                    reset();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong, Failed to Update !!!", ButtonType.OK).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        reset();
    }

    public void cmbCourseNameOnAction(ActionEvent actionEvent) {
        String cname = cmbCourseName.getSelectionModel().getSelectedItem().toString();
        if(cname==null){
            return;
        }
        try {
            if (cname != null) {
                CourseTM courseTM = courseBO.getbyName(cname);
                if (courseTM != null) {
                    lblcid.setText(courseTM.getCid());
                    dtpstartDate.requestFocus();
                } else {
                    System.out.println("null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        try {
            txtname.setText("");
            dtpstartDate.setValue(null);
            lblbid.setText(batchBO.getBatchId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
