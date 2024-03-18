package lk.Zerocode.HR_Management_Api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
    private List<CurrentWorkDetails> currentWorkDetails = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
    private List<PreviousWorkHistory> previousWorkHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
    private List<EducationQualification> educationQualifications = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
    private List<EmergencyContact> emergencyContacts = new ArrayList<>();
}
