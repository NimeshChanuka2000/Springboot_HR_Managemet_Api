package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.CurrentWorkDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.CurrentWorkDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrentWorkDetailsController {

    private final CurrentWorkDetailsService currentWorkDetailsService;

    @PostMapping(value = "/employee/{id}/currentWorkDetails", headers = ("version=v1"))
    public void addCurrentWorkDetails(@PathVariable Long id, @RequestBody CurrentWorkDetailsDTO currentWorkDetailsDTO)throws EmployeeNotFoundException {
        currentWorkDetailsService.addCurrentWorkDetails(id,currentWorkDetailsDTO);
    }
}
