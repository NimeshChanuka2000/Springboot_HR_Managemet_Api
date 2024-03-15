package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.PreviousWorkHistoryDTO;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.PreviousWorkHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PreviousWorkHistoryController {

    private final PreviousWorkHistoryService previousWorkHistoryService;

    @PostMapping(value = "/employee/{id}/previousWorkHistory",headers = ("version=v1"))
    public void addPreviousWorkHistory(@PathVariable Long id, @RequestBody PreviousWorkHistoryDTO previousWorkHistoryDTO)throws EmployeeNotFoundException {

        previousWorkHistoryService.addPreviousWorkHistory(id, previousWorkHistoryDTO);

    }
}
