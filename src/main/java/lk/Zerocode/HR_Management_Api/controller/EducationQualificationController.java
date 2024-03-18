package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.exception.QualificationNotFoundException;
import lk.Zerocode.HR_Management_Api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EducationQualificationController {

    private final EducationQualificationService qualificationService;

    @PostMapping(value = "/employee/{id}/qualifications",headers = ("version=v1"))
    public void addQualification(@PathVariable Long id, @RequestBody EducationQualificationDTO qualificationDTO)throws EmployeeNotFoundException {
        qualificationService.addQualification(id, qualificationDTO);
    }
    @PutMapping("/employee/{eid}/qualification/{qid}/update")
    public void updateQualification(@PathVariable Long eid,@PathVariable Long qid,@RequestBody EducationQualificationDTO educationQualificationDTO)throws EmployeeNotFoundException, QualificationNotFoundException {
        qualificationService.updateQualification(eid, qid, educationQualificationDTO);
    }
}
