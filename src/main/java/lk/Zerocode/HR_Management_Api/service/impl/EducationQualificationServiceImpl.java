package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.EducationQualificationDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
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
}
