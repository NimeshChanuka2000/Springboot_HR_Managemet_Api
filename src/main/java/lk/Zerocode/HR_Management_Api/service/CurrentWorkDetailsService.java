package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.CurrentWorkDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;

public interface CurrentWorkDetailsService {
    void addCurrentWorkDetails(Long id, CurrentWorkDetailsDTO currentWorkDetailsDTO)throws EmployeeNotFoundException;
}
