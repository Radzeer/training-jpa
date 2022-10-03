package training.employees.employees.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.employees.employees.entity.Employee;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where LOWER(e.name) like :prefix")
    List<Employee> findEmployeeByPrefix(String prefix);

    //INFO: method név alapján elkészítia  qery-t
    List<Employee> findAllByNameLike(String prefix);
}
