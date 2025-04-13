package business.service.employee;

import business.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee findById(String id);
    List<Employee> findAll();
    boolean add(Employee employee);
    boolean update(Employee employee);
    boolean delete(Employee employee);
}