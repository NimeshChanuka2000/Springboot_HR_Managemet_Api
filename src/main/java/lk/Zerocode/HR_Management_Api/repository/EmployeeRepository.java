package lk.Zerocode.HR_Management_Api.repository;

import lk.Zerocode.HR_Management_Api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("FROM Employee e LEFT join EducationQualification eq ON e.id= eq.employee.id WHERE eq.otherQualification='Java Springboot'")
    List<Employee> findAllSoftwareEngineer();

    @Query("FROM Employee e LEFT JOIN CurrentWorkDetails cw ON e.id= cw.employee.id WHERE cw.employee.id IS NULL OR cw.position != 'Software Engineer'")
    List<Employee> findAllNotSoftwareEngineer();
}
