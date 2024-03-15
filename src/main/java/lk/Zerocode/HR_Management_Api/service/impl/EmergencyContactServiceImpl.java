package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.EmergencyContactDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.model.EmergencyContact;
import lk.Zerocode.HR_Management_Api.model.Employee;
import lk.Zerocode.HR_Management_Api.repository.EmergencyContactRepository;
import lk.Zerocode.HR_Management_Api.repository.EmployeeRepository;
import lk.Zerocode.HR_Management_Api.service.EmergencyContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmergencyContactServiceImpl implements EmergencyContactService {

    private final EmergencyContactRepository contactRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public void addEmergencyContact(Long id, EmergencyContactDTO contactDTO)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
            Employee employee = employeeOptional.orElseThrow(
                    () -> new EmployeeNotFoundException("Employee not found with ID:"+ id)
            );
            EmergencyContact emergencyContact = modelMapper.map(contactDTO,EmergencyContact.class);
            emergencyContact.setEmployee(employee);

            contactRepository.save(emergencyContact);

    }


}
