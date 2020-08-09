package lk.ijse.student_management.controller;

import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.BatchBO;
import lk.ijse.student_management.business.custom.GuardianBO;
import lk.ijse.student_management.business.custom.RegistrationBO;
import lk.ijse.student_management.business.custom.StudentBO;
import lk.ijse.student_management.util.*;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    public AnchorPane registrationpane;
    public JFXTextField txtnic;
    public JFXTextField txtrfee;
    public JFXComboBox cmbbname;
    public JFXTextField txtname;
    public JFXTextField txtfullname;
    public JFXDatePicker dtpdob;
    public JFXTextField txtaddress;
    public JFXTextField txtemail;
    public JFXTextField txthome;
    public JFXTextField txtmobile;
    public JFXTextField txtschool;
    public JFXTextField txtuniversity;
    public JFXTextField txtpname;
    public JFXTextField txtpaddress;
    public JFXTextField txtpcontact;
    public JFXTextField txtpdesignation;
    public JFXTextField txtpworkingplace;
    public JFXTextField txtpemail;
    public JFXRadioButton rdomale;
    public JFXRadioButton rdofemail;
    public JFXTextField txtsearch;
    public JFXButton btnregister;
    public JFXButton btnCancel;
    public JFXCheckBox chkol;
    public JFXCheckBox chkal;
    public JFXCheckBox chkdiploma;
    public JFXCheckBox chkdegree;
    public JFXCheckBox chkmaster;
    public JFXCheckBox chkother;
    public Label lblrid;
    public Label lblgid;
    public TableView <RegistrationTM>tblregistration;
    public Label lblrdate;
    public Label lblbid;
    private ToggleGroup toggleGroup;

    RegistrationBO registrationBO = BOFactory.getInstance().getBO(BOTypes.REGISTRATION);
    StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
    GuardianBO guardianBO = BOFactory.getInstance().getBO(BOTypes.GUARDIAN);
    BatchBO batchBO = BOFactory.getInstance().getBO(BOTypes.BATCH);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblregistration.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("rid"));
        tblregistration.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bid"));
        tblregistration.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblregistration.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("rdate"));
        tblregistration.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("rfee"));

        try {
            lblgid.setText(guardianBO.getGuardianId());
            lblrid.setText(registrationBO.getregistrationId());
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            lblrdate.setText(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        toggleGroup = new ToggleGroup();
        rdomale.setToggleGroup(toggleGroup);
        rdofemail.setToggleGroup(toggleGroup);
        txtnic.requestFocus();
        loadAllregistrations();
        loadBatchCombo();

        tblregistration.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegistrationTM>() {
            @Override
            public void changed(ObservableValue<? extends RegistrationTM> observable, RegistrationTM oldValue, RegistrationTM newValue) {
                RegistrationTM selectedItem = tblregistration.getSelectionModel().getSelectedItem();

                if(selectedItem == null){
                    return;
                }

                try {
                    String nic = selectedItem.getNic();
                    String rid = selectedItem.getRid();

                    RegistrationTM registrationTM = registrationBO.get(rid);
                    lblrid.setText(registrationTM.getRid());
                    txtrfee.setText(registrationTM.getRfee().toString());
                    lblbid.setText(registrationTM.getBid());
                    BatchTM batchTM = batchBO.get(selectedItem.getBid());
                    cmbbname.getSelectionModel().select(batchTM.getBname());


                    StudentTM studentTM = studentBO.get(nic);
                    GuardianTM guardianTM = guardianBO.getguardian(nic);
                    txtnic.setText(studentTM.getNic());
                    txtname.setText(studentTM.getNamewithinitials());
                    txtfullname.setText(studentTM.getFullname());
                    dtpdob.setValue(studentTM.getDob().toLocalDate());
                    if (studentTM.getGender().trim().equals("Male")) {
                        rdomale.setSelected(true);
                    } else {
                        rdofemail.setSelected(true);
                    }
                    txtaddress.setText(studentTM.getAddress());
                    txtemail.setText(studentTM.getEmail());
                    txthome.setText(studentTM.getTelhome());
                    txtmobile.setText(studentTM.getTelmobile());
                    txtschool.setText(studentTM.getSchool());
                    txtuniversity.setText(studentTM.getUniversity());
                    String array[] = studentTM.getQualifications().split(",");
                    for (int i = 0; i < array.length; i++) {
                        switch (array[i]) {
                            case "Master":
                                chkmaster.setSelected(true);
                                break;
                            case "Degree":
                                chkdegree.setSelected(true);
                                break;
                            case "Diploma":
                                chkdiploma.setSelected(true);
                                break;
                            case "A/L":
                                chkal.setSelected(true);
                                break;
                            case "O/L":
                                chkol.setSelected(true);
                                break;
                            case "Other":
                                chkother.setSelected(true);
                                break;
                        }
                    }
                    lblgid.setText(guardianTM.getGid());
                    txtpname.setText(guardianTM.getGname());
                    txtpaddress.setText(guardianTM.getGaddress());
                    txtpcontact.setText(guardianTM.getGtel());
                    txtpdesignation.setText(guardianTM.getDesignation());
                    txtpworkingplace.setText(guardianTM.getWorkplace());
                    txtpemail.setText(guardianTM.getGemail());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void loadBatchCombo() {
        try {
            List<BatchTM> batchTMS = batchBO.getAllBatches();
            if (batchTMS != null) {
                ObservableList observableList = FXCollections.observableArrayList();
                for (BatchTM courseTM : batchTMS) {
                    observableList.add(courseTM.getBname());
                    cmbbname.setItems(observableList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAllregistrations() {
        try {
            tblregistration.getItems().clear();
            List<RegistrationTM> allRegistrationTMS = registrationBO.getAllRegistrations();
            ObservableList<RegistrationTM> registrationTMS = FXCollections.observableArrayList(allRegistrationTMS);
            tblregistration.setItems(registrationTMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtnicOnAction(ActionEvent actionEvent) {
        txtrfee.requestFocus();
    }

    public void txtrfeeOnAction(ActionEvent actionEvent) {
        cmbbname.requestFocus();
    }

    public void cmbbnameOnAction(ActionEvent actionEvent) {
        try {
        String bname = cmbbname.getSelectionModel().getSelectedItem().toString();
        BatchTM batchTM = batchBO.getbyName(bname);
        lblbid.setText(batchTM.getBid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtname.requestFocus();
    }

    public void txtnameOnAction(ActionEvent actionEvent) {
        txtfullname.requestFocus();
    }

    public void txtfullnameOnAction(ActionEvent actionEvent) {
        dtpdob.requestFocus();
    }

    public void dtpdobOnAction(ActionEvent actionEvent) {
        rdomale.requestFocus();
    }

    public void txtaddressOnAction(ActionEvent actionEvent) {
        txtemail.requestFocus();
    }

    public void txtemailOnAction(ActionEvent actionEvent) {
        txthome.requestFocus();
    }

    public void txthomeOnAction(ActionEvent actionEvent) {
        txtmobile.requestFocus();
    }

    public void txtmobileOnAction(ActionEvent actionEvent) {
        txtschool.requestFocus();
    }

    public void txtschoolOnAction(ActionEvent actionEvent) {
        txtuniversity.requestFocus();
    }

    public void txtuniversityOnAction(ActionEvent actionEvent) {
        chkol.requestFocus();
    }

    public void txtpnameOnAction(ActionEvent actionEvent) {
        txtpaddress.requestFocus();
    }

    public void txtpaddressOnAction(ActionEvent actionEvent) {
        txtpcontact.requestFocus();
    }

    public void txtpcontactOnAction(ActionEvent actionEvent) {
        txtpdesignation.requestFocus();
    }

    public void txtpdesignationOnAtion(ActionEvent actionEvent) {
        txtpworkingplace.requestFocus();
    }

    public void txtpworkingplaceOnAction(ActionEvent actionEvent) {
        txtpemail.requestFocus();
    }

    public void txtpemailOnAction(ActionEvent actionEvent) {
        btnregister.requestFocus();
    }

    public void txtsearchOnAction(ActionEvent actionEvent) {
    }

    public void btnregisterOnAction(ActionEvent actionEvent) {
        try {
            if (txtname.getText().trim().length() == 0 ||
                    txtrfee.getText().trim().length() == 0 ||
                    cmbbname.getValue()==null||
                    txtfullname.getText().trim().length() == 0 ||
                    dtpdob.getValue() == null ||
                    txtaddress.getText().trim().length() == 0 ||
                    txtemail.getText().trim().length() == 0 ||
                    txthome.getText().trim().length() == 0 ||
                    txtmobile.getText().trim().length() == 0 ||
                    txtschool.getText().trim().length() == 0 ||
                    txtuniversity.getText().trim().length() == 0 ||
                    txtpname.getText().trim().length() == 0 ||
                    txtpaddress.getText().trim().length() == 0 ||
                    txtpcontact.getText().trim().length() == 0 ||
                    txtpdesignation.getText().trim().length() == 0 ||
                    txtpworkingplace.getText().trim().length() == 0 ||
                    txtpemail.getText().trim().length() == 0 ) {
                new Alert(Alert.AlertType.ERROR, "Cannot Proceed with Empty Fields!", ButtonType.OK).show();
                return;
            }

            if(!txthome.getText().matches("\\d{3}[-]\\d{7}") || !txtmobile.getText().matches("\\d{3}[-]\\d{7}") || !txtpcontact.getText().matches("\\d{3}[-]\\d{7}")){
                new Alert(Alert.AlertType.ERROR, "Invalid Contact Number Format !", ButtonType.OK).show();
                return;
            }else if(!txtemail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$") || !txtpemail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                new Alert(Alert.AlertType.ERROR, "Invalid Email !", ButtonType.OK).show();
                return;
            }


            String gender = "";
            if (rdofemail.isSelected()) {
                gender = rdofemail.getText();
            }
            if (rdomale.isSelected()) {
                gender = rdomale.getText();
            }
            String qualifications = "";
            if (chkol.isSelected()) {
                qualifications += chkol.getText() + "/";
            }
            if (chkal.isSelected()) {
                qualifications += chkal.getText() + "/";
            }
            if (chkdiploma.isSelected()) {
                qualifications += chkdiploma.getText() + "/";
            }
            if (chkdegree.isSelected()) {
                qualifications += chkdegree.getText() + "/";
            }
            if (chkmaster.isSelected()) {
                qualifications += chkmaster.getText() + "/";
            }
            if (chkother.isSelected()) {
                qualifications += chkother.getText() + "/";
            }


            boolean result = registrationBO.register(new RegistrationTM(lblrid.getText(),lblbid.getText(),txtnic.getText(),Date.valueOf(lblrdate.getText()),new BigDecimal(txtrfee.getText())),
                    new StudentTM(txtnic.getText(),txtname.getText(),txtfullname.getText(),gender, Date.valueOf(dtpdob.getValue()),txtaddress.getText(),txthome.getText(),txtmobile.getText(),txtemail.getText(),txtschool.getText(),txtuniversity.getText(),qualifications),
                    new GuardianTM(lblgid.getText(),txtnic.getText(),txtpname.getText(),txtpaddress.getText(),txtpcontact.getText(),txtpemail.getText(),txtpdesignation.getText(),txtpworkingplace.getText()));

            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Successfully Registered!!!", ButtonType.OK).show();
                loadAllregistrations();
                tblregistration.refresh();
                reset();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong, Failed to Register !!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        reset();
    }

    private void reset(){
        lblgid.setText("");
        try {
            lblrid.setText(registrationBO.getregistrationId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        lblbid.setText("");
        lblrdate.setText("");
        cmbbname.getSelectionModel().clearSelection();
        txtrfee.setText("");
        txtnic.setText("");
        txtname.setText("");
        txtfullname.setText("");
        dtpdob.setValue(null);
        rdomale.setSelected(false);
        rdofemail.setSelected(false);
        txtaddress.setText("");
        txtemail.setText("");
        txthome.setText("");
        txtmobile.setText("");
        txtschool.setText("");
        txtuniversity.setText("");
        chkmaster.setSelected(false);
        chkdegree.setSelected(false);
        chkdiploma.setSelected(false);
        chkal.setSelected(false);
        chkol.setSelected(false);
        chkother.setSelected(false);
        lblgid.setText("");
        txtpname.setText("");
        txtpaddress.setText("");
        txtpcontact.setText("");
        txtpdesignation.setText("");
        txtpworkingplace.setText("");
        txtpemail.setText("");
    }

    public void txtsearchOnkeyReleased(KeyEvent keyEvent) {
    }
}
