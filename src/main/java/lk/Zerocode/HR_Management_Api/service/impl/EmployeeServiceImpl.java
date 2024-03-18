package lk.Zerocode.HR_Management_Api.service.impl;

import lk.Zerocode.HR_Management_Api.controller.dto.BasicDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.model.Employee;
import lk.Zerocode.HR_Management_Api.repository.EmployeeRepository;
import lk.Zerocode.HR_Management_Api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addEmployee(BasicDetailsDTO basicDetailsDTO) {

        Employee employee = modelMapper.map(basicDetailsDTO,Employee.class);
        employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<List<BasicDetailsDTO>> getSoftwareEngineer() {

        List<Employee> employeeList= employeeRepository.findAllSoftwareEngineer();
        List<BasicDetailsDTO> basicDetailsDTOList = new ArrayList<>();

        for (Employee employee : employeeList){

//          System.out.println("Employee_id:" + employee.getId() + " #name: " + employee.getName());
            BasicDetailsDTO basicDetailsDTO = modelMapper.map(employee,BasicDetailsDTO.class);
            basicDetailsDTOList.add(basicDetailsDTO);
        }

        return ResponseEntity.ok(basicDetailsDTOList);
    }

    @Override
    public void getNotSoftwareEngineer() {
        List<Employee> employeeList = employeeRepository.findAllNotSoftwareEngineer();
        for(Employee employee: employeeList){
            System.out.println("Employee_id:" + employee.getId() + " #name: " + employee.getName());
        }
    }

    @Override
    public ResponseEntity<BasicDetailsDTO> getEmployeeDetails(Long id) throws EmployeeNotFoundException {
//        Optional<Employee> employeeOptional = employeeRepository.findById(id);
//        Employee employee = employeeOptional.orElseThrow(() ->
//        new EmployeeNotFoundException("Employee not found with ID: " + id));

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID: " + id)
        );
        BasicDetailsDTO basicDetailsDTO = modelMapper.map(employee, BasicDetailsDTO.class);

        return ResponseEntity.ok(basicDetailsDTO);
    }

    @Override
    public void updateEmployeeDetails(Long id, BasicDetailsDTO basicDetailsDTO)throws EmployeeNotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee updateEmployee = employeeOptional.orElseThrow(() ->
        new EmployeeNotFoundException("Employee not found with ID: " + id));

        updateEmployee.setName(basicDetailsDTO.getName());
        updateEmployee.setAge(basicDetailsDTO.getAge());
        updateEmployee.setAddress(basicDetailsDTO.getAddress());

        employeeRepository.save(updateEmployee);

    }

    @Override
    public void deleteEmployee(Long id) throws EmployeeNotFoundException {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with ID: " + id)
        );
        employeeRepository.deleteById(id);
    }


}
