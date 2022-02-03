package dev.nhaiden.emptaskfrontend.database;

import dev.nhaiden.emptaskfrontend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Override
    List<Employee> findAll();
}
