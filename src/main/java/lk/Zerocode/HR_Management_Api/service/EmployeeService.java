package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.BasicDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {

    void addEmployee(BasicDetailsDTO basicDetailsDTO);

    ResponseEntity<List<BasicDetailsDTO>> getSoftwareEngineer();

    void getNotSoftwareEngineer();

    ResponseEntity<BasicDetailsDTO> getEmployeeDetails(Long id)throws EmployeeNotFoundException;

    void updateEmployeeDetails(Long id,BasicDetailsDTO basicDetailsDTO)throws EmployeeNotFoundException;

    void deleteEmployee(@PathVariable Long id)throws EmployeeNotFoundException;

}
