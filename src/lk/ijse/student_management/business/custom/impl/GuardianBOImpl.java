package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.GuardianBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.GuardianDAO;
import lk.ijse.student_management.entity.Guardian;
import lk.ijse.student_management.util.GuardianTM;

public class GuardianBOImpl implements GuardianBO {

    GuardianDAO guardianDAO = DAOFactory.getInstance().getDAO(DAOTypes.GUARDIAN);

    @Override
    public String getGuardianId() throws Exception {
        String lastGuardianID = guardianDAO.getlastGuardianId();
        if (lastGuardianID == null) {
            return "G001";
        } else {
            int maxId = Integer.parseInt(lastGuardianID.replace("G", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "G00" + maxId;
            } else if (maxId < 100) {
                id = "G0" + maxId;
            } else {
                id = "G" + maxId;
            }
            return id;
        }
    }

    @Override
    public GuardianTM getguardian(String nic) throws Exception {
        Guardian guardian = guardianDAO.find(nic);
        if(guardian != null){
            return new GuardianTM(guardian.getGid(),guardian.getSdnic(),guardian.getGname(),guardian.getGaddress(),guardian.getGtel(),guardian.getGemail(),guardian.getDesignation(),guardian.getWorkplace());
        }
        return null;
    }
}
