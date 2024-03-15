package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.PreviousWorkHistoryDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;

public interface PreviousWorkHistoryService {
    void addPreviousWorkHistory(Long id, PreviousWorkHistoryDTO previousWorkHistoryDTO)throws EmployeeNotFoundException;
}
