package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private final EducationQualificationService qualificationService;

    @PostMapping(value = "/employee/{id}/qualifications",headers = ("version=v1"))
    public void addQualification(@PathVariable Long id, @RequestBody EducationQualificationDTO qualificationDTO)throws EmployeeNotFoundException {
        qualificationService.addQualification(id, qualificationDTO);
    }
}
