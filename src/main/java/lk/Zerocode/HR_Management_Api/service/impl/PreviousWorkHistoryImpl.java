package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.PreviousWorkHistoryDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.model.Employee;
import lk.Zerocode.HR_Management_Api.model.PreviousWorkHistory;
import lk.Zerocode.HR_Management_Api.repository.EmployeeRepository;
import lk.Zerocode.HR_Management_Api.repository.PreviousWorkHistoryRepository;
import lk.Zerocode.HR_Management_Api.service.PreviousWorkHistoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PreviousWorkHistoryImpl implements PreviousWorkHistoryService {

    private final PreviousWorkHistoryRepository previousWorkHistoryRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addPreviousWorkHistory(Long id, PreviousWorkHistoryDTO previousWorkHistoryDTO)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

            Employee employee = employeeOptional.orElseThrow(
                    () -> new EmployeeNotFoundException("Employee Not Found With ID :" + id)
            );

            PreviousWorkHistory previousWorkHistory = modelMapper.map(previousWorkHistoryDTO,PreviousWorkHistory.class);
            previousWorkHistory.setEmployee(employee);

            previousWorkHistoryRepository.save(previousWorkHistory);

    }
}
