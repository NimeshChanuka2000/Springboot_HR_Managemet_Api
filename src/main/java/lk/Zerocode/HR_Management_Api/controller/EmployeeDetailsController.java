package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.BasicDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeDetailsController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/employees",headers = ("version=v1"))
    public void addEmployee(@RequestBody BasicDetailsDTO basicDetailsDTO){
        employeeService.addEmployee(basicDetailsDTO);
    }

    @GetMapping("/allSoftware")
    public ResponseEntity<List<BasicDetailsDTO>> getSoftwareEngineer(){
        return employeeService.getSoftwareEngineer();
    }

    @GetMapping("/notSoftware")
    public void getNotSoftwareEngineer(){
        employeeService.getNotSoftwareEngineer();
    }

    @GetMapping("/employee/{id}/details")
    public ResponseEntity<BasicDetailsDTO> getEmployeeDetails(@PathVariable Long id)throws EmployeeNotFoundException {
        return  employeeService.getEmployeeDetails(id);
    }

    @PutMapping("/employee/{id}/update")
    public void updateEmployeeDetails(@PathVariable  Long id,@RequestBody BasicDetailsDTO basicDetailsDTO)throws EmployeeNotFoundException{
        employeeService.updateEmployeeDetails(id, basicDetailsDTO);
    }

    @DeleteMapping("/employee/{id}/delete")
    public void deleteEmployee(@PathVariable Long id)throws EmployeeNotFoundException{
        employeeService.deleteEmployee(id);
    }

}
