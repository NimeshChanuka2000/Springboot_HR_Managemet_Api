package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.CurrentWorkDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.model.CurrentWorkDetails;
import lk.Zerocode.HR_Management_Api.model.Employee;
import lk.Zerocode.HR_Management_Api.repository.CurrentWorkDetailsRepository;
import lk.Zerocode.HR_Management_Api.repository.EmployeeRepository;
import lk.Zerocode.HR_Management_Api.service.CurrentWorkDetailsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrentWorkDetailsServiceImpl implements CurrentWorkDetailsService {

    private final CurrentWorkDetailsRepository currentWorkDetailsRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addCurrentWorkDetails(Long id, CurrentWorkDetailsDTO currentWorkDetailsDTO)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
            Employee employee = employeeOptional.orElseThrow(
                    () -> new EmployeeNotFoundException("Employee Not Found with ID :" + id)
            );
            CurrentWorkDetails currentWorkDetails = modelMapper.map(currentWorkDetailsDTO,CurrentWorkDetails.class);
            currentWorkDetails.setEmployee(employee);

            currentWorkDetailsRepository.save(currentWorkDetails);

    }
}
