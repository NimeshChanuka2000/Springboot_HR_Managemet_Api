package lk.Zerocode.HR_Management_Api.service;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.exception.QualificationNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface EducationQualificationService {

    void addQualification(Long id, EducationQualificationDTO qualificationDTO)throws EmployeeNotFoundException;

    void updateQualification(@PathVariable Long eid, @PathVariable Long qid, @RequestBody EducationQualificationDTO educationQualificationDTO)throws EmployeeNotFoundException, QualificationNotFoundException;
}
