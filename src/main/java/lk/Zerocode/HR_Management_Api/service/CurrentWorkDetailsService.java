package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.CurrentWorkDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CurrentWorkDetailsService {
    void addCurrentWorkDetails(Long id, CurrentWorkDetailsDTO currentWorkDetailsDTO)throws EmployeeNotFoundException;

    void updateCurrentWorkDetails(@PathVariable Long eid, @PathVariable Long cid, @RequestBody CurrentWorkDetailsDTO currentWorkDetailsDTO);
}
