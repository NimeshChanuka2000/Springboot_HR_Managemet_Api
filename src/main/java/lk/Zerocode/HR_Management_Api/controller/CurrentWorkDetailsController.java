package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.CurrentWorkDetailsDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.CurrentWorkDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrentWorkDetailsController {

    private final CurrentWorkDetailsService currentWorkDetailsService;

    @PostMapping(value = "/employee/{id}/currentWorkDetails", headers = ("version=v1"))
    public void addCurrentWorkDetails(@PathVariable Long id, @RequestBody CurrentWorkDetailsDTO currentWorkDetailsDTO)throws EmployeeNotFoundException {
        currentWorkDetailsService.addCurrentWorkDetails(id,currentWorkDetailsDTO);
    }
    @PutMapping(value = "/employee/{eid}/currentWork/{cid}/update",headers = ("version = v1"))
    public void updateCurrentWorkDetails(@PathVariable Long eid,@PathVariable Long cid,@RequestBody CurrentWorkDetailsDTO currentWorkDetailsDTO){


    }
}
