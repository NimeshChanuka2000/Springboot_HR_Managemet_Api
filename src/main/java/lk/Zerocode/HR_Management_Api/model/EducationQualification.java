package lk.Zerocode.HR_Management_Api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Qualification",
        indexes = {
                @Index(name = "idx_oth_qualification", columnList = "other_qualification")
        })
public class EducationQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mainQualification;

    private String otherQualification;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
