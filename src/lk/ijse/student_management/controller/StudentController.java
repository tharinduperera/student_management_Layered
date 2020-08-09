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
import javafx.scene.layout.AnchorPane;
import lk.ijse.student_management.business.BOFactory;
import lk.ijse.student_management.business.BOTypes;
import lk.ijse.student_management.business.custom.GuardianBO;
import lk.ijse.student_management.business.custom.StudentBO;
import lk.ijse.student_management.util.BatchTM;
import lk.ijse.student_management.util.GuardianTM;
import lk.ijse.student_management.util.StudentTM;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public AnchorPane studentpane;
    public TableView<StudentTM> tblStudent;
    public JFXTextField txtnic;
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
    public JFXButton btnUpdate;
    public JFXButton btnCancel;
    public Label lblgid;
    public JFXCheckBox chkol;
    public JFXCheckBox chkal;
    public JFXCheckBox chkdiploma;
    public JFXCheckBox chkdegree;
    public JFXCheckBox chkmaster;
    public JFXCheckBox chkother;
    private ToggleGroup toggleGroup;

    StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
    GuardianBO guardianBO = BOFactory.getInstance().getBO(BOTypes.GUARDIAN);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("namewithinitial"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("telhome"));
        tblStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("telmobile"));
        tblStudent.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblStudent.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("school"));

        toggleGroup = new ToggleGroup();
        rdomale.setToggleGroup(toggleGroup);
        rdofemail.setToggleGroup(toggleGroup);
        txtsearch.requestFocus();
        loadAllStudents();

        tblStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentTM>() {
            @Override
            public void changed(ObservableValue<? extends StudentTM> observable, StudentTM oldValue, StudentTM newValue) {
                try {
                    StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();

                    if (selectedItem == null) {
                        return;
                    }

                    String nic = selectedItem.getNic();

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
                txtname.requestFocus();
            }
        });

    }

    private void loadAllStudents() {
        try {
            tblStudent.getItems().clear();
            List<StudentTM> allstudentTMS = studentBO.getAllStudentTable();
            ObservableList<StudentTM> studentTMS = FXCollections.observableArrayList(allstudentTMS);
            tblStudent.setItems(studentTMS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtnicOnAction(ActionEvent actionEvent) {
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
        btnUpdate.requestFocus();
    }

    public void txtsearchOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            if (txtname.getText().trim().length() == 0 ||
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
            if (rdomale.isSelected()) {
                gender = rdomale.getText();
            }
            if (rdofemail.isSelected()) {
                gender = rdofemail.getText();
            }
            String qualifications = "";
            if (chkol.isSelected()) {
                qualifications = chkol.getText() + "";
            }
            if (chkal.isSelected()) {
                qualifications = chkal.getText();
            }
            if (chkdiploma.isSelected()) {
                qualifications = chkdiploma.getText();
            }
            if (chkdegree.isSelected()) {
                qualifications = chkdegree.getText();
            }
            if (chkmaster.isSelected()) {
                qualifications = chkmaster.getText();
            }
            if (chkother.isSelected()) {
                qualifications = chkother.getText();
            }

            boolean result = studentBO.updateCourse(new StudentTM(txtnic.getText(),txtname.getText(),txtfullname.getText(),gender, Date.valueOf(dtpdob.getValue()),txtaddress.getText(),txthome.getText(),txtmobile.getText(),txtemail.getText(),txtschool.getText(),txtuniversity.getText(),qualifications),
                    new GuardianTM(lblgid.getText(),txtnic.getText(),txtpname.getText(),txtpaddress.getText(),txtpcontact.getText(),txtpemail.getText(),txtpdesignation.getText(),txtpworkingplace.getText()));

            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Successfully Updated!!!", ButtonType.OK).show();
                loadAllStudents();
                tblStudent.refresh();
                reset();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong, Failed to Update !!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        reset();
    }

    public void rdomaleOnAction(ActionEvent actionEvent) {
        txtaddress.requestFocus();
    }

    public void rdofemailOnAction(ActionEvent actionEvent) {
        txtaddress.requestFocus();
    }

    private void reset(){
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
}
