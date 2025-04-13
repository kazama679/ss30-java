package business.dao.employee;

import business.model.Employee;
import business.service.AppService;

import java.util.List;

public interface EmployeeDao extends AppService<Employee> {
    Employee findById(String id);
    List<Employee> findAll();
    boolean add(Employee employee);
    boolean update(Employee employee);
    boolean delete(Employee employee);
}