package lk.ijse.student_management.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.CourseBO;
import lk.ijse.student_management.util.CourseTM;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseController implements Initializable {
    public AnchorPane root;
    public Label lblcid;
    public TableView<CourseTM> tblcourse;
    public JFXTextField txtname;
    public JFXTextField txtduration;
    public JFXRadioButton rdofull;
    public JFXRadioButton rdopart;
    public JFXTextField txtfee;
    public JFXTextField txtdiscount;
    public JFXTextField txttax;
    public JFXTextField txtfull;
    public JFXTextField txtinstallment;
    public JFXTextField txtsearch;
    public JFXButton btnSave;
    public JFXButton btnCancel;
    private ToggleGroup toggleGroup;

    CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblcourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblcourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cname"));
        tblcourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ctype"));
        tblcourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblcourse.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cfee"));
        tblcourse.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dscfull"));
        tblcourse.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("dsctwice"));

        txtname.requestFocus();
        loadAllCourses();
        toggleGroup = new ToggleGroup();
        rdofull.setToggleGroup(toggleGroup);
        rdopart.setToggleGroup(toggleGroup);
        try {
            lblcid.setText(courseBO.getCourseId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblcourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                CourseTM selectedItem = tblcourse.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnSave.setText("Save");
                    return;
                }

                btnSave.setText("Update");
                btnSave.setDisable(false);
                lblcid.setText(selectedItem.getCid());
                txtname.setText(selectedItem.getCname());
                System.out.println(selectedItem.getCtype());
                if(selectedItem.getCtype().trim().equals("Full Time")){
                    rdofull.setSelected(true);
                    rdopart.setSelected(false);
                }else {
                    rdofull.setSelected(false);
                    rdopart.setSelected(true);
                }
                txtduration.setText(selectedItem.getDuration());
                txtfee.setText(selectedItem.getCfee()+"");
                txtdiscount.setText(selectedItem.getDiscount()+"");
                txttax.setText(selectedItem.getTax()+"");
                txtfull.setText(selectedItem.getDscfull()+"");
                txtinstallment.setText(selectedItem.getDsctwice()+"");


            }
        });

    }

    private void loadAllCourses() {
        try {
            tblcourse.getItems().clear();
            List<CourseTM> allCourseTMS = courseBO.getAllCourses();
            ObservableList<CourseTM> courseTMS = FXCollections.observableArrayList(allCourseTMS);
            tblcourse.setItems(courseTMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtnameOnAction(ActionEvent actionEvent) {
        txtduration.requestFocus();
    }

    public void txtdurationOnAction(ActionEvent actionEvent) {
        rdofull.requestFocus();
    }

    public void txtfeeOnAction(ActionEvent actionEvent) {
        txtdiscount.requestFocus();
    }

    public void txtdiscountOnAction(ActionEvent actionEvent) {
        txttax.requestFocus();
    }

    public void txttaxOnAction(ActionEvent actionEvent) {
        double discount = Double.parseDouble(txtdiscount.getText());
        double tax = Double.parseDouble(txttax.getText());
        double coursefee = Double.parseDouble(txtfee.getText());

        double fulldpayment = coursefee * (100 - discount) / 100;
        double fulltpayment = fulldpayment * (100 + tax) / 100 - fulldpayment;

        double fullpayment = fulldpayment + fulltpayment;
        double installment = coursefee / 2;

        txtfull.setText(Double.toString(fullpayment));
        txtinstallment.setText(Double.toString(installment));
    }

    public void txtsearchOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {

            if (txtname.getText().trim().length() == 0 || txtduration.getText().trim().length() == 0 || txtfee.getText().trim().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Cannot Proceed with Empty Fields!", ButtonType.OK);
                alert.show();
                return;
            }

            if (!txtfee.getText().matches("(\\-?\\d*\\.?\\d+)") || !txtfull.getText().matches("(\\-?\\d*\\.?\\d+)") || !txtinstallment.getText().matches("(\\-?\\d*\\.?\\d+)")||!txttax.getText().matches("(\\-?\\d*\\.?\\d+)")||!txtdiscount.getText().matches("(\\-?\\d*\\.?\\d+)")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Number Format!", ButtonType.OK);
                alert.show();
                return;
            }
            String cid = lblcid.getText();
            String name = txtname.getText();
            String duration = txtduration.getText();
            BigDecimal courseFee = new BigDecimal(txtfee.getText());
            BigDecimal discount = new BigDecimal(txtdiscount.getText());
            BigDecimal tax = new BigDecimal(txttax.getText());
            BigDecimal full = new BigDecimal(txtfull.getText());
            BigDecimal installment = new BigDecimal(txtinstallment.getText());
            String ctype = "";
            if (rdopart.isSelected()) {
                ctype = "Part Time";
            }

            if (rdofull.isSelected()) {
                ctype = "Full Time";
            }


            if (btnSave.getText().trim().equals("Save")) {

                boolean result = courseBO.saveCourse(new CourseTM(cid, name, ctype, duration, courseFee, discount, tax, full, installment));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Successfully Saved!!!", ButtonType.OK).show();
                    loadAllCourses();
                    tblcourse.refresh();
                    lblcid.setText(courseBO.getCourseId());
                    reset();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong, Failed to Save !!!", ButtonType.OK).show();
                }
            } else {

                boolean result = courseBO.updateCourse(new CourseTM(cid, name, ctype, duration, courseFee, discount, tax, full, installment));
                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Successfully Updated!!!", ButtonType.OK).show();
                    loadAllCourses();
                    tblcourse.refresh();
                    lblcid.setText(courseBO.getCourseId());
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

    public void rdofullOnAction(ActionEvent actionEvent) {
        txtfee.requestFocus();
    }

    public void rdopartOnAction(ActionEvent actionEvent) {
        txtfee.requestFocus();
    }

    private void reset() {
        txtname.setText("");
        txtduration.setText("");
        rdofull.setSelected(false);
        rdopart.setSelected(false);
        txtfee.setText("");
        txtdiscount.setText("");
        txttax.setText("");
        txtfull.setText("");
        txtinstallment.setText("");
        txtsearch.setText("");
        tblcourse.refresh();
        try {
            lblcid.setText(courseBO.getCourseId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
