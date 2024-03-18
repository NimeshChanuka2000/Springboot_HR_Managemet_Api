package lk.Zerocode.HR_Management_Api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Previous_Work_History")
public class PreviousWorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String previousCompany;

    private String previousPosition;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
