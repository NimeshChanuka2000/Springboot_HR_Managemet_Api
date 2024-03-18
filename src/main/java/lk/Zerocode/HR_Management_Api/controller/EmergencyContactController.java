package lk.Zerocode.HR_Management_Api.controller;

import lk.Zerocode.HR_Management_Api.controller.dto.EmergencyContactDTO;
import lk.Zerocode.HR_Management_Api.exception.ContactNotFoundException;
import lk.Zerocode.HR_Management_Api.exception.EmployeeNotFoundException;
import lk.Zerocode.HR_Management_Api.service.EmergencyContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    @PostMapping(value = "/employee/{id}/contacts",headers = ("version=v1"))
    public void addEmergencyContact(@PathVariable Long id, @RequestBody EmergencyContactDTO contactDTO)throws EmployeeNotFoundException {
        emergencyContactService.addEmergencyContact(id, contactDTO);
    }
    @PutMapping("/employee/{eid}/contact/{cid}/update")
    public void updateEmergencyContact(@PathVariable Long eid,@PathVariable Long cid,@RequestBody EmergencyContactDTO emergencyContactDTO)throws EmployeeNotFoundException, ContactNotFoundException {
        emergencyContactService.updateEmergencyContact(eid,cid, emergencyContactDTO);
    }
}
