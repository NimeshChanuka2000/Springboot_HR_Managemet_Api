package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.exception.QualificationNotFoundException;
import lk.Zerocode.HR_Management_Api.model.EducationQualification;
import lk.Zerocode.HR_Management_Api.model.Employee;
import lk.Zerocode.HR_Management_Api.repository.EducationQualificationRepository;
import lk.Zerocode.HR_Management_Api.repository.EmployeeRepository;
import lk.Zerocode.HR_Management_Api.service.EducationQualificationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EducationQualificationServiceImpl implements EducationQualificationService {

    private final EducationQualificationRepository qualificationRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addQualification(Long id, EducationQualificationDTO qualificationDTO)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

            Employee employee = employeeOptional.orElseThrow(
                    () -> new EmployeeNotFoundException("Employee not found with ID:"+ id)
            );
            EducationQualification educationQualification = modelMapper.map(qualificationDTO,EducationQualification.class);
            educationQualification.setEmployee(employee);

            qualificationRepository.save(educationQualification);

    }

    @Override
    public void updateQualification(Long eid, Long qid, EducationQualificationDTO educationQualificationDTO)throws EmployeeNotFoundException, QualificationNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(eid);
        Optional<EducationQualification> educationQualificationOptional = qualificationRepository.findById(qid);

        Employee employee = employeeOptional.orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID : " + eid)
        );
        EducationQualification updateEducationQualification = educationQualificationOptional.orElseThrow(
                () -> new QualificationNotFoundException("Invalid Qualification ID : " + qid)
        );

        updateEducationQualification.setMainQualification(educationQualificationDTO.getMainQualification());
        updateEducationQualification.setOtherQualification(educationQualificationDTO.getOtherQualification());

        qualificationRepository.save(updateEducationQualification);

    }
}
