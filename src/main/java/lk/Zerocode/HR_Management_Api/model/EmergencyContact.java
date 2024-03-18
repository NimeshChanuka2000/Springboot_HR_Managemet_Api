package lk.Zerocode.HR_Management_Api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "emergency_contact")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String homeContactNum;

    private String bloodGroup;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
