package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;

public interface EducationQualificationService {

    void addQualification(Long id, EducationQualificationDTO qualificationDTO)throws EmployeeNotFoundException;
}
