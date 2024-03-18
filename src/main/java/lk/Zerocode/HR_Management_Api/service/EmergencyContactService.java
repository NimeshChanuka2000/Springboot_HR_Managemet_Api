package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.EmergencyContactDTO;
import lk.Zerocode.HR_Management_Api.exception.ContactNotFoundException;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmergencyContactService {
    void addEmergencyContact(Long id, EmergencyContactDTO contactDTO)throws EmployeeNotFoundException;

    void updateEmergencyContact(Long eid,Long cid, @RequestBody EmergencyContactDTO emergencyContactDTO)throws EmployeeNotFoundException, ContactNotFoundException;
}
