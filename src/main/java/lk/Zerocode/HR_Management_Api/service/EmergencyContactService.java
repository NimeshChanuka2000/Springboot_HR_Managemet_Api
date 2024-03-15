package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.EmergencyContactDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;

public interface EmergencyContactService {
    void addEmergencyContact(Long id, EmergencyContactDTO contactDTO)throws EmployeeNotFoundException;
}
